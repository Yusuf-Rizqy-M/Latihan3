package com.example.latihan3;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import fragmentnavigasibottom.api_kedua;
import fragmentnavigasibottom.api_pertama;
import com.google.android.material.navigation.NavigationView;

public class navigasi_bottom extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigasi_bottom);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showLigaInggris();

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.api1) {
                    showLigaInggris();
                } else if (itemId == R.id.api2) {
                    showLigaSpanyol();
                } else{
                    showProfile();
                }


                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void showLigaInggris() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new api_pertama())
                .commit();

        getSupportActionBar().setTitle("Liga Inggris");
    }
    private void showLigaSpanyol() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new api_kedua())
                .commit();

        getSupportActionBar().setTitle("Liga Spanyol");
    }
    private void showProfile() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new ProfileFragment())
                .commit();

        getSupportActionBar().setTitle("Profile");
    }

}