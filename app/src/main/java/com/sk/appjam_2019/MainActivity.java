package com.sk.appjam_2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.sk.appjam_2019.view.AuthActivity;
import com.sk.appjam_2019.view.ClothesFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_viewpager)
    ViewPager main_viewpager;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottom_navigation;

    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        initViewPager();
        initBottom();
    }

    private void initViewPager() {
        main_viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new ClothesFragment();
                    case 1:
                        return new ClothesFragment();
                    case 2:
                        return new ClothesFragment();
                    case 3:
                        return new ClothesFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });

        main_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(true);
                }
                bottom_navigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initBottom() {
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_1:
                        main_viewpager.setCurrentItem(0);
                        break;
                    case R.id.nav_2:
                        main_viewpager.setCurrentItem(1);
                        break;
                    case R.id.nav_3:
                        main_viewpager.setCurrentItem(2);
                        break;
                    case R.id.nav_4:
                        main_viewpager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });


    }
}
