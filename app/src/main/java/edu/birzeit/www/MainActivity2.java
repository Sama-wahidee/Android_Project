package edu.birzeit.www;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import edu.birzeit.www.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
DrawerLayout drawerLayout;
ImageButton imageButton;
NavigationView navigationView;
ImageButton filter;
RecyclerView recyclerView;
Adapter adapter;
List<Car> cars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        drawerLayout=findViewById(R.id.drawerlayout);
        imageButton= findViewById(R.id.buttonDrawer);
        navigationView=findViewById(R.id.navigationView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        filter = findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SideDrawerFragment sideDrawerFragment = new SideDrawerFragment();
                sideDrawerFragment.show(getSupportFragmentManager(), "SideDrawerFragment");
            }
        });
        cars = new ArrayList<Car>();
        Car newCar = new Car("BMW", R.drawable.bmwc, 5, 200, 100,"m4");
        Car newCar1 = new Car("Cadillac ", R.drawable.cadillacc, 7, 200, 200,"Escalade ");

        cars.add(newCar);
        cars.add(newCar1);

        adapter = new Adapter(cars);
        recyclerView.setAdapter(adapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId= menuItem.getItemId();
                if (itemId==R.id.navSetting){
                    Toast.makeText(MainActivity2.this, "Setting Cilcked",Toast.LENGTH_SHORT).show();
                }
                drawerLayout.close();
                return false;
            }
        });
    }
}