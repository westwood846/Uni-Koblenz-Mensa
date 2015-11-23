package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.content.Context;
import android.os.AsyncTask;

import java.io.File;
import java.util.List;

import de.uni_koblenz.mbrack.unikoblenzmensa.entity.Menu;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.APIMenusFetcher;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.CacheMenusFetcher;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.MenusNotAvailableException;
import de.uni_koblenz.mbrack.unikoblenzmensa.fetch.MenusSource;

public class MenusTask extends AsyncTask<Void, Void, List<Menu>> {
    private List<MenuItemAdapter> menuItemAdapters;
    private CacheMenusFetcher cacheMenusFetcher;

    public MenusTask(List<MenuItemAdapter> menuItemAdapters, File cacheDir) {
        this.menuItemAdapters = menuItemAdapters;
        this.cacheMenusFetcher = new CacheMenusFetcher(cacheDir);
    }

    @Override
    protected void onPreExecute() {
        addProgressBar();
    }

    @Override
    protected List<Menu> doInBackground(Void... params) {
        List<Menu> menus = null;
        APIMenusFetcher apiMenusFetcher = new APIMenusFetcher();

        try {
            menus = apiMenusFetcher.getMenus();
            System.out.println("Got menus from API");
        } catch (MenusNotAvailableException e) {
            try {
                menus = cacheMenusFetcher.getMenus();
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
        cacheMenusFetcher.storeMenus(menus);
    }
}
