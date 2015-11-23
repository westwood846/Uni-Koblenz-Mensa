package de.uni_koblenz.mbrack.unikoblenzmensa.util;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectCache {
    private File cacheDir;

    public ObjectCache(File cacheDir) {
        this.cacheDir = cacheDir;
    }

    public void writeObject(String key, Object object) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(cacheDir, key));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
        fos.close();
    }

    public Object readObject(String key) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File(cacheDir, key));
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }
}
