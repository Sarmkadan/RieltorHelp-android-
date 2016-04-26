package com.example.sarmkadan.rieltorhelper;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.example.sarmkadan.rieltorhelper.adapters.EntityAdapter;
import com.example.sarmkadan.rieltorhelper.databases.DbHelper;
import com.example.sarmkadan.rieltorhelper.databases.dbExceptions.NoSuchTableInDbException;
import com.example.sarmkadan.rieltorhelper.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class ViewInfoActivity extends AppCompatActivity {

    private Spinner spinner;
    private GridView gridView;
    private String tableSelected;
    private List<Entity> entities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);

        //находим спиннер
        spinner = (Spinner) findViewById(R.id.spinner2);
        //создаем из ресурсов адаптер
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tablesFromDb,
                android.R.layout.simple_spinner_item);
        //определяем разметку
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //применяем адаптер к спиннеру
        spinner.setAdapter(adapter);

        //обработчик выбора спиннера
        spinner.setOnItemSelectedListener(new SpinnerOnItemSelectedListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class SpinnerOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //получаем массив строк, где записаны элементы спиннера
            String[] tablesFromDb = getResources().getStringArray(R.array.tablesFromDb);
            //выбранная позиция в спиннере равна той таблице, которая записана в полученном массиве
            tableSelected = tablesFromDb[position];

            //вытаскиваем из БД данные из выбранной таблицы

            //получаем коннект к БД
            DbHelper dbHelper = new DbHelper(getApplicationContext());
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            try {
                entities = dbHelper.getEntitiesList(db, tableSelected);
            } catch (NoSuchTableInDbException | SQLiteException e) {
                entities = new ArrayList<>(); //пустой список на случай исключения
            }

            //строим список из вытащенных сущностей
            gridView = (GridView) findViewById(R.id.gridView);
            gridView.setAdapter(new EntityAdapter(getApplicationContext(), entities));

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}
