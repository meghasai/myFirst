package com.tut;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PhotoActivity extends AppCompatActivity {
    int TAKE_PHOTO_CODE = 0;
    ImageView userImage ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button capture = (Button) findViewById(R.id.button4);
        userImage = (ImageView) findViewById(R.id.imageView2);
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
            }
        });
        }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
            Intent redirect = new Intent(PhotoActivity.this, MainActivity.class);
            startActivity(redirect);
            Log.d("CameraDemo", "Pic saved");
        }
    }

    public void redirectToHome(View v) {
        Intent redirect = new Intent(PhotoActivity.this, MainActivity.class);
        startActivity(redirect);
    }

    }










