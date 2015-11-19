package de.uni_koblenz.mbrack.unikoblenzmensa.fetch;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import de.uni_koblenz.mbrack.unikoblenzmensa.entity.Menu;
import de.uni_koblenz.mbrack.unikoblenzmensa.util.Util;

public class APIMenusFetcher implements MenusSource {

    public static final String API_URL = "http://www.studierendenwerk-koblenz.de/api/speiseplan/speiseplan.xml";

    @Override
    public List<Menu> getMenus() throws IOException, XmlPullParserException {
        InputStream xmlStream = Util.downloadUrl(API_URL);
        MenuParser menuParser = new MenuParser();
        return menuParser.parse(xmlStream);
    }
}
