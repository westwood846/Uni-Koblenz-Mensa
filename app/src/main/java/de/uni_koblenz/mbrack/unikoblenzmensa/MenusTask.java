package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import de.uni_koblenz.mbrack.unikoblenzmensa.entity.Menu;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.APIMenusFetcher;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.MenuParser;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.MenusNotAvailableException;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.MenusSource;
import de.uni_koblenz.mbrack.unikoblenzmensa.util.Util;

public class MenusTask extends AsyncTask<Void, Void, List<Menu>> {

    public static final String API_URL = "http://www.studierendenwerk-koblenz.de/api/speiseplan/speiseplan.xml";

    private List<MenuItemAdapter> menuItemAdapters;

    public MenusTask(List<MenuItemAdapter> menuItemAdapters) {
        this.menuItemAdapters = menuItemAdapters;
    }

    @Override
    protected void onPreExecute() {
        addProgressBar();
    }

    @Override
    protected List<Menu> doInBackground(Void... params) {
        List<Menu> menus = null;
        MenusSource menusSource = new APIMenusFetcher();

        try {
            menus = menusSource.getMenus();
        } catch (MenusNotAvailableException e) {
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
