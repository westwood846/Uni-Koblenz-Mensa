package de.uni_koblenz.mbrack.unikoblenzmensa.entity;

import java.io.Serializable;

public class MenuItem implements Serializable {
    public String title;
    public String description;
    public MenuItemType type;

    public MenuItem(String title, String description, MenuItemType type) {
        this.title = title;
        this.description = description;
        this.type = type;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
