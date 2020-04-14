package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FileManipulation {

    public ArrayList<Contact> extract() {
        ArrayList<Contact> fromFile = new ArrayList<>();

        File dataFile = new File("data.txt");

        if (dataFile.exists()) {
            String content = "";
            try {
                content = read();
            } catch (IOException e) {
                // TODO Auto-generated catch block

            }
            Gson gson = new Gson();

            fromFile = gson.fromJson(content, new TypeToken<List<Contact>>() {
            }.getType());

        } else {
            Contact temp = new Contact("DNE");
            fromFile.add(temp);
        }

        return fromFile;
    }

    public void overwrite(ArrayList<Contact> DataCollection) {
        File file = new File("data.txt");
        FileWriter writer = null;
        Gson gson = new Gson();

        String jsonString = gson.toJson(DataCollection);

        try {
            writer = new FileWriter(file, false);
            writer.write(jsonString);
        } catch (IOException e) {
        } finally {
            if (writer != null)
				try {
                writer.close();
            } catch (IOException ignore) {
            }
        }
    }

    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get("data.txt")));
    }
}
