package com.example.sarmkadan.rieltorhelper;
/**
 * @author Kotov Alexandr
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


public class SyncActivity extends AppCompatActivity {
    private Button btnSync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);

        // наша  кнопка
        btnSync = (Button) findViewById(R.id.btnSync);


    }

}
