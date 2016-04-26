package com.example.sarmkadan.rieltorhelper.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.sarmkadan.rieltorhelper.entities.ArendRoom;

import java.util.List;

/**
 * Created by Abilis on 26.04.2016.
 */
public class ArendRoomAdapter extends BaseAdapter {

    private Context context;
    private List<ArendRoom> arendRooms;

    public ArendRoomAdapter(Context context, List<ArendRoom> arendRooms) {
        this.context = context;
        this.arendRooms = arendRooms;
    }

    @Override
    public int getCount() {
        return arendRooms.size();
    }

    @Override
    public Object getItem(int position) {
        return arendRooms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Button button;
        if (convertView == null) {
            button = new Button(context);
            button.setText(arendRooms.get(position).toString());
        }
        else {
            button = (Button) convertView;
        }
        button.setId(position);

        return button;
    }
}
