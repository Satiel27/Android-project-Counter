package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;
    private EditText mCounter;

    private static final String TAG = "myLogs";

    //Сохранение настроек
    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mSettings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButtonListener();

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);



    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "кнопка Minus успешно нажата");

        Save newSave = new Save();
        int IntCounter = Integer.parseInt(String.valueOf(mCounter.getText()));

        int ICount  = newSave.ReadCounter(APP_PREFERENCES_COUNTER, mSettings, IntCounter);
        mCounter.setText(Integer.toString(ICount));

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "кнопка Х успешно нажата");

        Save newSave = new Save();
        int IntCounter = Integer.parseInt(String.valueOf(mCounter.getText()));
        newSave.SaveCounter(APP_PREFERENCES_COUNTER, mSettings, IntCounter);


    }

    
    public void addButtonListener(){

        ButtonListener listener = new ButtonListener(this);

        btn1 = (Button) findViewById(R.id.CountMinus);
        btn2 = (Button) findViewById(R.id.CountPlus);
        mCounter = (EditText) findViewById(R.id.CounterNumber);
        listener.setbtnMinus(btn1);
        listener.setbtnPlus(btn2);

        mCounter.setText("0");
        listener.setbtnNumber(mCounter);

        listener.setButtonListener();

    }



}
