package com.jb_dev.whichanimalareyou.View;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jb_dev.whichanimalareyou.R;

public class AnimalActivity extends AppCompatActivity {
    int result;
    Button mButton;
    String mAnimalString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        RelativeLayout rl = (RelativeLayout) this.findViewById(R.id.rl);
        mButton = (Button) findViewById(R.id.button2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimalActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        result = intent.getIntExtra("result", 0);

//        Toast.makeText(this, result + " ", Toast.LENGTH_LONG).show();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

        if(result == 0) {
                rl.setBackground(ContextCompat.getDrawable(this, R.raw.dolphin));
                mAnimalString = "Dolphin";
            }

        if(result > 0 && result < 4) {
                rl.setBackground(ContextCompat.getDrawable(this, R.raw.elephant));
                mAnimalString = "Elephant";
            }
        if(result >= 4 && result < 8) {
                rl.setBackground(ContextCompat.getDrawable(this, R.raw.monkey));
                mAnimalString = "Monkey";
            }
        if(result >= 8 && result < 10) {
                rl.setBackground(ContextCompat.getDrawable(this, R.raw.redpanda));
                mAnimalString = "Red Panda";
            }
        if(result >= 10) {
                rl.setBackground(ContextCompat.getDrawable(this, R.raw.tiger));
                mAnimalString = "Tiger";
            }

        } Toast.makeText(this, "You are a " + mAnimalString + "!", Toast.LENGTH_LONG).show();
//            ContextCompat.getDrawable(this, R.raw.dolphin);
        }




    }


