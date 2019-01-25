package com.razavy.vocapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ArrayList<String> sessions = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            sessions.add("Session " + i);
        }
        ArrayAdapter<String> sessionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sessions);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(sessionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int session, long id) {
                Intent intent = null;
                switch (session + 1) {
                    case 11:
                        intent = new Intent(getApplicationContext(), Session11.class);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "The session " + (session + 1) + " isn't ready yet! Please try again later.", Toast.LENGTH_SHORT).show();
                }
                if (intent != null)
                    startActivity(intent);
            }
        });
    }
}
