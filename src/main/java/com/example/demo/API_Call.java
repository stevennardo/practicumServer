package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class API_Call {

    private final DataManipulation manipulate;

    public API_Call(DataManipulation manipulate) {
        this.manipulate = manipulate;
    }
    
    @GetMapping("create")
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

        return "SERVER: Success";
    }

    @GetMapping("fetch")
    public String Fetch() {

        Gson gson = new Gson();

        return gson.toJson(manipulate.fetch());
    }

    @GetMapping("delete")
    public String Delete(@RequestParam(value = "id", required = true) String id) {

        manipulate.delete(id);
        
        return "SERVER: Deleted Contact";
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
        
        return "SERVER: Updated";
    }

}
