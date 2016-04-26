package com.example.sarmkadan.rieltorhelper;
/**
 * @author Kotov Alexandr
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sarmkadan.rieltorhelper.utils.HttpRequest;


public class SyncActivity extends AppCompatActivity {
    private Button btnSync;
    private TextView outView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);

        // наша  кнопка
        btnSync = (Button) findViewById(R.id.btnSync);
        // текстовое поле
        outView = (TextView) findViewById(R.id.synTextView);
        outView.setText("Проверка работы кнопки");

        // обработчик
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= HttpRequest.getRequest("http://mydefence.h1n.ru/script/?op=set&userid=2");
                outView.setText(s);

            }
        });


    }

}
