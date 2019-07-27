
package com.myapplicationdev.android.fypcgh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText etLoginID, etPassword;
    private Button btnLogin;
    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginID = findViewById(R.id.editTextLoginID);
        etPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);

        client = new AsyncHttpClient();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etLoginID.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.equalsIgnoreCase("")) {
                    Toast.makeText(LoginActivity.this, "Login failed. Please enter username.", Toast.LENGTH_LONG).show();

                } else if (password.equalsIgnoreCase("")) {
                    Toast.makeText(LoginActivity.this, "Login failed. Please enter password.", Toast.LENGTH_LONG).show();

                } else {
                    // proceed to authenticate user

                    RequestParams params = new RequestParams();
                    params.add("staffID", username);
                    params.add("password", password);
// TODO: call doLogin web service to authenticate use
                    client.post("http://10.0.2.2/FYPCGH/doLogin.php", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                    String password = response.getString("password");
                                    String id = response.getString("staffID");

                                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                intent.putExtra("staffID", id);
                                intent.putExtra("password", password);
                                startActivity(intent);
//
//                                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
//                                    SharedPreferences.Editor editor = prefs.edit();
//                                    editor.putString("staff_id", id);
//                                    editor.putString("password", password);
//                                    editor.commit();
//
//                                    Intent i = new Intent(getBaseContext() , MainActivity.class);
//                                    startActivity(i);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });


                }
            }
        });
    }
}


