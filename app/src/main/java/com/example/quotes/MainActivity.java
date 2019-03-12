package com.example.quotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView quotesList = findViewById(R.id.quoteList);
        quotesList.setLayoutManager(new LinearLayoutManager(this));

        QuotesAdapter adapter = new QuotesAdapter(this,getQuotes());
        quotesList.setAdapter(adapter);

    }

    private List<String> getQuotes()
    {
        List<String> quotes = new ArrayList<>();
        BufferedReader bufferedReader=null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getAssets().open("quotes.txt"),"UTF-8"));
            String line;
            while((line = bufferedReader.readLine())!=null)
            {
                quotes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quotes;
    }
}
