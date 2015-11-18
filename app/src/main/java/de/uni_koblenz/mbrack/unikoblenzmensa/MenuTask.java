package de.uni_koblenz.mbrack.unikoblenzmensa;

import android.os.AsyncTask;

public class MenuTask extends AsyncTask<Void, Void, Menu[]> {

    @Override
    protected Menu[] doInBackground(Void... params) {
        Menu[] menus = new Menu[]{
                new Menu(new MenuItem[]{
                        new MenuItem("Menü 1", "Hackbraten"),
                        new MenuItem("Menü 3", "Reis"),
                        new MenuItem("Extratheke", "Nudeln")
                }),
                new Menu(new MenuItem[]{
                        new MenuItem("Menü 1", "Fisch"),
                        new MenuItem("Menü 3", "Gebratenes"),
                        new MenuItem("Extratheke", "Gekochtes")
                }),
        };
        return menus;
    }
}
