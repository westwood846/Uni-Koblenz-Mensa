package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MenuTask extends AsyncTask<Void, Void, List<Menu>> {

    public static final String API_URL = "http://www.studierendenwerk-koblenz.de/api/speiseplan/speiseplan.xml";

    private List<MenuItemAdapter> menuItemAdapters;

    public MenuTask(List<MenuItemAdapter> menuItemAdapters) {
        this.menuItemAdapters = menuItemAdapters;
    }

    @Override
    protected void onPreExecute() {
        addProgressBar();
    }

    @Override
    protected List<Menu> doInBackground(Void... params) {
        List<Menu> menus = null;

        try {
            InputStream xmlStream = Util.downloadUrl(API_URL);
            MenuParser menuParser = new MenuParser();
            menus = menuParser.parse(xmlStream);
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }

        return menus;
    }

    @Override
    protected void onPostExecute(List<Menu> menus) {
        sanityCheck(menus);
        updateAdapter(menus);
        removeProgressBar();
    }

    private void addProgressBar() {
    }

    private void sanityCheck(List<Menu> menus) {
    }

    private void updateAdapter(List<Menu> menus) {
        for (int i = 0; i < Math.min(menus.size(), menuItemAdapters.size()); i++) {
            Menu menu = menus.get(i);
            MenuItemAdapter menuItemAdapter = menuItemAdapters.get(i);
            menuItemAdapter.menuItems.clear();
            menuItemAdapter.addAll(menu.menuItems);
            menuItemAdapter.notifyDataSetChanged();
        }
    }

    private void removeProgressBar() {
    }
}
