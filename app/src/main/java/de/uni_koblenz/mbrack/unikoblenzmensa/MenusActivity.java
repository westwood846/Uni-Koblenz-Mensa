package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class MenusActivity extends AppCompatActivity {
    private ListView listView;
    private RecyclerView.LayoutManager layoutManager;

    private MenuItemAdapter menuItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        listView = (ListView) findViewById(R.id.menu_item_list);

        menuItemAdapter = new MenuItemAdapter(this, -1, new ArrayList<MenuItem>());
        listView.setAdapter(menuItemAdapter);
        updateMenus();
    }

    private void updateMenus() {
        MenuTask menuTask = new MenuTask(menuItemAdapter);
        menuTask.execute();
    }
}
