package de.uni_koblenz.mbrack.unikoblenzmensa;

import org.junit.Test;

import java.io.InputStream;
import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class UtilTest {
    @Test
    public void testDownloadUrl() throws Exception {
        InputStream download = Util.downloadUrl("http://google.com/");
        assertNotNull(download);
        download.close();
    }

    @Test(expected = java.net.MalformedURLException.class)
    public void testDownloadInvalidUrl() throws Exception {
        Util.downloadUrl("");
    }
}
