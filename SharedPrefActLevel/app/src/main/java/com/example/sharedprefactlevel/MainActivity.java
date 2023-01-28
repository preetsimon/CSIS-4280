package com.example.sharedprefactlevel;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etMajor,   etID;
    private TextView txvName, txvMajor, txvID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName =findViewById(R.id.etName);
        etMajor =findViewById(R.id.etMajor);
        etID =findViewById(R.id.etID);

        txvName =findViewById(R.id.txtName);
        txvMajor = findViewById(R.id.txtMajor);
        txvID = findViewById(R.id.txtID);
    }

    public void saveData(View view) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // save data as key - value
        editor.putString("name", etName.getText().toString());
        editor.putString("major", etMajor.getText().toString());
        editor.putString("id", etID.getText().toString());

        editor.apply();
    }

    public void loadData(View view) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name", "Name is not avail");
        String major = sharedPreferences.getString("major", "major is not avail");
        String id = sharedPreferences.getString("id", "id is not avail");

        txvName.setText(name);
        txvID.setText(id);
        txvMajor.setText(major);
    }
}