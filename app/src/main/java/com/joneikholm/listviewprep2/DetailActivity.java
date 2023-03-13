package com.joneikholm.listviewprep2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String note = getIntent().getStringExtra("note");
        EditText editText1 = findViewById(R.id.editText1);
        editText1.setText(note);
    }

    public void savePressed(View view){
        System.out.println("Your note is saved");
        setResult(Activity.RESULT_OK, new Intent().putExtra("latitude",
                123).putExtra("longitude", 32));
        finish();
    }

}