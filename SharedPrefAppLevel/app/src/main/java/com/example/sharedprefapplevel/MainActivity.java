package com.example.sharedprefapplevel;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etMajor,   etID;
    private TextView txvName, txvMajor, txvID;
    private Switch pageColorSwitch;
    private LinearLayout pageLayout;
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

        pageLayout= findViewById(R.id.pageLayout);
        pageColorSwitch= findViewById(R.id.pageColorSwitch);
        pageColorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setPageColor(isChecked);
            }
        });
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        boolean isChecked = sharedPreferences.getBoolean("yellow", false);
        pageColorSwitch.setChecked(isChecked);
    }

    private void setPageColor(boolean isChecked) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("yellow", isChecked);
        editor.apply();

        pageLayout.setBackgroundColor(isChecked ? Color.YELLOW : Color.WHITE);
    }

    public void saveData(View view) {
//        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        // save data as key - value
        editor.putString("name", etName.getText().toString());
        editor.putString("major", etMajor.getText().toString());
        editor.putString("id", etID.getText().toString());

        editor.apply();
    }

    public void loadData(View view) {
//        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name", "Name is not avail");
        String major = sharedPreferences.getString("major", "major is not avail");
        String id = sharedPreferences.getString("id", "id is not avail");

        txvName.setText(name);
        txvID.setText(id);
        txvMajor.setText(major);
    }

    public void OpenSecondAct(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


}