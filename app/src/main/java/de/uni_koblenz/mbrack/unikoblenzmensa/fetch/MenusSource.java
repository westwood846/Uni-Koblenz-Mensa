package de.uni_koblenz.mbrack.unikoblenzmensa.fetch;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

import de.uni_koblenz.mbrack.unikoblenzmensa.entity.Menu;

public interface MenusSource {
    List<Menu> getMenus() throws MenusNotAvailableException;
}
