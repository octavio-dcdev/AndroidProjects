package com.theironyard.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> contacts;

    ListView list;
    EditText text;
    EditText text1;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        text1 = (EditText) findViewById(R.id.editText1);
        addButton = (Button) findViewById(R.id.button);

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1); //might need to change to item instead of contacts idk
        list.setAdapter(contacts);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String item = text.getText().toString() + " (" + text1.getText().toString() + ")";
        contacts.add(item);
        text.setText("");
        text1.setText("");
    }

    @Override
    public boolean onItemLongClick (AdapterView < ? > parent, View view,int position, long id){
        String item = contacts.getItem(position);
        contacts.remove(item);
        return true;
    }
}
