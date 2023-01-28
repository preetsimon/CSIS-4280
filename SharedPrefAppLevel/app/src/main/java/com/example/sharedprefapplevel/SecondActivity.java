package com.example.sharedprefapplevel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txvName, txvMajor, txvID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txvName =findViewById(R.id.txtName);
        txvMajor = findViewById(R.id.txtMajor);
        txvID = findViewById(R.id.txtID);
    }

    public void loadData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name", "Name is not avail");
        String major = sharedPreferences.getString("major", "major is not avail");
        String id = sharedPreferences.getString("id", "id is not avail");

        txvName.setText(name);
        txvID.setText(id);
        txvMajor.setText(major);
    }

    public void clearData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void removeStudentMajor(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("major");
        editor.apply();
    }
}
