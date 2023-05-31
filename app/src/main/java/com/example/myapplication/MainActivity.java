package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private TextView text1;
    private String[] s1 = { "美味蟹堡", "義式香腸堡", "蔬菜水果堡", "香蕉潛艇堡", "香烤雞肉堡" };
    private boolean check[] = { false, false, false, false, false };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        text1 = findViewById(R.id.text1);
        button1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.str2)
                        .setMultiChoiceItems(
                                s1,
                                check,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    public void onClick(DialogInterface arg0,
                                                        int which, boolean isCheck) {
                                        if (isCheck) {
                                            check[which] = true;
                                        }
                                    }
                                })
                        .setPositiveButton("確定",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0,
                                                        int arg1) {
                                        String tmp = "";
                                        for (int i = 0; i < check.length; i++) {
                                            if (check[i]) {
                                                tmp += s1[i] + "\n";
                                            }
                                        }
                                        text1.setText(MainActivity.this.getResources()
                                                .getString(R.string.str2)
                                                + "\n" + tmp);
                                    }
                                })
                        .setNegativeButton("離開",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                    }
                                }).show();
            }
        });
    }


}