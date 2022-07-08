package com.example.takephoto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private ImageView imageViewGetSmallPictureFromCamera;
    private TextView textViewThirdUriFromCamera;
    private Button buttonGoBack;
    private Button buttonTakeSmallPicture;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        imageViewGetSmallPictureFromCamera = findViewById(R.id.imageViewSmallViewFromCamera);
        textViewThirdUriFromCamera = findViewById(R.id.thirdEditTextGetUriPhoto);
        buttonTakeSmallPicture = findViewById(R.id.buttonTakeSmallPictureFromCamera);
        buttonGoBack = findViewById(R.id.buttonGoBack);

        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonTakeSmallPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePicturesIntent();
            }
        });
    }

    private void dispatchTakePicturesIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(ThirdActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (data != null) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imageViewGetSmallPictureFromCamera.setImageBitmap(imageBitmap);
            }
        }
    }
}