package com.example.profile_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.nio.charset.MalformedInputException;

public class MainActivity extends AppCompatActivity {
    private ImageView teamicon;
    private EditText  teamname;
    private EditText  teamAdd;
    private Button mapSearch;
    private static final String[] PERMISSION_EXTERNAL_STORAGE = new String[] {
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    private static final int REQUEST_EXTERNAL_STORAGE = 100;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA };


    public int verifyPermissions(Activity activity,java.lang.String permission) {
        int Permission = ActivityCompat.checkSelfPermission(activity,permission);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (Permission == PackageManager.PERMISSION_GRANTED) {
            builder.setMessage("已经同意权限");
            return 1;
        }else{
            builder.setMessage("没有同意权限");
            return 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        teamicon = (ImageView)findViewById(R.id.ivcoin);
        teamname = (EditText)findViewById(R.id.etteamN);
        teamAdd  = (EditText)findViewById(R.id.etteamA);
        mapSearch= (Button)findViewById(R.id.btmap);

        mapSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnOpenInGoogleMap(v);
            }
        });
        teamicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSetAvatarButton(v);
            }
        });

        verifyPermissions(MainActivity.this,PERMISSIONS_STORAGE[0]);


    }


    public void OnOpenInGoogleMap(View view){
        Uri gmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAdd.getText());
        Intent mapIntent= new Intent(Intent.ACTION_VIEW,gmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }


    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult (intent,0);
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if (resultCode == RESULT_CANCELED) return;
        data = getIntent();

        if(data.getStringExtra("new") != null){
            teamicon.setImageBitmap(BitmapFactory.decodeFile(data.getStringExtra("new")));

        }
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID",R.id.imageView)) {
            case R.id.imageView:
                drawableName = "ic_logo_00";
                break;
            case R.id.imageView2:
                drawableName = "ic_logo_01";
                break;
            case R.id.imageView3:
                drawableName = "ic_logo_02";
                break;
            case R.id.imageView4:
                drawableName = "ic_logo_03";
                break;
            case R.id.imageView5:
                drawableName = "ic_logo_04";
                break;
            case R.id.imageView6:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        teamicon.setImageResource(resID);


    }



}