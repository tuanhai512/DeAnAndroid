package com.example.doanltdd;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanltdd.adapter.ListDataAdapter;
import com.example.doanltdd.adapter.MyAdapter;
import com.example.doanltdd.model.Exercise;
import com.example.doanltdd.model.Group;
import com.example.doanltdd.model.ListData;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ListView listView;
    String mTitle[]={"Facebook","Whatsapp","Twitter"};
    String mDescription[]={"Facebook Description","Whatsapp Description","Twitter Description"};
    int images[]={R.drawable.front,R.drawable.back,R.drawable.legs};
     ListDataAdapter listDataAdapter;
    private RecyclerView rvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.rcv_Data);
        listDataAdapter = new ListDataAdapter();

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.info) {
                    Toast.makeText(getApplicationContext(), "Thông tin", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.setup) {
                    Toast.makeText(getApplicationContext(), "Cài đặt", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }


                return false;
            }
        });
        acctionToolBar();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvData.setLayoutManager(linearLayoutManager);

        listDataAdapter.setData(this, getListData());
        rvData.setAdapter(listDataAdapter);



        listView = findViewById(R.id.listView);


        MyAdapter adapter = new MyAdapter(this,mTitle,mDescription,images);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Toast.makeText(MainActivity.this,"Facebook Description",Toast.LENGTH_SHORT).show();

                }
                if (position==0)
                {
                    Toast.makeText(MainActivity.this,"Twitter Description",Toast.LENGTH_SHORT).show();

                }
                if (position==0)
                {
                    Toast.makeText(MainActivity.this, "Whatapp",Toast.LENGTH_SHORT).show();

                }
            }

        });
    }

    public void OnClick(View v)
    {
        Intent i = new Intent(getApplicationContext(),MyAdapter.class);
        startActivity(i);
    }


    private List<ListData> getListData() {
        List<ListData> listData = new ArrayList<>();

        List<Group> groupList = new ArrayList<>();
        List<Exercise> exerciseList = new ArrayList<>();

        groupList.add(new Group("Bài 1"));
        exerciseList.add(new Exercise(R.drawable.body2));
        exerciseList.add(new Exercise(R.drawable.body3));

        listData.add(new ListData(ListDataAdapter.TYPE_GROUP,groupList,null));
        listData.add(new ListData(ListDataAdapter.TYPE_EXCERCISE,null,exerciseList));

        List<Group> groupList1 = new ArrayList<>();
        List<Exercise> exerciseList1 = new ArrayList<>();
        groupList1.add(new Group("Bài 2"));
        exerciseList1.add(new Exercise(R.drawable.body2));
        listData.add(new ListData(ListDataAdapter.TYPE_GROUP,groupList1,null));
        listData.add(new ListData(ListDataAdapter.TYPE_EXCERCISE,null,exerciseList1));

        return listData;
    }


    private void acctionToolBar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
}

