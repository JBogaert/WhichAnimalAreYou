package com.jb_dev.whichanimalareyou.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.jb_dev.whichanimalareyou.Controller.Quiz;
import com.jb_dev.whichanimalareyou.Model.Questions;
import com.jb_dev.whichanimalareyou.R;

import java.util.ArrayList;
import java.util.List;

import static com.jb_dev.whichanimalareyou.R.id.spinner;

public class MainActivity extends AppCompatActivity {
    Quiz mQuiz;
    Questions mQuestions;
    TextView mTextView;
    Spinner mSpinner;
    Button mButton;

    int questionNumber;
    int answerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if(intent != null) {
            questionNumber = 0;
            answerNumber = 0;

        }

        mTextView = (TextView) findViewById(R.id.textView);
        mSpinner = (Spinner) findViewById(spinner);
        questionNumber = 0;
        answerNumber = 0;

        addItemsOnSpinner2();

        mQuiz = new Quiz();
        mQuestions = new Questions();

        addListenerOnButton();
        getNextQuestion(0);


    }

    public void getNextQuestion(int i) {
        String nextQuestionString = mQuestions.getQuestion(i);
        mTextView.setText(nextQuestionString);
    }


    public void addItemsOnSpinner2() {
        mSpinner = (Spinner) findViewById(spinner);
        List<CharSequence> list = new ArrayList<>();
        list.add(getString(R.string.firstOption));
        list.add(getString(R.string.secondOption));
        list.add(getString(R.string.thirdOption));
        list.add(getString(R.string.fourthOption));
        list.add(getString(R.string.fifthOption));



        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter<>(this,
                R.layout.spinner_item, list);
//                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(dataAdapter);
    }

//    public void addListenerOnSpinnerItemSelection() {

//        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//    }
//
//    // get the selected dropdown list value
    public void addListenerOnButton() {


        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                answerNumber += (mSpinner.getSelectedItemPosition());
                questionNumber++;

//                Toast.makeText(MainActivity.this,
//                        "" + mSpinner.getSelectedItemPosition() + answerNumber, Toast.LENGTH_SHORT).show();

                if (questionNumber == 4) {
                    mButton.setText("Which Animal are You?");

                }

                if (questionNumber < 5) {
                    getNextQuestion(questionNumber);
                } else {
                    Intent intent = new Intent(MainActivity.this, AnimalActivity.class);
                    intent.putExtra("result", answerNumber);
                    startActivity(intent);
                }
            }

        });

    }}