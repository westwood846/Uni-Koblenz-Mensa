package de.uni_koblenz.mbrack.unikoblenzmensa.fetch;

import android.content.Context;

import java.io.IOException;
import java.util.List;

import de.uni_koblenz.mbrack.unikoblenzmensa.entity.Menu;
import de.uni_koblenz.mbrack.unikoblenzmensa.util.ObjectCache;

public class CacheMenusFetcher implements MenusSource {
    public static final String STORE_KEY = "menus";

    private Context context;

    public CacheMenusFetcher(Context context) {
        this.context = context;
    }

    @Override
    public List<Menu> getMenus() throws MenusNotAvailableException {
        try {
            return (List<Menu>) ObjectCache.readObject(context, STORE_KEY);
        } catch (IOException | ClassNotFoundException e) {
            throw new MenusNotAvailableException();
        }
    }

    public void storeMenus(List<Menu> menus) {
        try {
            ObjectCache.writeObject(context, STORE_KEY, menus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
