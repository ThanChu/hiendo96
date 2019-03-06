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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

import me.maxdev.popularmoviesapp.R;

public class LoginActivity extends AppCompatActivity {

    private ImageView btnVietnamese;
    private ImageView btnEnglish;
    private EditText edtPhone, edtPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnVietnamese = (ImageView) findViewById(R.id.btn_vn);
        btnEnglish = (ImageView) findViewById(R.id.btn_en);
        edtPhone = (EditText) findViewById(R.id.edt_phone);
        edtPass = (EditText) findViewById(R.id.edt_pass);

        btnVietnamese.setOnClickListener(v -> changeLanguage("vi"));
        btnEnglish.setOnClickListener(v -> changeLanguage("en"));

        btnLogin.setOnClickListener(v -> {
            String phone = edtPhone.getText() + "";
            String pass = edtPass.getText() + "";

            if("".equals(phone) || "".equals(pass)){
                Toast.makeText(this, R.string.text_message_notice, Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("phone", (phone).trim());
            startActivity(intent);
            finish();
        });

    }

    private void changeLanguage(String language) {
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
