package com.example.listviewlayout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] fruits = {
            "Apple",
            "Mango",
            "Banana",
            "Orange",
            "Grapes"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>( // Connect data to the listview
                this, // Used to provide context of the current activity
                android.R.layout.simple_list_item_1, // built in  layouts
                fruits
        );

        listView.setAdapter(adapter); //setAdapter() is used to display the data in the list.
    }
}