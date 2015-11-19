package de.uni_koblenz.mbrack.unikoblenzmensa;

import org.junit.Before;
import org.junit.Test;

import de.uni_koblenz.mbrack.unikoblenzmensa.util.MenuItemCurator;

import static org.junit.Assert.*;

public class MenuItemCuratorTest {
    MenuItemCurator menuItemCurator;

    @Before
    public void setUp() throws Exception {
        menuItemCurator = new MenuItemCurator();
    }

    @Test
    public void testRemoveAllParenthesisWithContent() throws Exception {
        assertEquals(menuItemCurator.removeAllParenthesisWithContent("()"), "");
        assertEquals(menuItemCurator.removeAllParenthesisWithContent("(bla)"), "");
        assertEquals(menuItemCurator.removeAllParenthesisWithContent("(bla)bla"), "bla");
        assertEquals(menuItemCurator.removeAllParenthesisWithContent("(bla)bla(bla)"), "bla");
        assertEquals(menuItemCurator.removeAllParenthesisWithContent("bla"), "bla");
        assertEquals(menuItemCurator.removeAllParenthesisWithContent(")bla("), ")bla(");
    }

    @Test
    public void testRemoveMultipleWhitespaces() throws Exception {
        assertEquals(menuItemCurator.removeMultipleWhitespaces("  "), " ");
        assertEquals(menuItemCurator.removeMultipleWhitespaces("   "), " ");
        assertEquals(menuItemCurator.removeMultipleWhitespaces("a  "), "a ");
        assertEquals(menuItemCurator.removeMultipleWhitespaces("  a"), " a");
        assertEquals(menuItemCurator.removeMultipleWhitespaces("  a  "), " a ");
        assertEquals(menuItemCurator.removeMultipleWhitespaces("a  a"), "a a");
    }

    @Test
    public void testRemoveSpacesBeforeCommas() throws Exception {
        assertEquals(menuItemCurator.removeSpacesBeforeCommas(" ,"), ",");
        assertEquals(menuItemCurator.removeSpacesBeforeCommas(" , "), ", ");
        assertEquals(menuItemCurator.removeSpacesBeforeCommas("  ,"), ",");
        assertEquals(menuItemCurator.removeSpacesBeforeCommas(","), ",");
        assertEquals(menuItemCurator.removeSpacesBeforeCommas(" ."), " .");
        assertEquals(menuItemCurator.removeSpacesBeforeCommas("."), ".");
    }

    @Test
    public void testEnsureSpacesAfterPunctuation() throws Exception {
        assertEquals(menuItemCurator.ensureSpacesAfterPunctuation(".A"), ". A");
        assertEquals(menuItemCurator.ensureSpacesAfterPunctuation(",A"), ", A");
        assertEquals(menuItemCurator.ensureSpacesAfterPunctuation(".5"), ".5");
        assertEquals(menuItemCurator.ensureSpacesAfterPunctuation(",5"), ",5");
        assertEquals(menuItemCurator.ensureSpacesAfterPunctuation("."), ".");
        assertEquals(menuItemCurator.ensureSpacesAfterPunctuation(","), ",");

    }
}
