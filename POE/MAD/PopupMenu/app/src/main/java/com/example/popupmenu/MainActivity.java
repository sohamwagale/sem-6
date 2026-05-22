package com.example.popupmenu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.PopupMenu;
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

        btn.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(this,btn);
            popupMenu.getMenu().add("Fuck");
            popupMenu.setOnMenuItemClickListener(i->{
                Toast.makeText(this,i.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            });
            popupMenu.show();
        });

    }
}