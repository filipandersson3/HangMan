# Hänga gubbe projekt

Filip Andersson 2021-02-05

## Inleding och bakgrund

Jag har gjort hänga gubbe spelet i java. Först delade jag upp det i flera steg med diagrams.net:
https://app.diagrams.net/#G1_HGgIU7KAxLBk8n7EbyglWkhqyYwcGXt 
Sen gick jag ner för listan och kunde skriva koden i ungefär samma ordning som jag hade planerat. 
Någon ändring gjorde jag som att att rita gubben alltid hände i början för att det var lättare att skriva kod för. 
Nu funkar programmet som jag vill.

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

Det gick bra att redigera text i Java för att jag använde inte String utan char array som gjorde allt 
mycket lättare. Ska fortsätta göra så när jag måste redigera text i Java.

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

Det var svårt att klura ut hur man får olika funktioner att skicka värden mellan varandra. Med vissa 
datatyper kunde jag bara sätta ett värde på variabeln och sen kunde jag automatiskt använda den 
i main men andra fungerade det annorlunda. Hur jag ska fixa det i framtiden är genom att googla innan 
jag använder en viss datatyp.

Ett annat problem jag fick var för att jag testade spelet på tio ord utan mellanrum och utan stora 
bokstäver. Det gjorde så att när jag bytte ut mot en ordlista jag hittade på internet så funkade inte 
gissningar på bokstäver som var stora och mellanrum sattes inte ut i feedbacken spelaren får. 

Stora bokstäverna fixade jag genom att bara göra om alla ord till lowercase och mellanrumen skulle jag kunnat 
fixa med att sätta första gissningen att alltid vara " ", men det större problemet är att jag inte testade 
på samma data som jag skulle använda med den färdiga produkten. Därför ska jag försöka att använda samma i 
början som vid slutet i framtiden om det går.

## Sammanfattning

I framtiden ska jag fortsätta att använda kodsnuttar från tidigare program och kanske göra en fil med dom mest 
använda. Jag ska fortsätta att använda mig av funktioner och klasser för att förbättra bland annat läsligheten. 
Jag ska också använda mig av Char arrays om jag ska redigera Strings. Planering är viktigt för att få tillräckligt 
med tid till det viktigaste och ska fortsätta med det. ASCII-art måste jag göra annorlunda genom att stänga av 
auto-mellanrum eller göra det i ett annat program. Om jag ska ta variabler in och ut ur funktioner måste jag kolla 
vilken datatyp det är för att se hur jag kan fortsätta. Jag ska också försöka att testa framtida program med input 
som är så lik (ekller bara samma) som den input jag ska använda sen som möjligt.

Om jag skulle vidareutveckla HangMan skulle jag göra så att man kan se var mellanrummen är och så att man kan justera 
svårighetsgraden. Jag skulle också göra så att om input var "" så skulle programmet inte krascha. Ett annat grafiskt 
gränssnitt skulle vara trevligt. 

Blev lite lång postmortem men fanns mycket jag fick lära mig så det är väl bra.
