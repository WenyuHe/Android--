package com.example.cameraalbumtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("2nd", "act 2");
        //Bitmap bitmap;

        Intent intent = getIntent();
        ImageView imageview;

        imageview = (ImageView)findViewById(R.id.show_pic);
        if(intent != null)
        {
            Log.d("3rd", "act 3");
            int flag = intent.getIntExtra("flag", 0);
            if(flag == 1){//得到的是拍照后的uri
                Uri imageUri;
                imageUri = Uri.parse(intent.getStringExtra("bitmapuri"));
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                imageview.setImageBitmap(bitmap);
            }else if(flag == 2){
                String imagePath;
                imagePath = intent.getStringExtra("bitmapstr");
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                imageview.setImageBitmap(bitmap);
            }

            //byte [] bis=intent.getByteArrayExtra("bitmap");
            //bitmap= BitmapFactory.decodeByteArray(bis, 0, bis.length);

        }
    }
}
