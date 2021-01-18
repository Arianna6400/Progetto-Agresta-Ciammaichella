# OPENWEATHER-UV Data
Il progetto sviluppato dai due contribuenti (Arianna Agresta e Marco Ciammaichella) è relativo all'esame di Programmazione ad Oggetti, A.A. 2020/21.

Arianna Agresta 50%
Marco Ciammaichella 50%

##  Il Web Service
Il Web Service da noi implementato permette all'utente di scaricare i dati dei raggi UV di diverse città italiane, in funzione delle loro coordinate geografiche, utilizzando l'API [UV Index](https://openweathermap.org/api/uvi#geo)  di OpenWeather . Inoltre, è possibile scaricare, salvare e visualizzare i dati ogni ora. Oltretutto, il servizio genera delle statistiche di massimo, minimo, media e varianza, relative ai dati UV di ogni singola città (o dell'intero dataset). Queste statistiche sono visualizzabili in diversi range: giornaliero, settimanale, mensile, ed in un range personalizzabile dall'utente (ad esempio 10 giorni). 

Il nostro servizio Web permette di richiedere tramite API REST (GET o POST) con diverse rotte:
 - restituzione dei METADATA, cioè l'elenco degli attributi descritti per nome, campo di ricerca e tipo, in formato JSON;
 - restituzione dei DATA, ovvero l'intero dataset, in formato JSON;
 - restituzione dei DATA filtrati, cioè il dataset con i filtri applicati, in formato JSON;
 - restituzione delle STATS, cioè le statistiche generate dal programma sul dataset, in formato JSON;
 - restituzione delle STATS filtrate, cioè le statistiche filtrate generate dal programma sul dataset, in formato JSON.
 
 Questo semplice diagramma descrive l'interazione dell'utente con le rotte:
 ![](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/UseCaseDiagrams/UseCase(Metadata,%20Data,%20Stats).png?raw=true)

## Funzionamento interno del Web Service

 Il funzionamento interno del Web Service si può riassumere in questo modo:
 ![](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/UseCaseDiagrams/UseCaseInterno.png?raw=true)

 L'utente ha quindi la possibilità di selezionare autonomamente, partendo da un dataset predefinito, il percorso da effettuare all'interno del Servizio Web.
 Innanzitutto, per utilizzare il nostro Servizio Web, è necessario clonare questa Repository nel proprio IDE e "runnare" il progetto con "SpringBoot App". In questo modo l'applicazione Web sarà attiva sulla porta http://localhost:8080.
 Da questo momento, sarà possibile utilizzare un API testing, per esempio Postman, per eseguire le rotte GET o POST. 
 La seguente tabella mostra le chiamate disponibili all'utente da effettuare sull'API testing:
 
|TIPO | ROTTA    |    DESCRIZIONE                |
|----------------|-------------------------------|-
| GET |  /metadata| restituisce l’elenco degli attributi descritti per nome, campo di ricerca e tipo, in formato JSON
| GET |  /data | restituisce l'intero dataset, in formato JSON
| GET |  /stats| restituisce le statistiche generate dal programma sul dataset, in formato JSON
| POST |  /data|  restituisce il dataset con i filtri applicati, in formato JSON
| POST |  /stats| restitisce le statistiche filtrate generate dal programma sul dataset, in formato JSON

##  Filtri nelle chiamate POST

**POST/data**

La seguente tabella mostra i filtri applicabili dall'utente nella chiamata POST/data:

|FILTRO| DESCRIZIONE | 
|--|--|
| Cities |  l'utente può specificare una o più città per ottenere un Dataset filtrato esclusivamente per i luoghi inseriti|
| Range | l'utente può specificare, inserendo due interi, inizio e fine di un periodo di tempo (in giorni) a partire dall'ultima data presente nel Dataset |
| Value | l'utente può inserire un filtraggio specifico dei valori dei raggi UV presenti nel Dataset scegliendo tra questi: *Greater*, *Less*, *Included*, *NotIncluded* (vedi tabella del filtraggio di valori e statistiche)
  |
 Un esempio del funzionamento del filtraggio applicabile può essere:
  

` {"Cities":["Pescara","Rome","Venice"], "Range":[0,7],"Value":{"NotIncluded":  [1.1,1.2]} }  `

In questo caso, l'utente ottiene in formato JSON un vettore di dati per le città inserite (Pescara, Roma, Venezia), in un range temporale che parte dall'ultimo dato presente sul Dataset fino a sette giorni prima e il cui valore non è incluso tra 1.1 e 1.2. Se, ad esempio, l'utente inserisse
` "Range":[3,5]`,  i dati restituiti sarebbero compresi in un range temporale che parte da tre giorni prima dell'ultima data presente nel Dataset fino a cinque giorni prima.

**NOTA BENE**: 

 - Non è necessario inserire tutti i tipi di filtraggio, infatti l'utente può utilizzarne uno, due o tre contemporaneamente. In quel caso si otterrebbero solamente i dati relativi al filtraggio desiderato.
 - All'interno del programma è stato inserito un controllo riguardante l'uso delle lettere maiuscole e minuscole, rendendo il servizio "non case-sensitive". Ad esempio, se l'utente inserisse "cities" al posto di "Cities", il programma funzionerebbe correttamente poiché sostituisce automaticamente il nome del filtro sbagliato con quello corretto. [Vedi all'interno del programma.](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/ProgettoOOP/src/main/java/com/example/ProgettoOOP/util/DataParser.java) 

**POST/stats**

La seguente tabella mostra i filtri applicabili dall’utente nella chiamata POST/stats:

| FILTRO | DESCRIZIONE |
|--|--|
| Cities | l'utente può specificare una o più città per ottenere statistiche relative esclusivamente ai luoghi inseriti |
| Range | l'utente può inserire un intero che rappresenta il numero di giorni su cui vengono calcolate le statistiche. Il programma restituisce statistiche fino all'esaurimento di dati nel Dataset |
| Max | l'utente può ottenere il filtraggio dei valori di *Massimo* dei raggi UV presenti nel Dataset scegliendo tra: *Greater*, *Less*, *Included*, *NotIncluded* (vedi tabella del filtraggio di valori e statistiche)   |
| Min | l'utente può ottenere il filtraggio dei valori di *Minimo* dei raggi UV presenti nel Dataset scegliendo tra: *Greater*, *Less*, *Included*, *NotIncluded* (vedi tabella del filtraggio di valori e statistiche) |
| Avg | l'utente può ottenere il filtraggio della *Media* dei raggi UV presenti nel Dataset scegliendo tra: *Greater*, *Less*, *Included*, *NotIncluded* (vedi tabella del filtraggio di valori e statistiche) |
| Var | l'utente può ottenere il filtraggio della *Varianza* dei raggi UV presenti nel Dataset scegliendo tra: *Greater*, *Less*, *Included*, *NotIncluded* (vedi tabella del filtraggio di valori e statistiche) |

Un esempio del funzionamento del filtraggio applicabile può essere:

` {"Cities":["Pescara","Ancona"], "Range": 7,"Min":{"Greater": 0.8} }  `

In questo caso, l'utente ottiene in formato JSON un vettore di statistiche per le città inserite (Pescara, Ancona), con un range settimanale, il cui valore "minimo" è superiore a 0.8. Se l'utente inserisse ad esempio  ` "Range": 10 ` , otterrebbe le statistiche del Dataset filtrate a intervalli di dieci giorni. 

**NOTA BENE**: 

 - Non è necessario inserire tutti i tipi di filtraggio, infatti l'utente può utilizzarne uno, due o tre contemporaneamente. In quel caso si otterrebbero solamente le statistiche relative al filtraggio desiderato.
 - All'interno del programma è stato inserito un controllo riguardante l'uso delle lettere maiuscole e minuscole, rendendo il servizio "non case-sensitive". Ad esempio, se l'utente inserisse "max" al posto di "Max", il programma funzionerebbe correttamente poiché sostituisce automaticamente il nome del filtro sbagliato con quello corretto. [Vedi all'interno del programma.](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/ProgettoOOP/src/main/java/com/example/ProgettoOOP/util/StatsParser.java) 

**Filtraggio di valori e statistiche**