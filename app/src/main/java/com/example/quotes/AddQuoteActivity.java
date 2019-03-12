package com.example.quotes;

import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.invoke.WrongMethodTypeException;

public class AddQuoteActivity extends AppCompatActivity {

    private EditText etQuotes;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote);

        etQuotes = findViewById(R.id.etQuotes);
        btnSave = findViewById(R.id.btnQuotes);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WriteData();
            }
        });
    }
    private void WriteData()
    {
        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("quotes.txt", MODE_PRIVATE));
            String a = etQuotes.getText().toString();
            outputStreamWriter.write(a);
            outputStreamWriter.close();

            Toast.makeText(this,"Added" , Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
