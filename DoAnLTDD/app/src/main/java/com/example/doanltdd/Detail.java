package com.example.doanltdd;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {
    TextView itemclick2_name, itemclick2_noidung;
    ImageView itemclick2_imgView;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        itemclick2_name=(TextView)findViewById(R.id.itemclick2_name);
        itemclick2_noidung=(TextView)findViewById(R.id.itemclick2_noidung);
        itemclick2_imgView=(ImageView) findViewById(R.id.itemclick2_imgview);
        bundle = getIntent().getExtras();
        if(bundle != null)
        {
            String name = bundle.getString("name");
            String noidung=bundle.getString("noidung");
            setUp(name,noidung);
        }
    }

    private void setUp(String name, String noidung) {
        if (name.equals("imgView")) {
            itemclick2_imgView.setImageResource(R.drawable.bt1);
            itemclick2_name.setText(name);
            itemclick2_noidung.setText(noidung);
        } else {
            itemclick2_imgView.setImageResource(R.drawable.ani);
            itemclick2_name.setText(name);
            itemclick2_noidung.setText(noidung);
        }
    }
}