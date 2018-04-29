package com.jsonparsing;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
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


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView fruitsList;
    String url = "https://opentdb.com/api.php?amount=1&type=multiple";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitsList = (ListView)findViewById(R.id.fruitsList);

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
    }

    void parseJsonData(String jsonString) {
        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray results = object.getJSONArray("results");
            JSONObject all = results.getJSONObject(0);
            String question = all.getString("question") ;
            String correct_a = all.getString("correct_answer");
            TextView helloTextView = (TextView) findViewById(R.id.textView2);
            helloTextView.setText(question);
            Button cbt = (Button) findViewById(R.id.button2 );
            cbt.setText(correct_a);
            JSONArray incorrect_a = all.getJSONArray("incorrect_answers");

            ArrayList al = new ArrayList();

            for(int i = 0; i < incorrect_a.length(); ++i) {
                al.add(incorrect_a.getString(i));
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
            fruitsList.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }
}