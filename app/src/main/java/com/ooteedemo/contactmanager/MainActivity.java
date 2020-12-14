package com.ooteedemo.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ooteedemo.contactmanager.data.DatabaseHandler;
import com.ooteedemo.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Contact jeremy = new Contact();
        jeremy.setName("Jeremy");
        jeremy.setPhoneNumber("0134456543");
//        db.addContact(jeremy);

        Contact jason = new Contact();
        jason.setName("Jason");
        jason.setPhoneNumber("0193827384");
//        db.addContact(jason);

        Contact c = db.getContact(2);
        Log.d("DBHandler One Contact", "Getting One Contact: " + c.getName() + " | " + c.getPhoneNumber());
        c.setName("OriginalJeremy");
        c.setPhoneNumber("619092");
        int updateRow = db.updateContact(c);
        Log.d("DBHandler", "Update Rowid: "+updateRow);

        Contact d = db.getContact(7);
        db.deleteContact(d);
        Log.d("DBHandler", "Delete Contact: "+d.getName());


        List<Contact> contactList = db.getAllContacts();
        for (Contact contact: contactList) {
            Log.d("DBHandler All Contacts", "getting all contacts: "+contact.getId()+contact.getName());
        }
    }
}