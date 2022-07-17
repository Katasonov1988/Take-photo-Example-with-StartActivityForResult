package com.example.takephoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private ImageView imageViewFromCamera;
    private Uri photoURI;
    public String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageViewFromCamera = findViewById(R.id.imageViewFromCamera);

        Button buttonSetPhotoToImageView = findViewById(R.id.buttonSetPhoto);
        buttonSetPhotoToImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (photoURI != null) {
                    imageViewFromCamera.setImageURI(photoURI);
                } else {
                    Toast.makeText(SecondActivity.this, "URI = " + photoURI, Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button buttonGoToThirdActivity = findViewById(R.id.buttonGoToThirdActivity);
        buttonGoToThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToThirdActivity = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intentGoToThirdActivity);
            }
        });

        Button buttonGoToFirstActivity = findViewById(R.id.buttonGoToFirstActivity);
        buttonGoToFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToFirstActivity = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intentGoToFirstActivity);
            }
        });

        Button buttonCallCamera = findViewById(R.id.buttonTakeFromGallery);
        buttonCallCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeFullPhotoFromCamera();
            }
        });

    }

    private void takeFullPhotoFromCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(SecondActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fireproof",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    private File createImageFile() throws IOException {
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
        currentPhotoPath = image.getAbsolutePath();
        Toast.makeText(SecondActivity.this, "URI = " + currentPhotoPath, Toast.LENGTH_SHORT).show();
        return image;
    }

}