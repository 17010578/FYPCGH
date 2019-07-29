package com.myapplicationdev.android.fypcgh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tvID, tvPass, tv3;

    String staffID = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Patient List");

        tvID = findViewById(R.id.tvID);
        tvPass = findViewById(R.id.tvPass);

        Intent intent = getIntent();
        staffID = intent.getStringExtra("staffID");
        password = intent.getStringExtra("password");

        tvID.setText(staffID);
        tvPass.setText(password);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar_buttons_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add_patient) {
            Intent i = new Intent(getBaseContext(), AddPatient.class);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }
}

