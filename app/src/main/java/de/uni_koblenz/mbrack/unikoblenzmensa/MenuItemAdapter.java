package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
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

//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public CardView cardView;
//        public ViewHolder(CardView v) {
//            super(v);
//            cardView = v;
//        }
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        CardView newView = ((CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_card_view, parent, false));
//        ViewHolder newViewHolder = new ViewHolder(newView);
//        return newViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        CardView cardToAdapt = ((ViewHolder) holder).cardView;
//        TextView textToReplace = (TextView) cardToAdapt.findViewById(R.id.menu_item_card_view_text);
//        textToReplace.setText(menus.get(0).menuItems.get(position).description);
//    }
//
//    @Override
//    public int getItemCount() {
//        if (menus == null) {
//            return 0;
//        } else {
//            return menus.get(0).menuItems.size();
//        }
//    }
}
