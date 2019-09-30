package com.example.counter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Interfaces.ILogcat;

public class ButtonListener implements ILogcat {

    private final Context context;
    private Button btnMinus, btnPlus;
    private EditText btnNumber;


    public ButtonListener(Context context){
        this.context = context;
    }

    public void setButtonListener(){



        btnMinus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            int counter = Integer.parseInt(String.valueOf(btnNumber.getText()));

                            if (counter > 0) {
                                counter--;
                            }

                            btnNumber.setText(Integer.toString(counter));

                            Toast.makeText(context,"Уменьшено -1", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "кнопка Minus успешно нажата");

                        } catch (NumberFormatException e) {
                            Log.d(TAG, "Ошибка.кнопка Minus. ButtonListener - setButtonListener", e);
                        }
                    }
                }
        );

        btnPlus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            int counter = Integer.parseInt(String.valueOf(btnNumber.getText()));
                            counter++;
                            btnNumber.setText(Integer.toString(counter));

                            Toast.makeText(context,"Увеличенно +1", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "кнопка Plus успешно нажата");

                        } catch (NumberFormatException e) {
                            Log.d(TAG, "Ошибка.кнопка Plus. ButtonListener - setButtonListener", e);
                        }
                    }
                }
        );

    }


    //Get and Set
    public void setbtnMinus(Button btn1) {
        this.btnMinus = btn1;
    }

    public Button getbtnMinus() {
        return btnMinus;
    }

    public void setbtnPlus(Button btn2) {
        this.btnPlus = btn2;
    }

    public Button getbtnPlus() {
        return btnPlus;
    }

    public void setbtnNumber(EditText btnCounter) {
        this.btnNumber = btnCounter;
    }

    public EditText getbtnNumber() {
        return btnNumber;
    }
    //------------------------------//

}
