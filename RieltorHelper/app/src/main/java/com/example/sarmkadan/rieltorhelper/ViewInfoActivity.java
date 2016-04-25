package com.example.sarmkadan.rieltorhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sarmkadan.rieltorhelper.databases.DbHelper;
import com.example.sarmkadan.rieltorhelper.databases.dbExceptions.NoSuchTableInDbException;
import com.example.sarmkadan.rieltorhelper.entities.ArendRoom;

import java.util.ArrayList;

public class ViewInfoActivity extends AppCompatActivity {

    private Spinner spinner;
    private String tableSelected;

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
        //примеряем адаптер к спиннеру
        spinner.setAdapter(adapter);

        //обработчик
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //получаем массив строк, где записаны элементы спиннера
                String[] tablesFromDb = getResources().getStringArray(R.array.tablesFromDb);
                //выбранная позиция в спиннере равна той таблице, которая записана в полученном массиве
                tableSelected = tablesFromDb[position];

                //вытаскиваем из БД данные из выбранной таблицы

                //тестовое вытаскивание данных из таблины ArendRoom
                DbHelper dbHelper = new DbHelper(getApplicationContext());
                ArrayList<ArendRoom> arendRooms;

                try {
                    arendRooms = dbHelper.getArendRoom(dbHelper.getReadableDatabase());
                } catch (NoSuchTableInDbException e) {
                    e.printStackTrace();
                }
                //вывод на экран


                //конец тестовой шляпы

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
}
