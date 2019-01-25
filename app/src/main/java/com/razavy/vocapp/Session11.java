package com.razavy.vocapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Session11 extends AppCompatActivity {
    private String baseUrl = "https://translate.google.com/#view=home&op=translate&sl=en&tl=fa&text=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Vocabulary> vocabularies = new ArrayList<>();
        vocabularies.add(new Vocabulary("bothering", "I can talk to her about stuff that's bothering  me at work."));
        vocabularies.add(new Vocabulary("We have our ups and downs", "We have our ups and downs of course, but basically we have an easy relationship."));
        vocabularies.add(new Vocabulary("attitude", "What I like about her is her attitude."));
        vocabularies.add(new Vocabulary("quite young at heart", "She's quite young at heart"));
        vocabularies.add(new Vocabulary("old-fashioned", "The place became so quiet, you could hear an old-fashioned timer clock ticking in the kitchen."));

        VocabularyAdapter adapter = new VocabularyAdapter(this, vocabularies);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Vocabulary vocab = vocabularies.get(position);
                Uri url = Uri.parse(baseUrl + vocab.getVocabulary().trim());
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
