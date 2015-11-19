package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.content.Context;
import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import de.uni_koblenz.mbrack.unikoblenzmensa.entity.Menu;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.APIMenusFetcher;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.CacheMenusFetcher;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.MenuParser;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.MenusNotAvailableException;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.MenusSource;
import de.uni_koblenz.mbrack.unikoblenzmensa.util.ObjectCache;
import de.uni_koblenz.mbrack.unikoblenzmensa.util.Util;

public class MenusTask extends AsyncTask<Void, Void, List<Menu>> {

    public static final String API_URL = "http://www.studierendenwerk-koblenz.de/api/speiseplan/speiseplan.xml";

    private List<MenuItemAdapter> menuItemAdapters;
    private Context context;

    public MenusTask(List<MenuItemAdapter> menuItemAdapters, Context context) {
        this.menuItemAdapters = menuItemAdapters;
        this.context = context;
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
            System.out.println("Got menus from API");
        } catch (MenusNotAvailableException e) {
            menusSource = new CacheMenusFetcher(context);
            try {
                menus = menusSource.getMenus();
                System.out.println("Got menus from cache");
            } catch (MenusNotAvailableException e1) {
                e1.printStackTrace();
            }
        }

        return menus;
    }

    @Override
    protected void onPostExecute(List<Menu> menus) {
        sanityCheck(menus);
        updateAdapter(menus);
        removeProgressBar();
        cacheMenus(menus);
    }

    private void addProgressBar() {
    }

    private void sanityCheck(List<Menu> menus) {
        if (menus == null || menus.size() < 5) {
            throw new MenusNotAvailableException();
        }
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

    private void cacheMenus(List<Menu> menus) {
        CacheMenusFetcher cacheMenusFetcher = new CacheMenusFetcher(context);
        cacheMenusFetcher.storeMenus(menus);
    }
}
