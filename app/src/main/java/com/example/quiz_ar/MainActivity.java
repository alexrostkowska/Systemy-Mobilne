package com.example.quiz_ar;
import com.example.quiz_ar.Question;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private Question[] questions = new Question[] {
            new Question(R.string.q_sat_testing, true),
            new Question(R.string.q_python, true),
            new Question(R.string.q_Playwright, true),
            new Question(R.string.q_react, false),
            new Question(R.string.q_testing, true)
    };
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueButton= findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);
        trueButton.setOnClickListener(view -> checkAnswerCorrectness(true));
        falseButton.setOnClickListener(view -> checkAnswerCorrectness(false));
        nextButton.setOnClickListener(view -> {
            currentIndex = (currentIndex+1)%questions.length;
            setNextQuestion();
        });
        setNextQuestion();
    }
    private void setNextQuestion(){
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }
    private void checkAnswerCorrectness(boolean userAnswer){
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId = 0;
        if (userAnswer == correctAnswer){
            resultMessageId = R.string.correct_answer;
        }
        else{
            resultMessageId = R.string.incorrect_answer;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

}