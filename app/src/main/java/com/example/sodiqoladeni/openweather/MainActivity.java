package com.example.sodiqoladeni.openweather;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding Toolbar to Main screen
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setting ViewPager for each Tabs
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(2);
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        TabLayout tabs = findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(viewPager);

    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        MainActivity.Adapter adapter = new MainActivity.Adapter(getSupportFragmentManager());
        adapter.addFragment(new WeatherFragment(), getString(R.string.weather));
        adapter.addFragment(new SunriseFragment(), getString(R.string.sunrise_sent));
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
