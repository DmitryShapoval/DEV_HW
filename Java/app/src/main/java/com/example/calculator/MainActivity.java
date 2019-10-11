package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView resultField; // текстовое поле для вывода результата
    EditText numberField;   // поле для ввода числа
    TextView operationField;    // текстовое поле для вывода знака операции
    Double operand = null;  // операнд операции
    String lastOperation = "="; // последняя операция
    Button clearDisplay;
    static Boolean check = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // получаем все поля по id из activity_main.xml
        resultField =(TextView) findViewById(R.id.resultField);
        numberField = (EditText) findViewById(R.id.numberField);
        operationField = (TextView) findViewById(R.id.operationField);
        clearDisplay = (Button) findViewById(R.id.button);
        resultField.setText("0");
        numberField.setText("0");

        clearDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText("0");
                operationField.setText("");
                numberField.setText("0");
                check = true;
                operand = null;
            }
        });
    }
    // сохранение состояния
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("OPERATION", lastOperation);
        if(operand!=null)
            outState.putDouble("OPERAND", operand);
        super.onSaveInstanceState(outState);
    }
    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getString("OPERATION");
        operand= savedInstanceState.getDouble("OPERAND");
        resultField.setText(operand.toString());
        operationField.setText(lastOperation);
    }
    // обработка нажатия на числовую кнопку
    public void onNumberClick(View view){

        Button button = (Button)view;
        if(check){
            numberField.setText("");
            numberField.append(button.getText());
            check = false;
        }else{
            numberField.append(button.getText());
        }
        cutDisplay(numberField.getText().toString());
        if(lastOperation.equals("=") && operand!=null){
            operand = null;
        }
    }

    // обработка нажатия на кнопку операции
    public void onOperationClick(View view){

        Button button = (Button)view;
        String op = button.getText().toString();
        String number = numberField.getText().toString();
        // если введенно что-нибудь
        if(number.length()>0){
            try{
                performOperation(Double.valueOf(number), op);
            }catch (NumberFormatException ex){
                numberField.setText("");
            }
        }
        lastOperation = op;
        operationField.setText(lastOperation);
        check = true;
    }

    private void performOperation(Double number, String operation){

        // если операнд ранее не был установлен (при вводе самой первой операции)
        if(operand ==null){
            operand = number;
        }
        else{
            if(lastOperation.equals("=")){
                lastOperation = operation;
            }
            switch(lastOperation){
                case "=":
                    operand = number;
                    break;
                case "/":
                    if(number==0){
                        operand = 0.0;
                    }
                    else{
                        operand = div(operand,number);
                    }
                    break;
                case "*":
                    operand = mult(operand,number);
                    break;
                case "+":
                    operand = summ(operand,number);
                    break;
                case "-":
                    operand  = min(operand,number);
                    break;
            }
        }
        resultField.setText(operand.toString());

        numberField.setText(operand.toString());
        String a = cutDisplay(numberField.getText().toString());
    }

    public static double summ(double a, double b){
        a += b;
        return a;
    }
    public double mult(double a, double b){
        a *= b;
        return a;
    }
    public double div(double a, double b){
        a /= b;
        return a;
    }
    public double min(double a, double b){
        a -= b;
        return a;
    }

    public String cutDisplay(String text ){
        char[] a = text.toCharArray();
        String first = "";
        if( a.length < 9){
            return text;
        }else{
            for(int i = 0; i < 9; i++){
                first += a[i];
            }
        }
        numberField.setText(first);
        return first;
    }
}
