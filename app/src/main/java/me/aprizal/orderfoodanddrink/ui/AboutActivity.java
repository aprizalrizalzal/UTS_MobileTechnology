package me.aprizal.orderfoodanddrink.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;

import de.hdodenhof.circleimageview.CircleImageView;
import me.aprizal.orderfoodanddrink.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.about);
        }

        CircleImageView circleImageView = findViewById(R.id.img_profile);
        Glide.with(this).load(R.mipmap.ic_profile_round).into(circleImageView);


        Button btnProfile=findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(v -> {
            String url = "https://www.dicoding.com/users/aprizalzal";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            Toast.makeText(this, getString(R.string.open_browser),Toast.LENGTH_LONG).show();
            startActivity(intent);
        });
    }
}