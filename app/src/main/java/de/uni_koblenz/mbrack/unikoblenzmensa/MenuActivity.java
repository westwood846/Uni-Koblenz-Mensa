package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MenuActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = (RecyclerView) findViewById(R.id.activity_menu_recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        menuAdapter = new MenuAdapter();
        recyclerView.setAdapter(menuAdapter);
        updateMenus();
    }

    private void updateMenus() {
        MenuTask menuTask = new MenuTask(menuAdapter);
        menuTask.execute();
    }
}
