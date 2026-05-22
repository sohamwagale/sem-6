package com.example.contextmenu;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);

        registerForContextMenu(btn);

    }

    @Override
    public void onCreateContextMenu(ContextMenu m, View v,ContextMenu.ContextMenuInfo i){
        m.add("Fuck");
        m.add("Marry");
        m.add("Kill");
    }

    @Override
    public boolean onContextItemSelected(MenuItem i){
        Toast.makeText(this,i.getTitle(),Toast.LENGTH_SHORT).show();
        return true;
    }
}