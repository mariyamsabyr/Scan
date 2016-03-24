package com.example.user.scanyourdocs;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Context mContext;
    FragmentTransaction fragmentTransaction;

    Fragment folderFragment;

    ImageView plus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        folderFragment=new FolderFragment();

        mContext = MainActivity.this;
        fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Главное");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(mContext,
                        CameraActivity.class);
                startActivity(nextActivity);
            }
        });
        fab.setImageResource(R.drawable.camera1);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    /*
    public void onClick(View v){
        fragmentTransaction =getFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.folder:
                fragmentTransaction.replace(R.id.main_container,folderFragment);
                break;
        }
    }*/
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_delete) {
            return true;
        }else if (id == R.id.action_replace) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home_id) {
            fragmentTransaction =getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new HomeFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Главное");
            item.setChecked(true);

        } else if (id == R.id.alldocs_id) {
            fragmentTransaction =getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new AlldocsFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Все документы");
            item.setChecked(true);

        } else if (id == R.id.bookmarks_id) {
            fragmentTransaction =getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new BookmarksFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Избранное");
            item.setChecked(true);

        } else if (id == R.id.settings_id) {
            fragmentTransaction =getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new SettingsFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Настройки");
            item.setChecked(true);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
