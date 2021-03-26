package com.mp.aimsofttwo.videoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.StackView;

public class MainActivity<StickerView> extends AppCompatActivity {
    private static int VIDEO_REQUEST = 101;
    private Uri videoUri = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void captureVideo(View view)
    {
        Intent videoIntent  = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if(videoIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(videoIntent, VIDEO_REQUEST);
        }

    }

    public void playVideo(View view)
    {
        Intent playIntent = new Intent(this, VideoPlayActivity.class);
        playIntent.putExtra("videoUri",videoUri.toString());
        startActivity(playIntent);
    }

    public void testVideo2(View view){
        Intent it2 = new Intent(this, MainActivity2.class);
       // playIntent.putExtra("videoUri",videoUri.toString());
        startActivity(it2);
    }


    @SuppressLint("MissingSuperCall")
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == VIDEO_REQUEST && resultCode == RESULT_OK) {
            videoUri = data.getData();
        }
    }
}