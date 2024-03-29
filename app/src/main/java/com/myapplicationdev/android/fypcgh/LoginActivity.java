
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

    boolean check = false;

    String pw = "";
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Changi General Hospital Portal");

        etLoginID = findViewById(R.id.editTextLoginID);
        etPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);

        client = new AsyncHttpClient();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etLoginID.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.length() == 0) {
                    Toast.makeText(getBaseContext(), "ID cannot be empty", Toast.LENGTH_LONG).show();
                }
                else if (password.length() == 0) {
                    Toast.makeText(getBaseContext(), "Password cannot be empty", Toast.LENGTH_LONG).show();
                }
//                else if (username != 1) {
//                    Toast.makeText(getBaseContext(), "Wrong ID ", Toast.LENGTH_LONG).show();
//                }
//                else if (password != "john") {
//                    Toast.makeText(getBaseContext(), "Wrong Password ", Toast.LENGTH_LONG).show();
//                }
                else {
                    // proceed to authenticate user

                    RequestParams params = new RequestParams();
                    params.add("staffID", username);
                    params.add("password", password);
// TODO: call doLogin web service to authenticate use
                    client.post("http://10.0.2.2/FYPCGH/doLogin.php", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_LONG).show();

                                check = true;
                                pw = response.getString("password");
                                id = response.getString("staffID");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    if (check) {

                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        intent.putExtra("staffID", id);
                        intent.putExtra("password", pw);
                        startActivity(intent);
                    }

                }
            }
        });
    }
}


