package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddUserActivity extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText email;

    private String degreeProgram;
    private int image;
    private Context context;
    private StringBuilder selectedDegrees = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        context = AddUserActivity.this;

    }

    public void addUser(View view) {
        firstName = findViewById(R.id.idFirstname);
        lastName = findViewById(R.id.idLastname);
        email = findViewById(R.id.idEmail);
        RadioGroup rgFieldType = findViewById(R.id.rgField);
        RadioGroup rgImageType = findViewById(R.id.rgImage);
        selectedDegrees.setLength(0);
        CheckBox kandi = findViewById(R.id.cbKandi);
        CheckBox dippa = findViewById(R.id.cbDI);
        CheckBox tohtori = findViewById(R.id.cbTekniikantohtori);
        CheckBox uima = findViewById(R.id.cbUimamaisteri);
        if (kandi.isChecked() || dippa.isChecked() || tohtori.isChecked() || uima.isChecked()) {
            selectedDegrees.append("Suoritetut tutkinnot:\n");
        }
        if (kandi.isChecked()) {
            selectedDegrees.append("kandidaatin tutkinto\n");
        }
        if (dippa.isChecked()) {
            selectedDegrees.append("Diplomi-insinöörin tutkinto\n");
        }
        if (tohtori.isChecked()) {
            selectedDegrees.append("Tekniikan tohtorin tutkinto\n");
        }
        if (uima.isChecked()) {
            selectedDegrees.append("Uimamaisteri");
        }

        switch (rgFieldType.getCheckedRadioButtonId()) {
            case R.id.rbTite:
                degreeProgram = "Tietotekniikka";
                break;
            case R.id.rbTuta:
                degreeProgram = "Tuotantotalous";
                break;
            case R.id.rbLate:
                degreeProgram = "Laskennallinen tekniikka";
                break;
            case R.id.rbSate:
                degreeProgram = "Sähkötekniikka";
        }
        switch (rgImageType.getCheckedRadioButtonId()) {
            case R.id.rbimage1:
                image = R.drawable.image1;
                break;
            case R.id.rbimage2:
                image = R.drawable.image2;
                break;
            case R.id.rbimage3:
                image = R.drawable.image3;
                break;
        }

        User user = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), degreeProgram, image, selectedDegrees.toString());
        UserStorage.getInstance().addUser(user);
        UserStorage.getInstance().sortUsers();
        UserStorage.getInstance().saveUsers(context);
    }


}