package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MenuAdapter extends RecyclerView.Adapter {
    private String[] items = new String[]{"Alle", "Meine", "Entchen"};

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView newView = ((TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_text_view, parent, false));
        ViewHolder newViewHolder = new ViewHolder(newView);
        return newViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).textView.setText(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
