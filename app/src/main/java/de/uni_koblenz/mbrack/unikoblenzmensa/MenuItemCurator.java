package de.uni_koblenz.mbrack.unikoblenzmensa;

public class MenuItemCurator {
    public String curateDescription(String description) {
        return removeZusaetze(description);
    }

    private String removeZusaetze(String description) {
        description = removeAllParenthesisWithContent(description);
        description = trimMultipleWhitespaces(description);
        return description;
    }

    private String removeAllParenthesisWithContent(String string) {
        return string.replaceAll("\\(.*?\\)", "");
    }

    private String trimMultipleWhitespaces(String string) {
        return string.replaceAll("\\s+", " ");
    }
}
