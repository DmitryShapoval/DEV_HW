package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText numberField;   // поле для ввода числа
    Button clearDisplay;
    Button b0 ;
    Button b1 ;
    Button b2 ;
    Button b3 ;
    Button b4 ;
    Button b5 ;
    Button b6 ;
    Button b7 ;
    Button b8 ;
    Button b9 ;
    Button plus;
    Button minus;
    Button equal;
    Button divide;
    Button multiply;
    Button dot;
    double second;
    char operand;
    static Model model = new Model();
    static Logic logic = new Logic();
    public void setDisplay(String number)
    {
        numberField.setText(number);
    }
    public String getDisplay()
    {
        return numberField.getText().toString();
    }
    public void onOperationClick(char operand)
    {
        model.setMemoryNumber(Double.parseDouble(getDisplay()));
        model.setOperationClicked(operand);
        model.setIsCheck(true);
        model.setIsResult(true);
    }
    public void switchOperations(char getOperationClicked,double first,double second)
    {
        switch (getOperationClicked)
        {
            case '+':
                model.setMemoryNumber(logic.summ(first, second));
                break;
            case '-':
                model.setMemoryNumber(logic.minus(first, second));
                break;
            case '/':
                model.setMemoryNumber(logic.divide(first, second));
                break;
            case '*':
                model.setMemoryNumber(logic.multiply(first, second));
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // получаем все поля по id из activity_main.xml
        b1 = (Button) findViewById(R.id.one);
        b2 = (Button) findViewById(R.id.two);
        b3 = (Button) findViewById(R.id.three);
        b4 = (Button) findViewById(R.id.four);
        b5 = (Button) findViewById(R.id.five);
        b6 = (Button) findViewById(R.id.six);
        b7 = (Button) findViewById(R.id.seven);
        b8 = (Button) findViewById(R.id.eight);
        b9 = (Button) findViewById(R.id.nine);
        b0 = (Button) findViewById(R.id.zero);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        equal = (Button) findViewById(R.id.equal);
        dot = (Button) findViewById(R.id.dot);

        numberField = (EditText) findViewById(R.id.numberField);
        clearDisplay = (Button) findViewById(R.id.button);
        numberField.setText("0");


        clearDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplay("0");
                model.setMemoryNumber(0);
                model.setOperationClicked('\0');
                model.setIsCheck(true);
                model.setIsResult(true);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double.parseDouble(getDisplay());
                }catch (NumberFormatException e){
                    System.out.println(e);
                    return;
                }
                lastOperation();
                try {
                    Double.parseDouble(getDisplay());
                }catch (NumberFormatException e){
                    System.out.println(e);
                    return;
                }
                onOperationClick('+');
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double.parseDouble(getDisplay());
                }catch (NumberFormatException e){
                    System.out.println(e);
                    return;
                }
                lastOperation();
                try {
                    Double.parseDouble(getDisplay());
                }catch (NumberFormatException e){
                    System.out.println(e);
                    return;
                }
                onOperationClick('-');
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double.parseDouble(getDisplay());
                }catch (NumberFormatException e){
                    System.out.println(e);
                    return;
                }
                lastOperation();
                try {
                    Double.parseDouble(getDisplay());
                }catch (NumberFormatException e){
                    System.out.println(e);
                    return;
                }
                onOperationClick('/');
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double.parseDouble(getDisplay());
                }catch (NumberFormatException e){
                    System.out.println(e);
                    return;
                }
                lastOperation();
                try {
                    Double.parseDouble(getDisplay());
                }catch (NumberFormatException e){
                    System.out.println(e);
                    return;
                }
                onOperationClick('*');
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                try {
                    Double.parseDouble(getDisplay());
                }catch (NumberFormatException e){
                    System.out.println(e);
                    return;
                }
                char[] array = getDisplay().toCharArray();
                for (int i = 0; i < array.length; i++)
                {
                    if(array[i] == '.') return ;
                }
                setDisplay(getDisplay() + '.');
                model.setIsCheck(false);

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double.parseDouble(getDisplay());
                }catch (NumberFormatException e){
                    System.out.println(e);
                    return;
                }
                if (model.getIsResult() == true)
                {
                    model.setCountNumber(Double.parseDouble(getDisplay()));
                    switchOperations(model.getOperationClicked(), model.getMemoryNumber(), model.getCountNumber());
                    if (model.getMemoryNumber() > 999999999)
                    {
                        setDisplay("Error");
                        return;
                    }
                    if (model.getIsResultCount() == true)
                    {
                        second = model.getCountNumber();
                        operand = model.getOperationClicked();
                    }


                    model.setIsCheck(true);
                    model.setIsResult(false);

                    setDisplay(logic.cutDisplay(Double.toString(model.getMemoryNumber())));
                    model.setCountNumber(0);
                    model.setMemoryNumber(0);
                    model.setOperationClicked('\0');
                }
                if (model.getIsResultCount() == false)
                {
                    switchOperations(operand, Double.parseDouble(getDisplay()), second);
                    System.out.println(model.getMemoryNumber());
                    setDisplay(Double.toString(model.getMemoryNumber()));
                    if (model.getMemoryNumber() >= 999999999)
                    {
                        setDisplay("Error");
                        return;
                    }else
                    setDisplay(logic.cutDisplay(getDisplay()));

                }
                model.setIsResultCount(false);
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num =(int) Double.parseDouble(b1.getText().toString());
                onNumberClick(num);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num =(int) Double.parseDouble(b2.getText().toString());
                onNumberClick(num);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num =(int) Double.parseDouble(b3.getText().toString());
                onNumberClick(num);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num =(int) Double.parseDouble(b4.getText().toString());
                onNumberClick(num);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num =(int) Double.parseDouble(b5.getText().toString());
                onNumberClick(num);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num =(int) Double.parseDouble(b6.getText().toString());
                onNumberClick(num);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num =(int) Double.parseDouble(b7.getText().toString());
                onNumberClick(num);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num =(int) Double.parseDouble(b8.getText().toString());
                onNumberClick(num);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num =(int) Double.parseDouble(b9.getText().toString());
                onNumberClick(num);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num =(int) Double.parseDouble(b0.getText().toString());
                onNumberClick(num);
            }
        });

    }

    // обработка нажатия на числовую кнопку
    public String onNumberClick(Integer num){
        try {
            Double.parseDouble(getDisplay());
        }catch (NumberFormatException e){
            System.out.println(e);
            return "error";
        }
        if (model.getIsCheck())
        {
            if (Double.parseDouble(getDisplay()) == 0 && num == 0) return "false";
            setDisplay(num.toString());
            model.setIsCheck(false);
        }
        else
        {
            String qwerty = getDisplay() + num.toString();
            setDisplay(logic.cutDisplay(qwerty));

        }
        if (num == 0)
            if (getDisplay() == "00")
            {
                setDisplay(num.toString());
            }

        model.setIsResultCount(true);
        return "good";

    }
    public void lastOperation()
    {
        try {
            Double.parseDouble(getDisplay());
        }catch (NumberFormatException e){
            System.out.println(e);
            return;
        }
        if (model.getIsCheck())
        {
            model.setMemoryNumber(Double.parseDouble(getDisplay()));
        }
        else
            switch (model.getOperationClicked())
            {
                case '+':
                    model.setMemoryNumber(logic.summ(model.getMemoryNumber(), Double.parseDouble(getDisplay())));
                    if (model.getMemoryNumber() >= 999999999) {
                        setDisplay("Error");
                        return;
                    }
                    setDisplay(logic.cutDisplay(Double.toString(model.getMemoryNumber())));
                    break;
                case '-':
                    model.setMemoryNumber(logic.minus(model.getMemoryNumber(), Double.parseDouble(getDisplay())));
                    if (model.getMemoryNumber() >= 999999999) {
                        setDisplay("Error");
                        return;
                    }
                    setDisplay(logic.cutDisplay(Double.toString(model.getMemoryNumber())));
                    break;
                case '/':
                    model.setMemoryNumber(logic.divide(model.getMemoryNumber(), Double.parseDouble(getDisplay())));
                    if (model.getMemoryNumber() >= 999999999) {
                        setDisplay("Error");
                        return;
                    }
                    setDisplay(logic.cutDisplay(Double.toString(model.getMemoryNumber())));
                    break;
                case '*':
                    model.setMemoryNumber(logic.multiply(model.getMemoryNumber(), Double.parseDouble(getDisplay())));
                    if (model.getMemoryNumber() >= 999999999) {
                        setDisplay("Error");
                        return;
                    }
                    setDisplay(logic.cutDisplay(Double.toString(model.getMemoryNumber())));
                    break;
            }
    }
}
