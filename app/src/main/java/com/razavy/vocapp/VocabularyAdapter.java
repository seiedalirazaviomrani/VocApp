package com.razavy.vocapp;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class VocabularyAdapter extends ArrayAdapter<Vocabulary> {

    private static final String LOG_TAG = VocabularyAdapter.class.getSimpleName();
    private TextToSpeech tts;

    public VocabularyAdapter(Context context, List vocabularies) {
        super(context, 0, vocabularies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        tts = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.UK);
                } else {
                    Toast.makeText(getContext(), "TextToSpeech in UK not supported in your device", Toast.LENGTH_SHORT).show();
                }
            }
        });

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.vocab_list_items, parent, false);
        }

        final Vocabulary currentItem = getItem(position);
        TextView vocabTextView = listItemView.findViewById(R.id.englishVocabulary);
        vocabTextView.setText(currentItem.getVocabulary());
        ImageButton playBtn = listItemView.findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speechTheText(currentItem.getVocabulary().trim());
            }
        });
        return listItemView;
    }

    private void speechTheText(String textToSpeech) {
        Log.i(LOG_TAG, "Text to Speech: " + textToSpeech);
        tts.speak(textToSpeech, TextToSpeech.QUEUE_FLUSH, null, null);
    }
}
