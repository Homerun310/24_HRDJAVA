package com.example.myproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class vocatest_easy extends AppCompatActivity {
    private TextView scoreTextView, questionTextView, questionNumberTextView;
    private RadioButton rb1, rb2, rb3, rb4;
    private RadioGroup radioGroup;
    private Button submitButton,backbutton;

    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private boolean answered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.vocatest_easy);

        scoreTextView = findViewById(R.id.vocaeasy_score);
        questionTextView = findViewById(R.id.vocaeasy_question);
        questionNumberTextView = findViewById(R.id.vocaeasy_num);
        rb1 = findViewById(R.id.rb_easy1);
        rb2 = findViewById(R.id.rb_easy2);
        rb3 = findViewById(R.id.rb_easy3);
        rb4 = findViewById(R.id.rb_easy4);
        radioGroup = findViewById(R.id.easy_group);
        submitButton = findViewById(R.id.vocaeasy_submit);
        backbutton = findViewById(R.id.backfromvocaeasy);


        // 하드코딩된 문제 리스트 생성
        questionList = createQuestionList();

        showNextQuestion();

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(vocatest_easy.this, MainActivity.class);
                startActivity(intent);
            }
        });



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (radioGroup.getCheckedRadioButtonId() != -1) {
                        checkAnswer();
                    } else {
                        Toast.makeText(vocatest_easy.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int selectedAnswerNo = radioGroup.indexOfChild(rbSelected) + 1; // 인덱스가 0부터 시작하므로 +1

        Question currentQuestion = questionList.get(currentQuestionIndex - 1); // 현재 문제를 가져옴

        if (selectedAnswerNo == currentQuestion.getCorrectAnswerNo()) {
            score++;
            scoreTextView.setText("Score: " + score);
        } else {
            showCorrectAnswer(currentQuestion);
        }

        if (currentQuestionIndex < questionList.size()) {
            submitButton.setText("Next");
        } else {
            submitButton.setText("Finish");
        }
    }

    private void showCorrectAnswer(Question currentQuestion) {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getCorrectAnswerNo()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }
    }

    private void showNextQuestion() {
        radioGroup.clearCheck();
        rb1.setTextColor(Color.BLACK);
        rb2.setTextColor(Color.BLACK);
        rb3.setTextColor(Color.BLACK);
        rb4.setTextColor(Color.BLACK);

        if (currentQuestionIndex < questionList.size()) {
            Question currentQuestion = questionList.get(currentQuestionIndex);

            questionNumberTextView.setText("Question " + (currentQuestionIndex + 1));
            questionTextView.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            answered = false;
            submitButton.setText("Submit");

            currentQuestionIndex++;
        } else {
            Toast.makeText(this, "Quiz Finished!", Toast.LENGTH_SHORT).show();
            // 여기에 퀴즈 종료 후의 동작을 추가할 수 있습니다.
        }
    }

    private List<Question> createQuestionList() {
        List<Question> questions = new ArrayList<>();

        // 샘플 문제들 추가
        questions.add(new Question("permission", "허가", "임무", "선택", "측정", 1));
        questions.add(new Question("measure", "계산하다", "만들다", "연구하다", "측정하다", 4));
        questions.add(new Question("refer", "뜻하다", "조회하다", "제공하다", "제공하다", 1));
        questions.add(new Question("regard", "~여기다", "가로막다", "측정하다", "~과 엮다", 1));
        questions.add(new Question("provoke", "진정시키다", "자극하다", "피하다", "위로하다", 2));
        questions.add(new Question("elaborate", "단순한", "정교한,", "게으른", "모호한", 2)); // 정답 수정
        questions.add(new Question("adversity", "번영", "동의", "역경", "우정", 3)); // 정답 수정
        questions.add(new Question("ambiguous", "명확한", "불명확한", "고정된", "변화하는", 2)); // 정답 수정
        questions.add(new Question("intimidate", "격려하다", "칭찬하다", "무시하다", "위협하다", 4)); // 정답 수정

        return questions;


    }


}
