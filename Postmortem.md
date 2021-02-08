# Hänga gubbe projekt

Filip Andersson 2021-02-05

## Inledning

Här beskriver du kortfattat arbetets syfte/mål, arbetssätt, genomförande.

## Bakgrund

Jag har gjort hänga gubbe spelet i java som jag först delade upp i flera steg med diagrams.net:
https://app.diagrams.net/#G1_HGgIU7KAxLBk8n7EbyglWkhqyYwcGXt 
Sen gick jag ner för listan och kunde skriva koden i ungefär samma ordning som jag hade planerat. 
Någon ändring gjorde jag som att att rita gubben alltid hände i början för att det var lättare att skriva kod för. 
Nu funkar programmet som jag vill.

```
![GitHub Logo](/images/logo.png)
Format: ![Alt Text](url)
```

![NTI Gymnasiet Umeå Logo](nti_logo_white_umea.svg)

## Positiva erfarenheter

Det gick bra att skriva en random ord generator för att jag har använt mig av inläsning från filer 
innan och vet hur det funkar och så länge jag inte glömmer det så borde det vara lugnt.
Läsa input hade jag också gjort tidigare och kunde då bara kopiera koden från innan så det 
var bra att jag hade ett tidigare exempel av hur det funkar så att jag kunde använda det. Det kan 
jag fortsätta med genom att göra exempel av vanligt använda funktioner 
(t.ex. att göra arrays till strings på mitt sätt).

Det går bra att läsa koden för att jag har använt mig av funktioner (och en class för hangmandrawings) 
så att koden är uppdelad i lagomt stora bitar. Classen jag gjorde för hangmandrawings stoppade jag i 
en annan fil så att man skiljer på kod och ASCII-art. 

Det gick bra att planera så att jag fick tid att bli klar också. Jag tänkte på vad som skulle behöva 
göras för att få alla funktioner att fungera och hur lång tid det skulle ta och därför kunde jag fixa 
så att random orden kunde läsas från en fil och såg till att jag hade en lektion kvar för att debugga 
och strukturera koden. Jag ska fortsätta planera så i framtiden.

## Negativa erfarenheter

Det som jag tyckte var det jobbigaste var att lägga in ASCII-art i koden för att IntelliJ lägger 
automatiskt till mellanrum som gör att man inte kan se vad man ritar om man inte tar bort alla manuellt.
Om jag kommer göra ASCII-art i IntelliJ i framtiden så kommer jag leta om det finns något sätt att 
stänga av auto-mellanrum eller så kanske det finns något program på internet som kan göra ASCII-art 
lättare.

Ett annat problem jag fick var för att jag testade spelet på tio ord utan mellanrum och utan stora 
bokstäver. Det gjorde så att när jag bytte ut mot en ordlista jag hittade på internet så funkade inte 
gissningar på bokstäver som var stora och mellanrum sattes inte ut i feedbacken spelaren får. 

Stora bokstäverna fixade jag genom att bara göra om alla ord till lowercase och mellanrumen skulle jag kunnat 
fixa med att sätta första gissningen att alltid vara " ", men det större problemet är att jag inte testade 
på samma data som jag skulle använda med den färdiga produkten. Därför ska jag försöka att använda samma i 
början som vid slutet i framtiden om det går.

## Sammanfattning

Här redovisar du dina slutsatser, erfarenheter och lärdomar. Reflektera över din produkt och dess/dina utvecklingsmöjligheter.
Vad kan vidareutvecklas och finns det utrymme att bygga vidare på projektet.
