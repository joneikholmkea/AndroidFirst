package com.joneikholm.listviewprep2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;
import com.joneikholm.listviewprep2.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items = new ArrayList<>(Arrays.asList("How to prepare salomon", "Remember Joe's birthday", "What to Netflix?"));
    ArrayAdapter<String> adapter;
    MyAdapter myAdapter;
    ListView listView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.myList);
        button = findViewById(R.id.addButton);
        listViewWithArrayAdapter();

//        listViewWithCustomAdapter();
    }

    private void listViewWithArrayAdapter(){
        // Arguments: (context, the layout file, the TextView to be populated, list of items
        adapter = new ArrayAdapter<>(this, R.layout.myrow, R.id.myRowView,  items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            TextView tv = findViewById(R.id.myRowView);
            System.out.println("Click ! " + tv.getText());
        });
        button.setOnClickListener(e ->{
            System.out.println("you click add");
            items.add("New item " + items.size());
            adapter.notifyDataSetChanged();
        });
    }

    private void listViewWithCustomAdapter(){
        myAdapter = new MyAdapter(items,this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
//            LinearLayout linearLayout = (LinearLayout)view;
            MaterialTextView textView = (MaterialTextView)view; // why MaterialTextView here?
          //  TextView tv = textView.findViewById(R.id.myRowView);
            System.out.println("Click ! " + textView.toString());
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("note", items.get(position));
//            startActivity(intent);
            startActivityForResult(intent, 1);
        });

        button.setOnClickListener(e ->{
            System.out.println("you click add");
            items.add("New item " + items.size());
            myAdapter.notifyDataSetChanged();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int lat = data.getIntExtra("latitude", 0);
        System.out.println("back with data? " + lat);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("back from detailview");
    }
}