package com.masteru.mybiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvUsername;
    Button btnLogout;

    private Utilities utilities = new Utilities();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tv_username);
        btnLogout = findViewById(R.id.btn_logout);

        if (!utilities.isLogin(this,"xUsername")){
            Intent intent = new Intent(this, activity_login.class);
            startActivity(intent);
            finish();
        }
        else {
            String username = utilities.getPref(this, "xUsername");
            tvUsername.setText(username);
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilities.setPref(MainActivity.this, "xUsername", null);
                Intent intent = new Intent(MainActivity.this, activity_login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}