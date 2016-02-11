package com.tut;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickPhoto(View view )
    {
        Intent redirect = new Intent(MainActivity.this, PhotoActivity.class);
        startActivity(redirect);}

    public void openGallery(View view)
    {
    Intent redirect =new Intent(MainActivity.this,Gallery.class);
    startActivity(redirect);
    }



    public void checkSignUp(View view) {

        EditText get_name = (EditText)findViewById(R.id.name);
        EditText get_password = (EditText) findViewById(R.id.password);
        EditText get_username = (EditText)findViewById(R.id.username);
        EditText get_email = (EditText) findViewById(R.id.email);
        EditText get_phone = (EditText)findViewById(R.id.phone);
        EditText get_repassword = (EditText) findViewById(R.id.editText6);
        TextView errorText = (TextView)findViewById(R.id.lbl_Error);
        TextView errorText1 = (TextView)findViewById(R.id.lbl_Error1);


        String Name = get_name.getText().toString();
        String password = get_password.getText().toString();
        String userName = get_username.getText().toString();
        String Email = get_email.getText().toString();
        String Phone = get_phone.getText().toString();
        String repassword = get_repassword.getText().toString();

        if(!password.equals(repassword))
        {errorText1.setVisibility(View.VISIBLE);}
        else
        {
            if(!Name.isEmpty() && !password.isEmpty() && !userName.isEmpty()&& !Email.isEmpty() && !Phone.isEmpty()){

                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        else
                errorText.setVisibility(View.VISIBLE);

        }

    }
}
