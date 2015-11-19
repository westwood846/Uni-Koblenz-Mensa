package de.uni_koblenz.mbrack.unikoblenzmensa.util;

public class MenuItemCurator {
    public String curateDescription(String description) {
        return removeZusaetze(description);
    }

    private String removeZusaetze(String description) {
        description = removeAllParenthesisWithContent(description);
        description = removeMultipleWhitespaces(description);
        description = removeSpacesBeforeCommas(description);
        description = ensureSpacesAfterPunctuation(description);
        return description;
    }

    public String removeAllParenthesisWithContent(String string) {
        return string.replaceAll("\\(.*?\\)", "");
    }

    public String removeMultipleWhitespaces(String string) {
        return string.replaceAll("\\s+", " ");
    }

    public String removeSpacesBeforeCommas(String string) {
        return string.replaceAll("\\s+,", ",");
    }

    public String ensureSpacesAfterPunctuation(String string) {
        return string.replaceAll("([,.!?;:])([a-zA-Z])", "$1 $2");
    }
}
