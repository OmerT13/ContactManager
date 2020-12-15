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

//        testCreateContact(db);
//        testUpdateContact(db);
//        testDeleteContact(1,db);

        /*db.addContact(new Contact("John","0148372845"));
        db.addContact(new Contact("Jane","012948374"));
        db.addContact(new Contact("Joseph","01297546"));
        db.addContact(new Contact("Jeremy","011948374"));*/


        List<Contact> contactList = db.getAllContacts();
        for (Contact contact: contactList) {
            Log.d("DBHandler All Contacts", "getting all contacts: "+contact.getId()+contact.getName());
        }

        Log.d("DBHandler Count", "onCreate: "+db.getCount());
    }

    private void testCreateContact(DatabaseHandler db) {
        Contact jeremy = new Contact();
        jeremy.setName("Jeremy");
        jeremy.setPhoneNumber("0134456543");
        db.addContact(jeremy);
    }

    private void testUpdateContact(DatabaseHandler db) {
        Contact c = db.getContact(2);
        Log.d("DBHandler One Contact", "Getting One Contact: " + c.getName() + " | " + c.getPhoneNumber());
        c.setName("OriginalJeremy");
        c.setPhoneNumber("619092");
        int updateRow = db.updateContact(c);
        Log.d("DBHandler", "Update Rowid: "+updateRow);
    }

    private void testDeleteContact(int ContactId, DatabaseHandler db) {
        Contact d = db.getContact(ContactId);
        db.deleteContact(d);
        Log.d("DBHandler", "Delete Contact: "+d.getName());
    }
}