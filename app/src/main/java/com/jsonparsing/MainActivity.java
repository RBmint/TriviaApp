package com.jsonparsing;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static android.graphics.PorterDuff.Mode.MULTIPLY;

public class MainActivity extends AppCompatActivity {
    public boolean isClicked = false;
    public Integer score = 0;
    String url = "https://opentdb.com/api.php?amount=1&type=multiple";
    ProgressDialog dialog;
    @Override

    // Parse URL to Json
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
        rQueue.add(request);

        // Add a x-sec timer
        CountDownTimer waitTimer;
        waitTimer = new CountDownTimer(10000, 1000) {
            TextView timer = findViewById(R.id.Timer);
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }
            // When the time is up get a new question
            public void onFinish() {
                TextView score_t = findViewById(R.id.Score);
                score_t.setText(score.toString());
                TextView castore = findViewById(R.id.castore);
                Button answer1 = findViewById(R.id.answerA);
                Button answer2 = findViewById(R.id.answerB);
                Button answer3 = findViewById(R.id.answerC);
                Button answer4 = findViewById(R.id.answerD);
                if (answer1.getText().equals(castore.getText())) {
                    answer1.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                if (answer2.getText().equals(castore.getText())) {
                    answer2.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                if (answer3.getText().equals(castore.getText())) {
                    answer3.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                if (answer4.getText().equals(castore.getText())) {
                    answer4.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String string) {
                        parseJsonData(string);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
                rQueue.add(request);
                start();
            }
        }.start();


        // Add points and refresh the questions upon clicking
        TextView score_t = findViewById(R.id.Score);
        score_t.setText(score.toString());
        final TextView castore = findViewById(R.id.castore);
        final Button answer1 = findViewById(R.id.answerA);
        final Button answer2 = findViewById(R.id.answerB);
        final Button answer3 = findViewById(R.id.answerC);
        final Button answer4 = findViewById(R.id.answerD);

            answer1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View V) {
                    isClicked = true;
                    if (answer1.getText().equals(castore.getText())) {
                        answer1.setBackgroundColor(Color.parseColor("#00FF00"));
                        score += 10;
                    } else {
                        answer1.setBackgroundColor(Color.parseColor("#FF0000"));
                        if (answer2.getText().equals(castore.getText())) {
                            answer2.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        if (answer3.getText().equals(castore.getText())) {
                            answer3.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        if (answer4.getText().equals(castore.getText())) {
                            answer4.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                    }
                }
            });

            answer2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View V) {
                    isClicked = true;
                    if (answer2.getText().equals(castore.getText())) {
                        answer2.setBackgroundColor(Color.parseColor("#00FF00"));
                        score += 10;
                    } else {
                        answer2.setBackgroundColor(Color.parseColor("#FF0000"));
                        if (answer1.getText().equals(castore.getText())) {
                            answer1.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        if (answer3.getText().equals(castore.getText())) {
                            answer3.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        if (answer4.getText().equals(castore.getText())) {
                            answer4.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                    }
                }
            });

            answer3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View V) {
                    isClicked = true;
                    if (answer3.getText().equals(castore.getText())) {
                        answer3.setBackgroundColor(Color.parseColor("#00FF00"));
                        score += 10;
                    } else {
                        answer3.setBackgroundColor(Color.parseColor("#FF0000"));
                        if (answer2.getText().equals(castore.getText())) {
                            answer2.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        if (answer1.getText().equals(castore.getText())) {
                            answer1.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        if (answer4.getText().equals(castore.getText())) {
                            answer4.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                    }
                }
            });

            answer4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View V) {
                    isClicked = true;
                    if (answer4.getText().equals(castore.getText())) {
                        answer4.setBackgroundColor(Color.parseColor("#00FF00"));
                        score += 10;
                    } else {
                        answer4.setBackgroundColor(Color.parseColor("#FF0000"));
                        if (answer2.getText().equals(castore.getText())) {
                            answer2.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        if (answer3.getText().equals(castore.getText())) {
                            answer3.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        if (answer1.getText().equals(castore.getText())) {
                            answer1.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                    }
                }
            });


    }

    void parseJsonData(String jsonString) {
        try {

            // Parse questions and answers
            JSONObject object = new JSONObject(jsonString);
            JSONArray results = object.getJSONArray("results");
            JSONObject all = results.getJSONObject(0);
            String question = all.getString("question") ;
            String correct_a = all.getString("correct_answer");
            TextView castore = findViewById(R.id.castore);
            castore.setText(correct_a);

            // Show the question, score and timer text
            TextView question_text = findViewById(R.id.question);
            question_text.setText(question);
            TextView timer_text = findViewById(R.id.Timer_text);
            timer_text.setText("Countdown");
            TextView score_text = findViewById(R.id.Score_text);
            score_text.setText("Score");

            // Pre-assign the values preparing to get randomized
            JSONArray incorrect_a = all.getJSONArray("incorrect_answers");
            String[] answers = new String[4];
            for (int i = 0; i < 3; i++) {
                answers[i] = incorrect_a.getString(i);
            }
            answers[3] = correct_a;

            // Generate random 4 numbers
            int[] nums = new int[4];
            for (int i = 0; i < nums.length; ++i) {
                nums[i] = i;
            }
            Random randomGenerator = new Random();
            int randomIndex;
            int randomValue;
            for(int i = 0; i < nums.length; ++i) {
                randomIndex = randomGenerator.nextInt(nums.length);
                randomValue = nums[randomIndex];
                nums[randomIndex] = nums[i];
                nums[i] = randomValue;
            }

            // Assign randomized questions to the buttons
            Button answer1 = findViewById(R.id.answerA);
            answer1.setText(answers[nums[0]]);
            Button answer2 = findViewById(R.id.answerB);
            answer2.setText(answers[nums[1]]);
            Button answer3 = findViewById(R.id.answerC);
            answer3.setText(answers[nums[2]]);
            Button answer4 = findViewById(R.id.answerD);
            answer4.setText(answers[nums[3]]);

            // Refresh button background color for every new question
            answer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            answer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            answer3.setBackgroundColor(Color.parseColor("#FFFFFF"));
            answer4.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dialog.dismiss();
    }

}