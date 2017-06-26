package com.example.minhdv.feedbac;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    LinearLayout v;
    CircleImageView img_vi, img_el;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findID();
        img_el.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage("en");
            }
        });
        img_vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage("vi");
            }
        });
    }

    public void changeLanguage(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(
                config,
                getBaseContext().getResources().getDisplayMetrics()
        );
        Intent it = new Intent(MainActivity.this, MainActivity.class);
        startActivity(it);
    }

    public void findID() {
        v = (LinearLayout)findViewById(R.id.header);
        img_vi = (CircleImageView)v.findViewById(R.id.img_language_vi);
        img_el = (CircleImageView)v.findViewById(R.id.img_language_el);
    }

}
