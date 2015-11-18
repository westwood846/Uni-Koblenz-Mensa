package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MenuFragment extends Fragment {
    private ListView listView;
    private MenuItemAdapter menuItemAdapter;

    public MenuFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        listView = (ListView) view.findViewById(R.id.menu_item_list);
        System.out.println(listView);
        listView.setAdapter(menuItemAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MenusActivity parentActivity = ((MenusActivity) context);
        menuItemAdapter = parentActivity.allMenuItemAdapters.get(0);
    }
}
