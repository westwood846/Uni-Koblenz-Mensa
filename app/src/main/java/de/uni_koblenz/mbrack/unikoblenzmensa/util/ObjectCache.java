package de.uni_koblenz.mbrack.unikoblenzmensa.util;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectCache {
    public static void writeObject(Context context, String key, Object object) throws IOException {
        File chacheDir = context.getCacheDir();
        FileOutputStream fos = new FileOutputStream(new File(chacheDir, key));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
        fos.close();
    }

    public static Object readObject(Context context, String key) throws IOException, ClassNotFoundException {
        File chacheDir = context.getCacheDir();
        FileInputStream fis = new FileInputStream(new File(chacheDir, key));
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }
}
