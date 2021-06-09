package me.aprizal.orderfoodanddrink.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import me.aprizal.orderfoodanddrink.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE_EAT = "extra image eat";
    public static final String EXTRA_NAME_EAT = "extra name eat";
    public static final String EXTRA_PRICE_EAT = "extra price eat";
    public static final String EXTRA_DETAIL_EAT = "extra detail eat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle(getIntent().getStringExtra(EXTRA_NAME_EAT));
        }

        ImageView imgEat = findViewById(R.id.img_eat);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvPrice = findViewById(R.id.tv_price);
        TextView tvDetail = findViewById(R.id.tv_detail);
        Button btnShare = findViewById(R.id.btn_share);

        Glide.with(this).load(getIntent().getIntExtra(EXTRA_IMAGE_EAT,0)).apply(new RequestOptions().override(555,555)).into(imgEat);
        tvName.setText(getIntent().getStringExtra(EXTRA_NAME_EAT));
        tvPrice.setText(getIntent().getStringExtra(EXTRA_PRICE_EAT));
        tvDetail.setText(getIntent().getStringExtra(EXTRA_DETAIL_EAT));

        btnShare.setOnClickListener(v -> {
            Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, getIntent().getStringExtra(EXTRA_NAME_EAT));
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text,getIntent().getStringExtra(EXTRA_NAME_EAT),getIntent().getStringExtra(EXTRA_PRICE_EAT)));
            startActivity(Intent.createChooser(intent, "Share Via"));
        });
    }
}