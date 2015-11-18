package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

public class MenuTask extends AsyncTask<Void, Void, Menu[]> {

    private MenuAdapter menuAdapter;

    public MenuTask(MenuAdapter menuAdapter) {
        this.menuAdapter = menuAdapter;
    }

    @Override
    protected void onPreExecute() {
        addProgressBar();
    }

    @Override
    protected Menu[] doInBackground(Void... params) {
        Menu[] menus = new Menu[]{
                new Menu(new MenuItem[]{
                        new MenuItem("Menü 1", "Hackbraten"),
                        new MenuItem("Menü 3", "Reis"),
                        new MenuItem("Extratheke", "Nudeln")
                }),
                new Menu(new MenuItem[]{
                        new MenuItem("Menü 1", "Fisch"),
                        new MenuItem("Menü 3", "Gebratenes"),
                        new MenuItem("Extratheke", "Gekochtes")
                }),
        };
        return menus;
    }

    @Override
    protected void onPostExecute(Menu[] menus) {
        updateAdapter(menus);
        removeProgressBar();
    }

    private void addProgressBar() {
    }

    private void updateAdapter(Menu[] menus) {
        menuAdapter.menus = menus;
        menuAdapter.notifyDataSetChanged();
    }

    private void removeProgressBar() {
    }
}
