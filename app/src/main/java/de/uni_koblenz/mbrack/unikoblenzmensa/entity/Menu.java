package de.uni_koblenz.mbrack.unikoblenzmensa.entity;

import java.util.Arrays;
import java.util.List;

public class Menu {
    public List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuItems=" + Arrays.toString(menuItems.toArray()) +
                '}';
    }
}
