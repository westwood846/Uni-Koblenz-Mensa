package de.uni_koblenz.mbrack.unikoblenzmensa;

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

    private String removeAllParenthesisWithContent(String string) {
        return string.replaceAll("\\(.*?\\)", "");
    }

    private String removeMultipleWhitespaces(String string) {
        return string.replaceAll("\\s+", " ");
    }

    private String removeSpacesBeforeCommas(String string) {
        return string.replaceAll("\\s+,", ",");
    }

    private String ensureSpacesAfterPunctuation(String string) {
        return string.replaceAll("([,.!?;:])([a-zA-Z])", "$1 $2");
    }
}
