package com.example.newsandblogsapp2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class ArticlesFragmentAdapter extends FragmentStateAdapter {


    public ArticlesFragmentAdapter(@NonNull @NotNull FragmentManager fragmentManager, @NonNull @NotNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        //TODO change return fragments
        switch(position)
        {
            case 1:
                return new CapitalismFragment();
            case 2:
                return new ArticlesHomeFragment();
            case 3:
                return new DebateFragment();
            case 4:
                return new ScienceFragment();
            case 5:
                return new OtherArticlesFragment();
        }
        return new DebateFragment();
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
