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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_add_patient) {
            Intent i = new Intent(getBaseContext(), AddPatient.class);
            startActivity(i);

        }
//        else if (id == R.id.action_edit_patient){
//            Intent i = new Intent(getBaseContext(), LoginActivity.class);
//
//            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
//            SharedPreferences.Editor editor = prefs.edit();
//            editor.putString("id", "");
//            editor.putString("apikey","");
//            editor.commit();
//
//            startActivity(i);
//        }
        return super.onOptionsItemSelected(item);
    }
}

