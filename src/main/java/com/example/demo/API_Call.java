package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin(origins = "*")
public class API_Call {

    private final DataManipulation manipulate;

    public API_Call(DataManipulation manipulate) {
        this.manipulate = manipulate;
    }
    
    @PostMapping("create")
    public String Create(@RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "number", required = true) String number,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "address", required = true) String address,
            @RequestParam(value = "city", required = true) String city,
            @RequestParam(value = "state", required = true) String state,
            @RequestParam(value = "zip", required = true) String zip,
            @RequestParam(value = "bday", required = true) String bday,
            @RequestParam(value = "linked", required = true) String linked) {

        Contact newContact = new Contact(id, name, number, email, address, city, state, zip, bday, linked);

        manipulate.store(newContact);

        Gson gson = new Gson();
        return gson.toJson("SERVER: Success");
    }

    @GetMapping("fetch")
    public String Fetch() {

        Gson gson = new Gson();

        return gson.toJson(manipulate.fetch());
    }

    @DeleteMapping("delete")
    public String Delete(@RequestParam(value = "id", required = true) String id) {

        manipulate.delete(id);
        
        Gson gson = new Gson();
        return gson.toJson("SERVER: Deleted Contact " + id);
    }

    @GetMapping("update")
    public String Update(@RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "number", required = true) String number,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "address", required = true) String address,
            @RequestParam(value = "city", required = true) String city,
            @RequestParam(value = "state", required = true) String state,
            @RequestParam(value = "zip", required = true) String zip,
            @RequestParam(value = "bday", required = true) String bday,
            @RequestParam(value = "linked", required = true) String linked) {

        Contact updatedContact = new Contact(id, name, number, email, address, city, state, zip, bday, linked);

        manipulate.update(updatedContact);
        
        Gson gson = new Gson();
        return gson.toJson("SERVER: Updated");
    }

}
