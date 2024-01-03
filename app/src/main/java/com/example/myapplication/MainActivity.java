package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private double firstValue = 0, secondValue = 0;
    private String currentOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonDecimal = findViewById(R.id.buttonDecimal);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonEquals = findViewById(R.id.buttonEquals);

        View.OnClickListener buttonClickListener = v -> {
            Button button = (Button) v;
            result.append(button.getText());
        };

        button0.setOnClickListener(buttonClickListener);
        button1.setOnClickListener(buttonClickListener);
        button2.setOnClickListener(buttonClickListener);
        button3.setOnClickListener(buttonClickListener);
        button4.setOnClickListener(buttonClickListener);
        button5.setOnClickListener(buttonClickListener);
        button6.setOnClickListener(buttonClickListener);
        button7.setOnClickListener(buttonClickListener);
        button8.setOnClickListener(buttonClickListener);
        button9.setOnClickListener(buttonClickListener);
        buttonDecimal.setOnClickListener(buttonClickListener);

        View.OnClickListener operatorClickListener = v -> {
            Button button = (Button) v;
            currentOperator = button.getText().toString();
            firstValue = Double.parseDouble(result.getText().toString());
            result.setText("");
        };

        buttonAdd.setOnClickListener(operatorClickListener);
        buttonSubtract.setOnClickListener(operatorClickListener);
        buttonMultiply.setOnClickListener(operatorClickListener);
        buttonDivide.setOnClickListener(operatorClickListener);

        buttonClear.setOnClickListener(v -> {
            result.setText("");
            firstValue = 0;
            secondValue = 0;
            currentOperator = "";
        });

        buttonEquals.setOnClickListener(v -> {
            if (!currentOperator.isEmpty()) {
                secondValue = Double.parseDouble(result.getText().toString());
                double resultValue = 0;

                switch (currentOperator) {
                    case "+":
                        resultValue = firstValue + secondValue;
                        break;
                    case "-":
                        resultValue = firstValue - secondValue;
                        break;
                    case "*":
                        resultValue = firstValue * secondValue;
                        break;
                    case "/":
                        resultValue = firstValue / secondValue;
                        break;
                }

                result.setText(String.valueOf(resultValue));
                currentOperator = "";
            }
        });
    }
}