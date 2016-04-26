package com.example.sarmkadan.rieltorhelper.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.sarmkadan.rieltorhelper.entities.Entity;

import java.util.List;

/**
 * Created by Abilis on 26.04.2016.
 */
public class EntityAdapter extends BaseAdapter {

    private Context context;
    private List<Entity> entities;

    public EntityAdapter(Context context, List<Entity> entities) {
        this.context = context;
        this.entities = entities;
    }

    @Override
    public int getCount() {
        return entities.size();
    }

    @Override
    public Object getItem(int position) {
        return entities.get(position);
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
            button.setText(entities.get(position).toString());
        }
        else {
            button = (Button) convertView;
        }
        button.setId(position);

        return button;
    }
}
