package com.example.maybe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<Tarikh> dte = new ArrayList<>();
    ArrayList<Tarikh.Trans> tdte = new ArrayList<>();
    private EditText editText1, editText2, totalToday;
    private TextView textView, textView2, textView3;
    private Button button, button2;
    int d = 0, i = 0;
    double totalCost = 0.0, left;
    String valueToday;
    String systemDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        systemDate = DateFormat.getDateInstance().format(calendar.getTime());

        totalToday = findViewById(R.id.totalTodayID);
        textView = findViewById(R.id.textViewID);
        textView2 = findViewById(R.id.textView2ID);
        textView3 = findViewById(R.id.textView3ID);
        button = findViewById(R.id.buttonID);
        button2 = findViewById(R.id.button2ID);
        editText1 = findViewById(R.id.editText1ID);
        editText2 = findViewById(R.id.editText2ID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueToday = totalToday.getText().toString();
                String value = editText1.getText().toString();
                String value2 = editText2.getText().toString();
                double valueD = Double.parseDouble(value2);
                tdte.add(new Tarikh.Trans(value, valueD));
                totalCost();
                leftMoney();
                dte.add(new Tarikh(systemDate, Double.parseDouble(valueToday), totalCost, left));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }
    private void totalCost(){
            totalCost += tdte.get(i).cost;
            i++;

    }
    private void leftMoney(){
        left = Double.parseDouble(valueToday) - totalCost;
    }
    private void show(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < tdte.size(); i++){
            stringBuilder.
                    append(tdte.get(i).description).
                    append("\t\t").
                    append(tdte.get(i).cost).
                    append("\n");
        }
        textView2.setText(stringBuilder.toString());
        textView3.setText("Total cost Today: " + dte.get(dte.size() - 1).totalCost + "   Date: " + dte.get(dte.size() - 1).currentDate);
        textView.setText("left: " +  String.valueOf(dte.get(dte.size() - 1).left));

    }
}
