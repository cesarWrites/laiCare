package com.example.laicare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import static android.widget.TabHost.*;

public class Main2Activity extends AppCompatActivity {
      TabHost host;
      ListView listView;
      String[] items = {"Bitcoin","Ethereum","LiteCoin","Dash"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "position:"+itemPosition+" Item Clicked: "+itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });
        host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

      TabHost. TabSpec spec = host.newTabSpec("Hospitals");
        spec.setContent(R.id.HOSPITALS);
        spec.setIndicator("Hospitals");
        host.addTab(spec);

        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.CONTACTS);
        spec.setIndicator("Tab One");
        host.addTab(spec);

        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tab Three");
        host.addTab(spec);
    }
}
