package com.razavy.vocapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SessionAdapter extends ArrayAdapter<Session> {
    public SessionAdapter(Context context, List<Session> sessions) {
        super(context, 0, sessions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;
        if (listViewItem == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.session_list_items, parent, false);
        }
        Session currentSession = getItem(position);
        ImageView sessionImg = listViewItem.findViewById(R.id.sessionImg);
        sessionImg.setImageResource(R.drawable.baseline_import_contacts_black_48);
        TextView sessionName = listViewItem.findViewById(R.id.sessionName);
        sessionName.setText(currentSession.getSessionName());
        TextView sessionDescription = listViewItem.findViewById(R.id.sessionDescription);
        sessionDescription.setText(currentSession.getSessionDescription());

        return listViewItem;
    }
}
