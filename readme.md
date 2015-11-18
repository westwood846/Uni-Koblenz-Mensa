# Uni Koblenz Mensa
Diese App soll die von den meisten Studierenden nur für ihre Speiseplan-Funktion Studierenden-Portal App ersetzen, da diese zumindest vom Design her komplett veraltet ist. Neben dem StudPo gibt es noch andere ähnliche Apps im Play Store, aber keine aktuelle, minimalistische Open Source App mit Material Design. 

Die App soll sich auf die Speiseplan-Funktion beschränken und selbst dabei minimalistisch bleiben. Ich würde gerne auf die Rating-Funktion verzichten und vor allem das blöde Akkordion loswerden, damit alle Gerichte auf einen Blick sichtbar sind. Idealer Weise muss der Nutzer mit nur einem Touch die App öffnen um den aktuellen Speiseplan einsehen zu können. 

## Dependencies
Android SDK API Level 23. Am einfachsten ist es, Android Studio zu installieren und im SDK Manager die entsprechenden Pakete auszuwählen.

## Testing
Unit-Tests wären sicherlich hilfreich :D Ich entwickle die App mit [Genymotion](https://www.genymotion.com/#!/) als Emulator, damit ich nicht mit einem echten Handy rumhampeln muss. 

## Contributing
Clone/Fork das Projekt, mach deine Änderungen und erstelle einen Merge-Request. Ich würde mich sehr über Beteiligung freuen, sofern diese konstruktiv ist. Es ist mir wichtig dass der Code eine gewisse Qualität hat, damit es für Andere leicht ist, in das Projekt einzusteigen.

Für Vorschläge oder Bug-Reports bitte das Issue-System von GitHub benutzen.

Versionsnummern sollen [Semantic Versioning](http://semver.org/) folgen. Version-Bumps sollten alleinstehende commits sein, die gleichzeitig einen entsprechenden tag haben. Die Versionsnummer muss nur erhöht werden, wenn eine Veröffentlichung vorgenommen wird.

## Glossar
Ein **Speiseplan** (Menu) ist eine Menge von **Gerichten** (MenuItem) für einen einzelnen Tag. Die App verwaltet also für jeden Tag einen Speiseplan.

## Todo
Folgende Features könnten unter Anderem noch umgesetzt werden. Bevor eines davon implementiert wird sollte kurz abgewogen werden, ob es die Simplizität der App verringern würde.

* Caching des Speiseplans damit die App auch offline funktioniert
* Userdefinierte Sortierung der Gerichte
* Automatisches Abfragen und Zwischenspeichern der Daten durch einen eigenen Server um den Server des Studierendenwerks nicht zu belasten
* Binäres Ratingsystem: Nutzer können auswählen, welches Gericht sie essen *werden*. Darauf aufbauend vielleicht ein paar kleine Statistiken und Erinnerungen dass ein Gericht schon mal gegessen wurde.
* Anzeige der Speisepläne für kommende Wochen, nicht nur die aktuelle
* Ein anständiges Launcher Icon, das nicht in 5 Minuten zusammengeklickt wurde

## Licenses
Obwohl dieses Projekt als Open Source gedacht ist verlangen manche Frameworks oder so dann man ihre Lizens oder wenigstens einen Link zu ihrer Website kenntlich macht. Bis wir dafür einen Screen in der App eingerichtet haben soll diesen Pflichten an dieser Stelle nachgekommen werden:

* MenuItem-Icons von [Icons8](https://icons8.com/)