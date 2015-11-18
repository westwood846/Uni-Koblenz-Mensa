package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        ImageView imageView = ((ImageView) container.findViewById(R.id.menu_item_icon));

        firstLine.setText(menuItems.get(position).title);
        secondLine.setText(menuItems.get(position).description);
        Resources resources = context.getResources();
        switch (menuItems.get(position).type) {
            case MENU1:
                imageView.setImageDrawable(resources.getDrawable(R.drawable.menu1));
                break;
            case VEGETARIAN:
                imageView.setImageDrawable(resources.getDrawable(R.drawable.vegetarian));
                break;
            case VEGAN:
                imageView.setImageDrawable(resources.getDrawable(R.drawable.vegan));
                break;
            case BISTRO:
                imageView.setImageDrawable(resources.getDrawable(R.drawable.bistro));
                break;
            case ABEND:
                imageView.setImageDrawable(resources.getDrawable(R.drawable.abend));
                break;
            case EXTRA:
                imageView.setImageDrawable(resources.getDrawable(R.drawable.extra));
                break;
        }

        return container;
    }
}
