package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenusActivity extends AppCompatActivity {
    private ListView listView;
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

        listView = (ListView) findViewById(R.id.menu_item_list);

        setupAdapters();
//        listView.setAdapter(menuItemAdapter);
        updateMenus();
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
