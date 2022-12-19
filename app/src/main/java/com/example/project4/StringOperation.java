package com.example.project4;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class StringOperation extends Dialog implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{
    Context context;
    RadioGroup rb_group;
    CheckBox cb_reverse;
    Button btn_finish;
    EditText edt_string;
    TextView result;
    OnOperationListener onOperationListener;


    public StringOperation(@NonNull Context context) {
        super(context);
        this.context = context;
        setContentView(R.layout.operation_string_dialog);
        initView();
        initListener();
    }
    public interface OnOperationListener{
        void lowerCase();
        void upperCase();
        void intermediateCase();
        void reverseString();
    }
    public void setOnOperationListener(OnOperationListener onOperationListener){
        this.onOperationListener = onOperationListener;
    }

    private void initListener() {
        rb_group.setOnCheckedChangeListener( this);
        btn_finish.setOnClickListener(this);
        cb_reverse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                onOperationListener.reverseString();
            }
        });
    }

    private void initView() {
        edt_string = findViewById(R.id.edt_string);
        rb_group = findViewById(R.id.rb_group);
        cb_reverse = findViewById(R.id.cb_reverse);
        btn_finish = findViewById(R.id.btn_finish);
        result = findViewById(R.id.result);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        RadioButton radioButton = findViewById(i);
        String text1 = radioButton.getText().toString();
        int rb_id = radioButton.getId();
        Toast.makeText(context,text1,Toast.LENGTH_SHORT).show();
        if(rb_id == R.id.lower_case){
            onOperationListener.lowerCase();
        }
        if(rb_id == R.id.upper_case){
            onOperationListener.upperCase();
        }
        if(rb_id == R.id.i_case){
            onOperationListener.intermediateCase();
        }

    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
