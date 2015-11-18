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

        viewPagerAdapter.addFragment(new MenuFragment(), "Monday");
        viewPagerAdapter.addFragment(new MenuFragment(), "Tuesday");
        viewPagerAdapter.addFragment(new MenuFragment(), "Wednesday");
        viewPagerAdapter.addFragment(new MenuFragment(), "Thursday");
        viewPagerAdapter.addFragment(new MenuFragment(), "Friday");

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
