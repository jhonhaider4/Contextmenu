package com.example.layoutdemo.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
    String items[]={"Person 1","Person2","Person 3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("select Option");
        menu.add(0,v.getId(),0,"Call");
        menu.add(0,v.getId(),0,"Message");
        menu.add(0,v.getId(),0,"Mail");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle()=="Call"){
            Toast.makeText(this,"Call:selected",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="Message"){
            Toast.makeText(this,"Message:selected",Toast.LENGTH_LONG).show();
        }

        return super.onContextItemSelected(item);
    }
}
