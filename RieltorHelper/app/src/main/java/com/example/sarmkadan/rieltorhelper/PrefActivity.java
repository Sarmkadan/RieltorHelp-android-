package com.example.sarmkadan.rieltorhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrefActivity extends AppCompatActivity {

    private Button btnExport;
    private Button btnClearCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        // определям кнопки что бы можно было повесить обработчики
        btnExport = (Button) findViewById(R.id.btnExport);
        btnClearCache = (Button) findViewById(R.id.btnClearCach);

        btnExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrefActivity.this, SyncActivity.class);
                startActivity(intent);
            }
        });

    }

}
