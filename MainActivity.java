package com.example.exp3;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button mButton;
    EditText mEdit;
    TextView mText;
    Spinner sp;
    RadioGroup rb;
    ImageView datePickerIcon;
    String[] country = { "Andhra Pradesh","Telangana","Madhya Pradesh","Gujarat","Goa","Tamil Nadu","Karnataka","Delhi" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        datePickerIcon = findViewById(R.id.datePickerIcon);
        final EditText editTextDate = findViewById(R.id.editTextDate2);
        datePickerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(editTextDate);
            }
        });
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(editTextDate);
            }
        });

        mButton = findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String s = "";
                mEdit = findViewById(R.id.editTextUsername);
                s += "Username: " + mEdit.getText().toString() + "\n";
                mEdit = findViewById(R.id.editTextPassword);
                s += "Password: " + mEdit.getText().toString() + "\n";
                mEdit = findViewById(R.id.editText1);
                s += "Hello " + mEdit.getText().toString() + "!\n";
                mEdit = findViewById(R.id.editText3);
                s += "Address: " + mEdit.getText().toString() + "\n";
                rb = findViewById(R.id.r);
                int d = rb.getCheckedRadioButtonId();
                RadioButton x = findViewById(d);
                s += "Gender: " + x.getText().toString() + "\n";
                mEdit = findViewById(R.id.editTextDate2);
                s += "Date of birth: " + mEdit.getText().toString() + "\n";
                mEdit = findViewById(R.id.editText4);
                s += "Age: " + mEdit.getText().toString() + "\n";
                sp = findViewById(R.id.spinner);
                s += "State: " + sp.getSelectedItem().toString() + "\n";
                mText = findViewById(R.id.textView1);
                mText.setText(s);
            }
        });
    }

    private void showDatePickerDialog(final EditText editText) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}