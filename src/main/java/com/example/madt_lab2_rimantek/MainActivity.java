package com.example.madt_lab2_rimantek;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText editext;
    private Spinner spinner;

    private final String[] countChoices = {
            "Words",
            "Characters",
            "Sentences",
            "Numbers"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.editext = findViewById(R.id.editext);
        Button button = findViewById(R.id.button);
        this.spinner = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                countChoices
        );

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        button.setOnClickListener(v -> { //main method for the onclick event based on the chosen option of the spinner element
            final String input = editext.getText().toString();
            final int charCount = TextCounting.countCharacters(MainActivity.this, input);
            final int wordCount = TextCounting.countWords(MainActivity.this, input);
            final int sentenceCount = TextCounting.countSentences(MainActivity.this, input);
            final int numberCount = TextCounting.countNumbers(MainActivity.this, input);

//                if (spinner1.getSelectedItem().equals("words") && wordCount != 0) {
//                    Toast.makeText(getApplicationContext(), "Words: " + wordCount, Toast.LENGTH_LONG).show();
//                } else if (spinner1.getSelectedItem().equals("characters") && charCount != 0) {
//                    Toast.makeText(getApplicationContext(), "Characters: " + charCount, Toast.LENGTH_LONG).show();
//                }

            //replaced if structure by a switch for cleaner code
            String selected = spinner.getSelectedItem().toString();

            switch (selected) {
                case "Words":
                    if (wordCount != 0) {
                        Toast.makeText(getApplicationContext(), "Words: " + wordCount, Toast.LENGTH_LONG).show();
                    }
                case "Characters":
                    if (charCount != 0) {
                        Toast.makeText(getApplicationContext(), "Characters: " + charCount, Toast.LENGTH_LONG).show();
                    }
                case "Sentences":
                    if (sentenceCount != 0) {
                        Toast.makeText(getApplicationContext(), "Sentences: " + sentenceCount, Toast.LENGTH_LONG).show();
                    }
                case "Numbers":
                    if (numberCount != 0) {
                        Toast.makeText(getApplicationContext(), "Numbers: " + numberCount, Toast.LENGTH_LONG).show();
                    }
                default:
                    Toast.makeText(getApplicationContext(), "lol not working", Toast.LENGTH_LONG).show();
                    break;
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}