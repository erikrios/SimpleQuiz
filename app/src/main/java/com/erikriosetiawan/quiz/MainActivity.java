package com.erikriosetiawan.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private TextView textViewScore;
    private TextView textViewQuestion;
    private Button buttonChoiceOne;
    private Button buttonChoiceTwo;
    private Button buttonChoiceThree;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewScore = findViewById(R.id.text_view_score_value);
        textViewQuestion = findViewById(R.id.text_view_question);
        buttonChoiceOne = findViewById(R.id.button_choice_one);
        buttonChoiceTwo = findViewById(R.id.button_choice_two);
        buttonChoiceThree = findViewById(R.id.button_choice_three);

        updateQuestion();

        // Listener tombol pilihan satu
        buttonChoiceOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logika program
                if (buttonChoiceOne.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    // Toast
                    Toast.makeText(MainActivity.this, "BENAR", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "SALAH", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        // Listener tombol pilihan dua
        buttonChoiceTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logika program
                if (buttonChoiceTwo.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    // Toast
                    Toast.makeText(MainActivity.this, "BENAR", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "SALAH", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        // Listener tombol pilihan 3
        buttonChoiceThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logika program
                if (buttonChoiceThree.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    // Toast
                    Toast.makeText(MainActivity.this, "BENAR", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "SALAH", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
    }

    private void updateQuestion() {
        if (mQuestionNumber < mQuestionLibrary.getLength()) {
            textViewQuestion.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            buttonChoiceOne.setText(mQuestionLibrary.getChoiceOne(mQuestionNumber));
            buttonChoiceTwo.setText(mQuestionLibrary.getChoiceTwo(mQuestionNumber));
            buttonChoiceThree.setText(mQuestionLibrary.getChoiceThree(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        } else {
            gameOver();
        }
    }

    private void updateScore(int point) {
        textViewScore.setText("" + mScore);
    }

    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage(" Skor Kamu " + mScore + " poin")
                .setCancelable(false)
                .setPositiveButton("MAIN LAGI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                })
                .setNegativeButton("KELUAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
