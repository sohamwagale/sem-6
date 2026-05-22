package com.example.registrationform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.submitButton);
        result=findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox music = findViewById(R.id.checkMusic);
                CheckBox sport = findViewById(R.id.checkSports);

                RadioGroup genderGrp = findViewById(R.id.genderGroup);
                int selectedId = genderGrp.getCheckedRadioButtonId();

                RadioButton gender = findViewById(selectedId);

                ToggleButton toggleButton = findViewById(R.id.toggleButton);

                String hobbies = "";

                if(music.isChecked()){
                    hobbies += "Music ";
                }
                if(sport.isChecked()){
                    hobbies += "Sports ";
                }

                String toggleStatus;

                if(toggleButton.isChecked()){
                    toggleStatus = "ON";
                }
                else{
                    toggleStatus = "OFF";
                }

                result.setText(
                        "Gender: " + gender.getText() +"\nHobbies: " + hobbies + "\nToggle: " + toggleStatus
                );
            }
        });

    }
}