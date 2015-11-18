# Uni Koblenz Mensa
Diese App soll die von den meisten Studierenden nur für ihre Speiseplan-Funktion Studierenden-Portal App ersetzen, da diese zumindest vom Design her komplett veraltet ist.

Die App soll nur die Speiseplan-Funktion replizieren und dabei minimalistisch bleiben. Ich würde gerne auf die Rating-Funktion verzichten und vor allem das blöde Akkordion loswerden, damit alle Gerichte auf einen Blick sichtbar sind. Idealer Weise muss der Nutzer mit nur einem Touch die App öffnen um den aktuellen Speiseplan einsehen zu können. 

## Dependencies
Android SDK API Level 23. Am einfachsten ist es, Android Studio zu installieren und im SDK Manager die entsprechenden Pakete auszuwählen.

## Testing
Unit-Tests wären sicherlich hilfreich :D Ich entwickle die App mit [Genymotion](https://www.genymotion.com/#!/) als Emulator, damit ich nicht mit einem echten Handy rumhampeln muss. 

## Contributing
Clone/Fork das Projekt, mach deine Änderungen und erstelle einen Merge-Request. Ich würde mich sehr über Beteiligung freuen, sofern diese konstruktiv ist. Es ist mir wichtig dass der Code eine gewisse Qualität hat, damit es für Andere leicht ist, in das Projekt einzusteigen.

Für Vorschläge oder Bug-Reports bitte das Issue-System von GitLab benutzen.

## Glossar
Ein **Speiseplan** (Menu) ist eine Menge von **Gerichten** (MenuItem) für einen einzelnen Tag. Die App verwaltet also für jeden Tag einen Speiseplan.

## Todo
Folgende Features könnten unter Anderem noch umgesetzt werden. Bevor eines davon implementiert wird sollte kurz abgewogen werden, ob es die Simplizität der App verringern würde.

* Caching des Speiseplans damit die App auch offline funktioniert
* Userdefinierte Sortierung der Gerichte
* Automatisches Abfragen und Zwischenspeichern der Daten durch einen eigenen Server um den Server des Studierendenwerks nicht zu belasten
* Binäres Ratingsystem: Nutzer können auswählen, welches Gericht sie essen *werden*. Darauf aufbauend vielleicht ein paar kleine Statistiken und Erinnerungen dass ein Gericht schon mal gegessen wurde.
* Anzeige der Speisepläne für kommende Wochen, nicht nur die aktuelle