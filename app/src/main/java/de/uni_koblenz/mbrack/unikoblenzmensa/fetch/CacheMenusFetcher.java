package de.uni_koblenz.mbrack.unikoblenzmensa.fetch;

import android.content.Context;

import java.io.IOException;
import java.util.List;

import de.uni_koblenz.mbrack.unikoblenzmensa.entity.Menu;
import de.uni_koblenz.mbrack.unikoblenzmensa.util.ObjectCache;

public class CacheMenusFetcher implements MenusSource {
    private Context context;

    public CacheMenusFetcher(Context context) {
        this.context = context;
    }

    @Override
    public List<Menu> getMenus() throws MenusNotAvailableException {
        try {
            return (List<Menu>) ObjectCache.readObject(context, "menus");
        } catch (IOException | ClassNotFoundException e) {
            throw new MenusNotAvailableException();
        }
    }
}
