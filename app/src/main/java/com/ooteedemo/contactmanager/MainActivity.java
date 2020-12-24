package com.ooteedemo.contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ooteedemo.contactmanager.adapter.RecyclerViewAdapter;
import com.ooteedemo.contactmanager.data.DatabaseHandler;
import com.ooteedemo.contactmanager.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private ListView listView;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactArrayList = new ArrayList<>();
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        List<Contact> contactList = db.getAllContacts();
        for (Contact contact: contactList) {
            Log.d("DBHandler All Contacts", "getting all contacts: "+contact.getId()+contact.getName());
            contactArrayList.add(contact);
        }

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);




//        listViewHandling(db);

    }

    /*private void listViewHandling(DatabaseHandler db) {
        //        Create Array Adapter
        arrayAdapter = new ArrayAdapter<Object>(
          this,android.R.layout.simple_list_item_1, contactArrayList
        );

//        Use the adapter to display the data into our listView
        listView.setAdapter(arrayAdapter);

//        Attach an event listener to the listView items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("ListView", "onItemClick: "+ contactArrayList.get(position));
            }
        });

        Log.d("DBHandler Count", "onCreate: "+db.getCount());
    }*/

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