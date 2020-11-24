package com.example.profile_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.net.Uri;

public class ProfileActivity extends AppCompatActivity {
    private ImageView icon0;
    private ImageView icon1;
    private ImageView icon2;
    private ImageView icon3;
    private ImageView icon4;
    private ImageView icon5;
    private Button    load;
    private ImageView self;
    private static int RESULT_LOAD_IMAGE = 2;
    private static int REQUESTCODE_CROP = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        icon0 = (ImageView)findViewById(R.id.imageView);
        icon1 = (ImageView)findViewById(R.id.imageView2);
        icon2 = (ImageView)findViewById(R.id.imageView3);
        icon3 = (ImageView)findViewById(R.id.imageView4);
        icon4 = (ImageView)findViewById(R.id.imageView5);
        icon5 = (ImageView)findViewById(R.id.imageView6);
        load = (Button)findViewById(R.id.btloadF);



        icon0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v,icon0);
            }
        });

        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v,icon1);
            }
        });

        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v,icon2);
            }
        });

        icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v,icon3);
            }
        });

        icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v,icon4);
            }
        });

        icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTeamIcon(v,icon5);
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadNewP(v);
            }
        });
    }

    public void SetTeamIcon(View view, ImageView selectedImage) {

        Intent returnIntent = new Intent();
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    protected void LoadNewP(View view) {
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            Intent s = new Intent();
            s.putExtra("new",picturePath);
            setResult(RESULT_OK, s);
            finish();



        }}




}