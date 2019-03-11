package com.example.quotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView quotesList = findViewById(R.id.quoteList);
        quotesList.setLayoutManager(new LinearLayoutManager(this));

        List<String> lstQuote = new ArrayList<>();
        lstQuote.add("Quote1");
        lstQuote.add("Quote2");
        lstQuote.add("Quote3");
        lstQuote.add("Quote4");
        lstQuote.add("Quote5");
        lstQuote.add("Quote6");


        QuotesAdapter adapter = new QuotesAdapter(this,lstQuote);
        quotesList.setAdapter(adapter);

    }
}
