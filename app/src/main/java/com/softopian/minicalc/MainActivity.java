package com.softopian.minicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btndot, btnequ, btndel, btndiv, btnmul, btnadd, btnsub;
    TextView carry, carrysign;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find Text Box
        input = findViewById(R.id.input);
        carry = findViewById(R.id.carry);
        carrysign = findViewById(R.id.carry_sign);

        // Find Buttons
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btndot = findViewById(R.id.btn_dot);
        btndel = findViewById(R.id.btn_del);
        btnadd = findViewById(R.id.btn_add);
        btnsub = findViewById(R.id.btn_sub);
        btnmul = findViewById(R.id.btn_mul);
        btndiv = findViewById(R.id.btn_div);
        btnequ = findViewById(R.id.btn_equ);

        ButtonAction();
    }

    public void PutDot()
    {
        if(!input.getText().toString().contains(".")){
            input.append(".");
        }
    }

    public void DigitAction(String data)
    {
        input.append(data);
    }

    public void Del()
    {
        carry.setText("");
        carrysign.setText("");
        input.setText("");

    }

    public void DoMath(String operation)
    {
        double currentData = 0;
        double currentCarry = 0;

        Log.d("Carry", carry.getText().toString());
        Log.d("Carry Sign", carrysign.getText().toString());
        Log.d("Input", input.getText().toString());

        if(!carry.getText().toString().equals("")){
            try{
                currentCarry = Double.parseDouble(carry.getText().toString());
            }catch(Exception e){
                //
            }
        }

        if(!input.getText().toString().equals("")){
            try {
                currentData = Double.parseDouble(input.getText().toString());
            }catch(Exception e) {
                //
            }
        }

        carrysign.setText(operation);

        if(carry.getText().toString().equals("")){
            if(currentData == (int)currentData){
                carry.setText(String.valueOf((int)currentData));
            }else{
                carry.setText(String.valueOf(currentData));
            }
            input.setText("");
        }

        if(!carry.getText().toString().equals("") && !input.getText().toString().equals("")){

            switch(operation) {
                case "+":
                    currentData = currentCarry + currentData;
                    break;
                case "-":
                    currentData = currentCarry - currentData;
                    break;
                case "x":
                    currentData = currentCarry * currentData;
                    break;
                case "/":
                    currentData = currentCarry / currentData;
                    break;
            }

            if(currentData == (int)currentData){
                carry.setText(String.valueOf((int)currentData));
            }else{
                carry.setText(String.valueOf(currentData));
            }
            input.setText("");
        }
    }

    public void Equal()
    {
        double currentData = 0;
        double currentCarry = 0;

        Log.d("Carry", carry.getText().toString());
        Log.d("Carry Sign", carrysign.getText().toString());
        Log.d("Input", input.getText().toString());

        if(!carry.getText().toString().equals("")){
            try{
                currentCarry = Double.parseDouble(carry.getText().toString());
            }catch(Exception e){
                //
            }
        }

        if(!input.getText().toString().equals("")){
            try {
                currentData = Double.parseDouble(input.getText().toString());
            }catch(Exception e) {
                //
            }
        }

        if(!carry.getText().toString().equals("")) {

            switch(carrysign.getText().toString()) {
                case "+":
                    currentData = currentCarry + currentData;
                    break;
                case "-":
                    currentData = currentCarry - currentData;
                    break;
                case "x":
                    currentData = currentCarry * currentData;
                    break;
                case "/":
                    currentData = currentCarry / currentData;
                    break;
            }
        }

        carrysign.setText("");
        if(currentData == (int)currentData){
            carry.setText(String.valueOf((int)currentData));
        }else{
            carry.setText(String.valueOf(currentData));
        }
        input.setText("");
    }

    public void ButtonAction()
    {
        btn0.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DigitAction("0");}});
        btn1.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DigitAction("1");}});
        btn2.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DigitAction("2");}});
        btn3.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DigitAction("3");}});
        btn4.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DigitAction("4");}});
        btn5.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DigitAction("5");}});
        btn6.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DigitAction("6");}});
        btn7.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DigitAction("7");}});
        btn8.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DigitAction("8");}});
        btn9.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DigitAction("9");}});
        btndot.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ PutDot(); }});

        btnadd.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DoMath("+");}});
        btnsub.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DoMath("-");}});
        btnmul.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DoMath("x");}});
        btndiv.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ DoMath("/");}});
        btnequ.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ Equal(); }});

        btndel.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view){ Del();}});

    }

}