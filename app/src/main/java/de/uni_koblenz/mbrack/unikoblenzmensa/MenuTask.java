package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.webkit.URLUtil;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MenuTask extends AsyncTask<Void, Void, List<Menu>> {

    public static final String API_URL = "http://www.studierendenwerk-koblenz.de/api/speiseplan/speiseplan.xml";

    private MenuAdapter menuAdapter;

    public MenuTask(MenuAdapter menuAdapter) {
        this.menuAdapter = menuAdapter;
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
        menuAdapter.menus = menus;
        menuAdapter.notifyDataSetChanged();
    }

    private void removeProgressBar() {
    }
}
