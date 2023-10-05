package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class secondActivity extends AppCompatActivity {

    TextView txt;
    TextView txt1;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt = (TextView) findViewById(R.id.textView2);
        txt1 = (TextView) findViewById(R.id.textView3);
        but = (Button) findViewById(R.id.share);

        Intent i = getIntent();
        String user = i.getStringExtra("user");

        int rand = generate();
        txt1.setText(""+rand);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(user,rand);
            }
        });
    }

    public void shareData(String user,int num){

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,"hey "+user+" got lucky number");
        i.putExtra(Intent.EXTRA_TEXT, user+" lucky number is "+num);

        startActivity(Intent.createChooser(i,"choose a platform"));

    }
    public int generate(){
        Random rand = new Random();
        int len = 1000;

        int randNum = rand.nextInt(len);
        return randNum;
    }
}