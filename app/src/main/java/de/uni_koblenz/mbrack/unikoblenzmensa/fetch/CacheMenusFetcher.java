package de.uni_koblenz.mbrack.unikoblenzmensa.fetch;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.util.List;

import de.uni_koblenz.mbrack.unikoblenzmensa.entity.Menu;
import de.uni_koblenz.mbrack.unikoblenzmensa.util.ObjectCache;

public class CacheMenusFetcher implements MenusSource {
    public static final String STORE_KEY = "menus";

    private ObjectCache objectCache;

    public CacheMenusFetcher(File cacheDir) {
        this.objectCache = new ObjectCache(cacheDir);
    }

    @Override
    public List<Menu> getMenus() throws MenusNotAvailableException {
        try {
            return (List<Menu>) objectCache.readObject(STORE_KEY);
        } catch (IOException | ClassNotFoundException e) {
            throw new MenusNotAvailableException();
        }
    }

    public void storeMenus(List<Menu> menus) {
        try {
            objectCache.writeObject(STORE_KEY, menus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
