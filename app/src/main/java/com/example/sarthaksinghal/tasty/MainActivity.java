package com.example.sarthaksinghal.tasty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void registerUser(View view){
        if(view==findViewById(R.id.registerb)){
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);

        }

    }
    public void loginUser(View view){
        if(view==findViewById(R.id.loginb)){
            //Toast.makeText(getApplicationContext(),"User has successfully registered",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);

        }
    }
}
