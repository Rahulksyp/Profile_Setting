package com.example.profilesetting.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.profilesetting.fragment.OfferingFragment;
import com.example.profilesetting.fragment.RecommendsFragment;
import com.example.profilesetting.fragment.RequestsFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new RequestsFragment();
        }
        else if (position == 1)
        {
            fragment = new OfferingFragment();
        }
        else if (position == 2)
        {
            fragment = new RecommendsFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Requests";
        }
        else if (position == 1)
        {
            title = "Offerings";
        }
        else if (position == 2)
        {
            title = "Recommends";
        }
        return title;
    }
}
