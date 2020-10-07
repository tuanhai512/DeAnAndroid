package com.example.doanltdd;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
DrawerLayout drawerLayout;
NavigationView navigationView;
ListView listView;
ArrayList<ItemMenu> arrayList;
MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        actionToolBar();
        actionMenu();
    }
    private void actionMenu() {
        arrayList = new ArrayList<>();
        arrayList.add(new ItemMenu("thongtin",R.drawable.ic_baseline_account_circle_24));
        arrayList.add(new ItemMenu("caidat",R.drawable.ic_outline_settings_24));
        adapter = new MenuAdapter(this,R.layout.dong_item,arrayList);
        listView.setAdapter(adapter);
    }
    private void actionToolBar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void anhXa(){
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        navigationView=(NavigationView)findViewById(R.id.navView);
        listView=(ListView)findViewById(R.id.listView);
    }
}