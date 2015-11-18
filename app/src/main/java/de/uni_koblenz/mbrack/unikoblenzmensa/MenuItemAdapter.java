package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MenuItemAdapter extends ArrayAdapter<MenuItem> {
    public Context context;
    public List<MenuItem> menuItems;

    public MenuItemAdapter(Context context, int resource, List<MenuItem> menuItems) {
        super(context, resource, menuItems);
        this.context = context;
        this.menuItems = menuItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));

            RelativeLayout container = convertView == null ? ((RelativeLayout) layoutInflater.inflate(R.layout.menu_item, parent, false)) : ((RelativeLayout) convertView);
            TextView firstLine = ((TextView) container.findViewById(R.id.menu_item_first_line));
            TextView secondLine = ((TextView) container.findViewById(R.id.menu_item_second_line));

            firstLine.setText(menuItems.get(position).type);
            secondLine.setText(menuItems.get(position).description);

            return container;
    }
}
