package com.extremedesign.matka.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.extremedesign.matka.fragments.ViewPagerFragment;

public class HomeViewPagerAdapter extends FragmentPagerAdapter {


    public HomeViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new ViewPagerFragment(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
