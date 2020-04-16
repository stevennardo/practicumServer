package com.example.demo;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class DataManipulation {

    FileManipulation alterFile = new FileManipulation();
    ArrayList<Contact> DataCollection = alterFile.extract();

    public void store(Contact request) {

        DataCollection.add(request);
        
        // to file
        alterFile.overwrite(DataCollection);
    }

    public void update(Contact request) { // todo

        // DataCollection UPDATE NEED SAME ID AS EXISTING CONTACT
        for (int i = 0; i < DataCollection.size(); i++) {
            if ((DataCollection.get(i).id).equals(request.id)) {
                delete(DataCollection.get(i).id);
                store(request);
            }
        }
        //Don't need to write to file, it is done in the store() fcn
    }

    public void delete(String id) throws IndexOutOfBoundsException {

        // DataCollection DELETE
        for (int i = 0; i < DataCollection.size(); i++) {
            if ((DataCollection.get(i).id).equals(id)) {
                DataCollection.remove(i);
            }
        }

        // to file
        alterFile.overwrite(DataCollection);
    }

    public ArrayList<Contact> fetch() {
        
        return alterFile.extract();
    }
}
