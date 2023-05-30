package com.example.lostfind;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateEventActivity extends AppCompatActivity {
    private Button btnSave;

    private EditText etTitle, etLocation, etPhone, etDescription, etDate;

    private Item item;

    private RadioGroup radioGroup;

    private String type = "Found";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        btnSave = findViewById(R.id.btnSave);
        etTitle = findViewById(R.id.et_1);
        etPhone = findViewById(R.id.et_2);
        etDescription = findViewById(R.id.et_3);
        etLocation = findViewById(R.id.et_4);
        etDate = findViewById(R.id.et_d);
        radioGroup = findViewById(R.id.radioGroup);

        item = new Item();
        btnSave.setOnClickListener(v -> {
            if (TextUtils.isEmpty(etTitle.getText().toString())) {
                Toast.makeText(this, "Please enter title", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(etDate.getText().toString())) {
                Toast.makeText(this, "Please enter date", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(etDate.getText().toString())) {
                Toast.makeText(this, "Please enter date", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(etPhone.getText().toString())) {
                Toast.makeText(this, "Please enter mobile", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(etDescription.getText().toString())) {
                Toast.makeText(this, "Please enter description", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(etLocation.getText().toString())) {
                Toast.makeText(this, "Please enter location", Toast.LENGTH_SHORT).show();
            } else {
                item.setId(type);
                item.setDate(etDate.getText().toString());
                item.setTitle(etTitle.getText().toString());
                item.setDescription(etDescription.getText().toString());
                item.setContact(etPhone.getText().toString());
                item.setLocation(etLocation.getText().toString());
                long id = DatabaseHelper.getInstance(this).insertItem(item);
                if (id > 0) {
                    Toast.makeText(CreateEventActivity.this, "Incident logged success", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CreateEventActivity.this, "Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                type = radioButton.getText().toString();
                Toast.makeText(CreateEventActivity.this, "Selected Radio Button is : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}