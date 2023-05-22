package com.example.newsandblogsapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

public class GuestMain extends AppCompatActivity {
    /**
     * Attributes declaration which we are defined in GuestMainActivity menu
     */
    private BottomAppBar bottomAppBar;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    NewsFragmentAdapter newsfragmentAdapter;
    ArticlesFragmentAdapter articlesFragmentAdapter;
    private FloatingActionButton floatingActionButton;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_main);

        tabLayout = findViewById(R.id.tabs);
        viewPager2 = findViewById(R.id.viewPager2);
        bottomAppBar = findViewById(R.id.bottomAppBar);
        floatingActionButton = findViewById(R.id.floating);
        drawerLayout = findViewById(R.id.drawable);
        navigationView = findViewById(R.id.navMenu);

        /**
         * Navigation drawer implementation through floating action button
         */
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(GuestMain.this, "You clicked floating button", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        /**
         * Navigation drawer option setting
         */

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu_home:
                        Toast.makeText(GuestMain.this, "Home is opened", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        openNews();
                        break;
                    case R.id.menu_setting:
                        Toast.makeText(GuestMain.this, "Settings are opened", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_login:
                        Toast.makeText(GuestMain.this, "Login page is opened", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(GuestMain.this,LoginMain.class);
                        startActivity(intent);
                        break;
                    case R.id.menu_signup:
                        Toast.makeText(GuestMain.this, "Create your account", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(GuestMain.this,SignupMain.class);
                        startActivity(intent1);
                        break;
                }

                return true;
            }
        });

        /**
         * Implementation of tab layout and view pager2
         */
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        openNews();
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GuestMain.this, "You clicked Bottom Bar", Toast.LENGTH_SHORT).show();
            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.news:
                        Toast.makeText(GuestMain.this,"You can search",Toast.LENGTH_SHORT).show();
                        openNews();
                        return true;
                    case R.id.articles:
                        Toast.makeText(GuestMain.this,"You clicked articles",Toast.LENGTH_SHORT).show();
                        openArticles();
                        return true;
                }
                return false;
            }

            /**
             * Function for the articles tab
             */
            private void openArticles() {
                tabLayout.setVisibility(View.VISIBLE);
                tabLayout.removeAllTabs();

                FragmentManager fm = getSupportFragmentManager();
                articlesFragmentAdapter = new ArticlesFragmentAdapter(fm, getLifecycle());
                viewPager2.setAdapter(articlesFragmentAdapter);

                tabLayout.addTab(tabLayout.newTab().setText("Home"));
                tabLayout.addTab(tabLayout.newTab().setText("Pol Sci"));
                tabLayout.addTab(tabLayout.newTab().setText("Economy"));
                tabLayout.addTab(tabLayout.newTab().setText("Religions"));
                tabLayout.addTab(tabLayout.newTab().setText("Debate"));
                tabLayout.addTab(tabLayout.newTab().setText("Others"));

                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager2.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            }
        });
    }
    private void openNews() {
        tabLayout.removeAllTabs();
        tabLayout.setVisibility(View.VISIBLE);
        FragmentManager fm = getSupportFragmentManager();
        newsfragmentAdapter = new NewsFragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(newsfragmentAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("International"));
        tabLayout.addTab(tabLayout.newTab().setText("Economy"));
        tabLayout.addTab(tabLayout.newTab().setText("Regions"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}