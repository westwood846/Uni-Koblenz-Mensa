package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewParent;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenusActivity extends AppCompatActivity {
    public static final int MONDAY = 0;
    public static final int TUESDAY = 1;
    public static final int WEDNESDAY = 2;
    public static final int THURSDAY = 3;
    public static final int FRIDAY = 4;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private MenuItemAdapter mondayMenuItemAdapter;
    private MenuItemAdapter tuesdayMenuItemAdapter;
    private MenuItemAdapter wednesdayMenuItemAdapter;
    private MenuItemAdapter thursdayMenuItemAdapter;
    private MenuItemAdapter fridayMenuItemAdapter;
    public List<MenuItemAdapter> allMenuItemAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupAdapters();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        updateMenus();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        Bundle mondayBundle = new Bundle();
        Bundle tuesdayBundle = new Bundle();
        Bundle wednesdayBundle = new Bundle();
        Bundle thursdayBundle = new Bundle();
        Bundle fridayBundle = new Bundle();

        mondayBundle.putInt("day", MONDAY);
        tuesdayBundle.putInt("day", TUESDAY);
        wednesdayBundle.putInt("day", WEDNESDAY);
        thursdayBundle.putInt("day", THURSDAY);
        fridayBundle.putInt("day", FRIDAY);

        MenuFragment mondayFragment = new MenuFragment();
        MenuFragment tuesdayFragment = new MenuFragment();
        MenuFragment wednesdayFragment = new MenuFragment();
        MenuFragment thursdayFragment = new MenuFragment();
        MenuFragment fridayFragment = new MenuFragment();

        mondayFragment.setArguments(mondayBundle);
        tuesdayFragment.setArguments(tuesdayBundle);
        wednesdayFragment.setArguments(wednesdayBundle);
        thursdayFragment.setArguments(thursdayBundle);
        fridayFragment.setArguments(fridayBundle);


        viewPagerAdapter.addFragment(mondayFragment, "Monday");
        viewPagerAdapter.addFragment(tuesdayFragment, "Tuesday");
        viewPagerAdapter.addFragment(wednesdayFragment, "Wednesday");
        viewPagerAdapter.addFragment(thursdayFragment, "Thursday");
        viewPagerAdapter.addFragment(fridayFragment, "Friday");

        viewPager.setAdapter(viewPagerAdapter);
    }

    private void setupAdapters() {
        mondayMenuItemAdapter = new MenuItemAdapter(this, -1, new ArrayList<MenuItem>());
        tuesdayMenuItemAdapter = new MenuItemAdapter(this, -1, new ArrayList<MenuItem>());
        wednesdayMenuItemAdapter = new MenuItemAdapter(this, -1, new ArrayList<MenuItem>());
        thursdayMenuItemAdapter = new MenuItemAdapter(this, -1, new ArrayList<MenuItem>());
        fridayMenuItemAdapter = new MenuItemAdapter(this, -1, new ArrayList<MenuItem>());

        allMenuItemAdapters = new ArrayList<>();
        allMenuItemAdapters.add(mondayMenuItemAdapter);
        allMenuItemAdapters.add(tuesdayMenuItemAdapter);
        allMenuItemAdapters.add(wednesdayMenuItemAdapter);
        allMenuItemAdapters.add(thursdayMenuItemAdapter);
        allMenuItemAdapters.add(fridayMenuItemAdapter);
    }

    private void updateMenus() {
        MenuTask menuTask = new MenuTask(allMenuItemAdapters);
        menuTask.execute();
    }
}
