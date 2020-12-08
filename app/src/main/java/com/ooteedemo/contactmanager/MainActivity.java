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


        List<Contact> contactList = db.getAllContacts();
        for (Contact contact: contactList) {
            Log.d("DBHandler", "getting all contacts: "+contact.getId()+contact.getName());
        }

    }
}