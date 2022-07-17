package com.example.takephoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private ImageView imageViewFromCamera;
    private TextView textViewUri;
    private Uri photoURI;
    public String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//
//        imageViewFromCamera = findViewById(R.id.imageViewFromCamera);
//        textViewUri = findViewById(R.id.editTextTextGetUriPhoto);
//        Button buttonGoToThirdActivity = findViewById(R.id.buttonGoToThirdActivity);
//        Button buttonSetPhotoToImageView = findViewById(R.id.buttonSetPhoto);
//
//        buttonSetPhotoToImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textViewUri.setText(photoURI.toString());
//                if (photoURI != null) {
//                    imageViewFromCamera.setImageURI(photoURI);
//                } else {
//                    Toast.makeText(SecondActivity.this, "URI = " + photoURI, Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//
//
//        buttonGoToThirdActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentGoToThirdActivity = new Intent(SecondActivity.this, ThirdActivity.class);
//                startActivity(intentGoToThirdActivity);
//            }
//        });
//
//        Button buttonGoToFirstActivity = findViewById(R.id.buttonGoToFirstActivity);
//        buttonGoToFirstActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentGoToFirstActivity = new Intent(SecondActivity.this, MainActivity.class);
//                startActivity(intentGoToFirstActivity);
//            }
//        });
//
//        Button buttonCallCamera = findViewById(R.id.buttonTakeFromGallery);
//        buttonCallCamera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                takeFullPhotoFromCamera();
//            }
//        });

    }

//    private void takeFullPhotoFromCamera() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException ex) {
//                Toast.makeText(SecondActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//            if (photoFile != null) {
//                photoURI = FileProvider.getUriForFile(this,
//                        "com.example.android.fileprovider",
//                        photoFile);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//            }
//        }
//
//    }
//
//    private File createImageFile() throws IOException {
//        String timeStamp = new SimpleDateFormat("yyMMdd_HHmmss").format(new Date());
//        String imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                imageFileName,
//                ".jpg",
//                storageDir
//        );
//        currentPhotoPath = image.getAbsolutePath();
//        Toast.makeText(SecondActivity.this, "URI = " + currentPhotoPath, Toast.LENGTH_SHORT).show();
//        return image;
//    }

}