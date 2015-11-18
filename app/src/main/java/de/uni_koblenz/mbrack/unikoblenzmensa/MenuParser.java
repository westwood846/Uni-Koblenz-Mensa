package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/*
    See https://developer.android.com/training/basics/network-ops/xml.html
 */

public class MenuParser {
    private static final String namespace = null;

    private MenuItemCurator menuItemCurator = new MenuItemCurator();

    public List<Menu> parse(InputStream xmlIn) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(xmlIn, null);
            parser.nextTag();
            return readMensamenue(parser);
        } finally {
            xmlIn.close();
        }
    }

    private List<Menu> readMensamenue(XmlPullParser parser) throws IOException, XmlPullParserException {
        List<Menu> readMenus = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, namespace, "Mensamenue");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("Datum")) {
                readMenus.add(readDatum(parser));
            } else {
                skip(parser);
            }
        }

        return readMenus;
    }

    private Menu readDatum(XmlPullParser parser) throws IOException, XmlPullParserException {
        List<MenuItem> readMenuItems = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, namespace, "Datum");

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            switch (parser.getName()) {
                case "menu1": readMenuItems.add(new MenuItem("Menü 1", readMenuItemDescription(parser, "menu1"))); break;
                case "menuv": readMenuItems.add(new MenuItem("Vegetarisch", readMenuItemDescription(parser, "menuv"))); break;
                case "menue": readMenuItems.add(new MenuItem("Extratheke", readMenuItemDescription(parser, "menue"))); break;
                case "menua": readMenuItems.add(new MenuItem("Abendmensa", readMenuItemDescription(parser, "menua"))); break;
                case "menub": readMenuItems.add(new MenuItem("Bistro", readMenuItemDescription(parser, "menub"))); break;
                case "menuvegan": readMenuItems.add(new MenuItem("Vegan", readMenuItemDescription(parser, "menuvegan"))); break;
                default: skip(parser);
            }
        }

        return new Menu(readMenuItems);
    }

    private String readMenuItemDescription(XmlPullParser parser, String tagName) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, namespace, tagName);
        String description = readText(parser);
        parser.require(XmlPullParser.END_TAG, namespace, tagName);
        description = menuItemCurator.curateDescription(description);
        return description;
    }

    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = null;
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private String readTextWithoutNext(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = null;
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
        }
        return result;
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
