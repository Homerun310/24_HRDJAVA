package com.example.myproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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

public class vocatest_hard extends AppCompatActivity {
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
        setContentView(R.layout.vocatest_hard);

        scoreTextView = findViewById(R.id.vocahard_score);
        questionTextView = findViewById(R.id.vocahard_question);
        questionNumberTextView = findViewById(R.id.vocahard_num);
        rb1 = findViewById(R.id.rb_hard1);
        rb2 = findViewById(R.id.rb_hard2);
        rb3 = findViewById(R.id.rb_hard3);
        rb4 = findViewById(R.id.rb_hard4);
        radioGroup = findViewById(R.id.hard_group);
        submitButton = findViewById(R.id.vocahard_submit);
        backbutton = findViewById(R.id.backfromvocahard);

        // 하드코딩된 문제 리스트 생성
        questionList = createQuestionList();

        showNextQuestion();

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(vocatest_hard.this, MainActivity.class);
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
                        Toast.makeText(vocatest_hard.this, "Please select an option", Toast.LENGTH_SHORT).show();
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
        questions.add(new Question("empirical","실험적인","경험적인", "이론적인","불확실한",2));

        questions.add(new Question("mitigate","강화하다","무시하다","완화하다","증가시키다",3));

        questions.add(new Question("ambivalent","확신하는","이중적인 감정을 가진","무관심한", "일관된", 2));

        questions.add(new Question("exacerbate","개선하다","약화시키다","과장하다","악화시키다",4));

        questions.add(new Question("alleviate","해결하다","악화시키다","완화하다","보완하다",3));

        questions.add(new Question("comprehensive","포괄적인","간결한","제한된","표면적인",1));

        questions.add(new Question("prevalent","드문","만연한","과소평가된","불명확한",2));

        questions.add(new Question("reconcile","대조하다","중재하다","화해시키다","무시하다",3));

        questions.add(new Question("redundant","필수적인","불필요한","혁신적인","중요한",2));

        questions.add(new Question("scrutinize","대충 훑어보다","무시하다","면밀히 조사하다", "지지하다",3));

        return questions;
    }
}