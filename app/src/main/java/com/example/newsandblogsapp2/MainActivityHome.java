package com.example.newsandblogsapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class MainActivityHome extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private NavigationView navigationView;
    private ArticlesFragmentAdapter articlesFragmentAdapter;
    private VideosFragmentAdapter videosFragmentAdapter;
    private MagazineFragmentAdapter magazineFragmentAdapter;
    private BooksFragmentAdapter booksFragmentAdapter;
    private NewsFragmentAdapter newsFragmentAdapter;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        viewPager2 = findViewById(R.id.viewPager2Home);
        tabLayout = findViewById(R.id.tablayout_home);
        navigationView = findViewById(R.id.navMenu);
        auth = FirebaseAuth.getInstance();

        /**
         * Bottom navigation view implementation and functionalities
         */
        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationViewHome);
        openHome();
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        btnNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.page_1:
                        openHome();
                        return true;
                    case R.id.page_2:
                        Toast.makeText(MainActivityHome.this, "You opened articles", Toast.LENGTH_SHORT).show();
                        openArticles();
                        return true;
                    case R.id.page_3:
                        Toast.makeText(MainActivityHome.this, "Watch Our Amazing Content", Toast.LENGTH_SHORT).show();
                        openVideos();
                        return true;
                    case R.id.page_4:
                        Toast.makeText(MainActivityHome.this, "Check our magazine", Toast.LENGTH_SHORT).show();
                        openMagazine();
                        return true;
                    case R.id.page_5:
                        Toast.makeText(MainActivityHome.this, "Explore more", Toast.LENGTH_SHORT).show();
                        openNavigationDrawer();
                        return true;
                }
                return false;
            }

            /**
             * Functions to implement home page functionality
             */

            /**
             * Functionalities to open navigation drawer
             */
            private void openNavigationDrawer() {
                navigationView.setVisibility(View.VISIBLE);

                navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.menu_profile:
                                Toast.makeText(MainActivityHome.this, "Edit User Profile", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                //openProfile();
                                break;
                            case R.id.menu_home:
                                Toast.makeText(MainActivityHome.this, "Home is opened", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                openHome();
                                break;
                            case R.id.menu_debate:
                                Toast.makeText(MainActivityHome.this, "Debate", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_articles:
                                Toast.makeText(MainActivityHome.this, "Articles", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                openArticles();
                                break;
                            case R.id.menu_videos:
                                Toast.makeText(MainActivityHome.this, "Watch our amazing content", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                openVideos();
                                break;
                            case R.id.menu_books:
                                Toast.makeText(MainActivityHome.this, "Our Books", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                openBooks();
                                break;
                            case R.id.menu_politics:
                                Toast.makeText(MainActivityHome.this, "Politics", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_science:
                                Toast.makeText(MainActivityHome.this, "Science", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_philosophy:
                                Toast.makeText(MainActivityHome.this, "Philosophy", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_technology:
                                Toast.makeText(MainActivityHome.this, "Technology", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_sports:
                                Toast.makeText(MainActivityHome.this, "Sports", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_economy:
                                Toast.makeText(MainActivityHome.this, "Economy", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_usa:
                                Toast.makeText(MainActivityHome.this, "USA", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_china:
                                Toast.makeText(MainActivityHome.this, "China", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_russia:
                                Toast.makeText(MainActivityHome.this, "Russia", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_subcontinent:
                                Toast.makeText(MainActivityHome.this, "Subcontinent", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_contact:
                                Toast.makeText(MainActivityHome.this, "Contact us", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_about:
                                Toast.makeText(MainActivityHome.this, "About", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_help:
                                Toast.makeText(MainActivityHome.this, "Help", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                break;
                            case R.id.menu_logout:
                                Toast.makeText(MainActivityHome.this, "User Logout", Toast.LENGTH_SHORT).show();
                                navigationView.setVisibility(View.GONE);
                                auth.signOut();
                                startActivity(new Intent(MainActivityHome.this, LoginMain.class));
                                finish();
                        }

                        return true;
                    }
                });
            }

            private void openMagazine() {
                tabLayout.removeAllTabs();
                tabLayout.setVisibility(View.VISIBLE);
                FragmentManager fm = getSupportFragmentManager();

                magazineFragmentAdapter = new MagazineFragmentAdapter(fm, getLifecycle());
                viewPager2.setAdapter(magazineFragmentAdapter);

                tabLayout.addTab(tabLayout.newTab().setText("2021"));

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

            private void openVideos() {
                tabLayout.removeAllTabs();
                tabLayout.setVisibility(View.VISIBLE);
                FragmentManager fm = getSupportFragmentManager();

                videosFragmentAdapter = new VideosFragmentAdapter(fm, getLifecycle());
                viewPager2.setAdapter(videosFragmentAdapter);

                tabLayout.addTab(tabLayout.newTab().setText("Videos"));

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

            private void openArticles() {
                tabLayout.removeAllTabs();
                tabLayout.setVisibility(View.VISIBLE);
                FragmentManager fm = getSupportFragmentManager();

                articlesFragmentAdapter = new ArticlesFragmentAdapter(fm, getLifecycle());
                viewPager2.setAdapter(articlesFragmentAdapter);

                tabLayout.addTab(tabLayout.newTab().setText("Home"));
                tabLayout.addTab(tabLayout.newTab().setText("Politics"));
                tabLayout.addTab(tabLayout.newTab().setText("Science"));
                tabLayout.addTab(tabLayout.newTab().setText("Economy"));
                tabLayout.addTab(tabLayout.newTab().setText("Debate"));

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

    private void openBooks() {
        Toast.makeText(MainActivityHome.this, "Home is selected", Toast.LENGTH_SHORT).show();
        tabLayout.removeAllTabs();

        FragmentManager fm = getSupportFragmentManager();
        booksFragmentAdapter = new BooksFragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(booksFragmentAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Books"));

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

    private void openProfile() {
        startActivity(new Intent(MainActivityHome.this, ProfileSettingActivity.class));
    }

    private void openHome() {
        Toast.makeText(MainActivityHome.this, "Home is selected", Toast.LENGTH_SHORT).show();
        tabLayout.removeAllTabs();

        FragmentManager fm = getSupportFragmentManager();
        newsFragmentAdapter = new NewsFragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(newsFragmentAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("International"));
        tabLayout.addTab(tabLayout.newTab().setText("Economy"));
        tabLayout.addTab(tabLayout.newTab().setText("Regions"));
        tabLayout.addTab(tabLayout.newTab().setText("Science & tech"));

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