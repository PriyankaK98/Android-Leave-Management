package com.priyanka.leavemanagement;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class Homepage_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
        private DrawerLayout nDrawerLayout;
        private ActionBarDrawerToggle nToggle;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_homepage_);
            nDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

            int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
            setRequestedOrientation(o);

            nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.open, R.string.close);
            NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
            navigationView.setNavigationItemSelectedListener(this);


            nDrawerLayout.addDrawerListener(nToggle);
            nToggle.syncState();

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            {

                if (nToggle.onOptionsItemSelected(item)) {
                    return true;
                }
            }
            return super.onOptionsItemSelected(item);
        }


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.nav_Leave) {
                Intent i = new Intent(Homepage_Activity.this, TypeActivity.class);
                startActivity(i);
            }
            if (id == R.id.nav_Logout) {
                Intent i = new Intent(Homepage_Activity.this, IconActivity.class);
                startActivity(i);
            }

            return false;
        }

}
