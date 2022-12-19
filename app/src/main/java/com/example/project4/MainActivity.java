package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_start;
    EditText edt_string;
    TextView result;

    @Override
    public void onClick(View view) {
        if (btn_start == view) {
            StringOperation stringOperation = new StringOperation(MainActivity.this);
            stringOperation.setOnOperationListener(new MyOnOperation());
            stringOperation.show();
        }
    }

    private class MyOnOperation implements StringOperation.OnOperationListener {

        @Override
        public void lowerCase() {
            result.setText(edt_string.getText().toString().toLowerCase());
        }

        @Override
        public void upperCase() {
            result.setText(edt_string.getText().toString().toUpperCase());
        }

        @Override
        public void intermediateCase() {
            result.setText(edt_string.getText().toString());
        }

        @Override
        public void reverseString() {
            StringBuffer sb = new StringBuffer(edt_string.getText().toString());
            String textResult = sb.reverse().toString();
            result.setText(textResult);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        btn_start = findViewById(R.id.btn_start);
        edt_string = findViewById(R.id.edt_string);
        result = findViewById(R.id.result);
    }

    private void initListener() {
        btn_start.setOnClickListener(this);
    }
}