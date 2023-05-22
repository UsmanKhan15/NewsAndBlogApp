package com.example.newsandblogsapp2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class NewsFragmentAdapter extends FragmentStateAdapter {
    public NewsFragmentAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fragmentManager, @NonNull @org.jetbrains.annotations.NotNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    //TODO change the fragments here I am returning one fragment for all tabs
    //TODO Change fragment for every tab
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1:
                return new HomeFragment();
            case 2:
                return new DebateFragment();
            case 3:
                return new HomeFragment();
            case 4:
                return new DebateFragment();
        }
        return new DebateFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
