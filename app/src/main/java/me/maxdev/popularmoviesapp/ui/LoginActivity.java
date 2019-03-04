package me.maxdev.popularmoviesapp.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;

import me.maxdev.popularmoviesapp.R;

public class LoginActivity extends AppCompatActivity {

    private ImageView btnVietnamese;
    private ImageView btnEnlish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnVietnamese = (ImageView) findViewById(R.id.btn_vn);
        btnEnlish = (ImageView) findViewById(R.id.btn_en);

        btnVietnamese.setOnClickListener( v -> changeLangue("vi"));
        btnEnlish.setOnClickListener( v -> changeLangue("en"));

        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }

    private void changeLangue(String language) {
        Locale myLocale = new Locale(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, LoginActivity.class);
        startActivity(refresh);
        finish();
    }
}
