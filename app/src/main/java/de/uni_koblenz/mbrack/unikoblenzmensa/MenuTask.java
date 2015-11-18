package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MenuTask extends AsyncTask<Void, Void, List<Menu>> {

    public static final String API_URL = "http://www.studierendenwerk-koblenz.de/api/speiseplan/speiseplan.xml";

    private MenuItemAdapter menuItemAdapter;

    public MenuTask(MenuItemAdapter menuAdapter) {
        this.menuItemAdapter = menuAdapter;
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
        updateAdapter(menus);
        removeProgressBar();
    }

    private void addProgressBar() {
    }

    private void updateAdapter(List<Menu> menus) {
        menuItemAdapter.menuItems.clear();
        menuItemAdapter.addAll(menus.get(0).menuItems); // todo: Use one adapter for each date and update them all
        menuItemAdapter.notifyDataSetChanged();
    }

    private void removeProgressBar() {
    }
}
