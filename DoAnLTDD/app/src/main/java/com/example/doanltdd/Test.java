package com.example.doanltdd;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import static com.example.doanltdd.R.drawable.ani;

public class Test extends AppCompatActivity {
    Toolbar mToolbar;
    ImageView flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        flag = (ImageView) findViewById(R.id.imageEX);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            mToolbar.setTitle(bundle.getString("Nguyen van a"));
            if (mToolbar.getTitle().toString().equalsIgnoreCase("Nguyen van b")){
                flag.setImageDrawable(ContextCompat.getDrawable(Test.this,ani));
            }
        }
    }
}