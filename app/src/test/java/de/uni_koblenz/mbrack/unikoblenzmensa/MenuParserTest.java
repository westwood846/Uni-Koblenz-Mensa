package de.uni_koblenz.mbrack.unikoblenzmensa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import de.uni_koblenz.mbrack.unikoblenzmensa.util.MenuParser;

public class MenuParserTest {
    InputStream xmlInputStream;
    MenuParser parser = new MenuParser();

    @Before
    public void setUp() throws Exception {
        File xmlFile = new File("res/");
        System.out.println(xmlFile.getAbsolutePath());
        xmlInputStream = new FileInputStream(new File("src/test/res/test_speiseplan.xml"));

    }

    @Test
    public void testParse() throws Exception {
//        List<Menu> result = parser.parse(xmlInputStream);
//        assertEquals(result.size(), 2);
        // TODO: Cannot test this since tests cannot access android specific code
        // https://sites.google.com/a/android.com/tools/tech-docs/unit-testing-support#TOC-Method-...-not-mocked.-
    }

    @After
    public void tearDown() throws Exception {
        xmlInputStream.close();
    }
}
