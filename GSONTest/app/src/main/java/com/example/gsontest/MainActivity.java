package com.example.gsontest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gsontest.Adapters.CardAdapter;
import com.example.gsontest.SQLite.DBHelper;
import com.example.gsontest.dto.DataDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<DataDTO> data = new ArrayList<>();
    private CardAdapter adapter;
    private DBHelper dbHelper;

    public void setData(List<DataDTO> data) {
        this.data = data;

        CardAdapter.setData(data);

        refreshData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyLog", "startOnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        data = loadData();

        adapter = new CardAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private List<DataDTO> loadData() {
        List<DataDTO> data = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(DBHelper.TABLE_RIELTORS, null, null, null, null, null, null);

        if (cursor.moveToFirst()){
            int fioIndex = cursor.getColumnIndex(DBHelper.KEY_FIO);
            int phoneIndex = cursor.getColumnIndex(DBHelper.KEY_PHONE);
            int aboutIndex = cursor.getColumnIndex(DBHelper.KEY_ABOUT);

            do {
                DataDTO item = new DataDTO();
                item.setFio(cursor.getString(fioIndex));
                item.setPhone(cursor.getString(phoneIndex));
                item.setAbout(cursor.getString(aboutIndex));

                data.add(item);
            }while (cursor.moveToNext());
            cursor.close();
        }

        dbHelper.close();
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                new MyTask().execute();
        }

        return super.onOptionsItemSelected(item);
    }

    public class MyTask extends AsyncTask<Void, Void, List<DataDTO>> {
        String resp;

        public List<DataDTO> parse(String json) {

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            Type datasetListType = new TypeToken<Collection<DataDTO>>() {
            }.getType();

            List<DataDTO> data = gson.fromJson(json, datasetListType);
            return data;
        }

        @Override
        protected List<DataDTO> doInBackground(Void... voids) {
            Log.d("MyLog", "start doInBackground");

            try {
                DefaultHttpClient hc = new DefaultHttpClient();
                ResponseHandler responce = new BasicResponseHandler();
                HttpGet get = new HttpGet("http://getshexml.azurewebsites.net/Client.svc/GetClientsJsonDummy");

                try {
                    resp = (String) hc.execute(get, responce);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                Log.d("MyLog", e.toString());
            }

            return parse(resp);
        }

        @Override
        protected void onPostExecute(List<DataDTO> dataDTOs) {
            setSQLiteData(dataDTOs);
        }
    }

    public void setSQLiteData(List<DataDTO> data){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DBHelper.TABLE_RIELTORS, null, null);
        ContentValues contentValues = new ContentValues();

        for (DataDTO item : data){
            contentValues.put(DBHelper.KEY_FIO, item.getFio());
            contentValues.put(DBHelper.KEY_PHONE, item.getPhone());
            contentValues.put(DBHelper.KEY_ABOUT, item.getAbout());

            db.insert(DBHelper.TABLE_RIELTORS, "-", contentValues);
        }

        dbHelper.close();
        getSQLiteData();
    }

    public void getSQLiteData(){
        List<DataDTO> data = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(DBHelper.TABLE_RIELTORS, null, null, null, null, null, null);

        if (cursor.moveToFirst()){
            int fioIndex = cursor.getColumnIndex(DBHelper.KEY_FIO);
            int phoneIndex = cursor.getColumnIndex(DBHelper.KEY_PHONE);
            int aboutIndex = cursor.getColumnIndex(DBHelper.KEY_ABOUT);

            do {
                DataDTO item = new DataDTO();
                item.setFio(cursor.getString(fioIndex));
                item.setPhone(cursor.getString(phoneIndex));
                item.setAbout(cursor.getString(aboutIndex));

                data.add(item);
            }while (cursor.moveToNext());
            cursor.close();
        }

        dbHelper.close();
        setData(data);
    }

    public void refreshData() {
        adapter.notifyDataSetChanged();
    }
}


