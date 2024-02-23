package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // background
        ConstraintLayout bg = (ConstraintLayout)
                findViewById(R.id.constraintLayout1);
        bg.setBackgroundColor(Color.BLUE);
        bg.setBackgroundResource(R.drawable.bg2);

        // random background
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg);
        arrayList.add(R.drawable.bg2);
        arrayList.add(R.drawable.bg3);
        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));

        // checkbox
        CheckBox ck1 = (CheckBox) findViewById(R.id.checkBox1);
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bg.setBackgroundResource(R.drawable.bg3);
                } else {
                    bg.setBackgroundResource(R.drawable.bg2);
                }
            }
        });

        //switch
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { //isChecked = true
                    Toast.makeText(MainActivity.this, "Wifi đang bật", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wifi đang tắt", Toast.LENGTH_LONG).show();
                }
            }
        });

        // image + button
        this.imageView = (ImageView) this.findViewById(R.id.imageView);

        this.button1 = (Button) this.findViewById(R.id.button1);
        this.button2 = (Button) this.findViewById(R.id.button2);

        this.button1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                showImage1();
            }
        });

        this.button2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                showImage2();
            }
        });
    }

    private void showImage1() {
        this.imageView.setImageResource(R.drawable.kotlin);
    }

    private void showImage2() {
        this.imageView.setImageResource(R.drawable.kotlin2);
    }
}