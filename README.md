# OPENWEATHER-UV Data
Il progetto sviluppato dai due contribuenti (Arianna Agresta e Marco Ciammaichella) è relativo all'esame di Programmazione ad Oggetti, A.A. 2020/21.

Arianna Agresta 50%
Marco Ciammaichella 50%

##  Il Web Service
Il Web Service da noi implementato permette all'utente di scaricare i dati dei raggi UV di diverse città italiane, in funzione delle loro coordinate geografiche (latitudine e longitudine), utilizzando l'API [UV Index](https://openweathermap.org/api/uvi#geo)  di OpenWeather . Inoltre, è possibile scaricare, salvare e visualizzare i dati ogni ora. Oltretutto, il servizio genera delle statistiche di massimo, minimo, media e varianza, relative ai dati UV di ogni singola città (o dell'intero dataset). Queste statistiche sono visualizzabili in diversi range: giornaliero, settimanale, mensile, ed in un range personalizzabile dall'utente (ad esempio 10 giorni). 

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
 Innanzitutto, per utilizzare il programma, è necessario clonare questa Repository nel proprio IDE e "runnare" il progetto con "SpringBoot App". In questo modo l'applicazione Web sarà attiva sulla porta http://localhost:8080.
 Da questo momento, sarà possibile utilizzare un API testing, per esempio Postman, per eseguire le rotte GET o POST. 
 La seguente tabella mostra le chiamate disponibili all'utente da effettuare sull'API testing:
 
|TIPO | ROTTA    |    DESCRIZIONE                |
|----------------|-------------------------------|-
| GET |  /metadata| restituisce l’elenco degli attributi descritti per nome, campo di ricerca e tipo, in formato JSON
| GET |  /data | restituisce l'intero dataset, in formato JSON
| GET |  /stats| restituisce le statistiche generate dal programma sul dataset, in formato JSON
| POST |  /data|  restituisce il dataset con i filtri applicati, in formato JSON
| POST |  /stats| restitisce le statistiche filtrate generate dal programma sul dataset, in formato JSON

A scopo illustrativo, per testare il funzionamento del Servizio WEB, è stato inserito un file di testo in formato JSON contenente nome, latitudine e longitudine di alcune città italiane, chiamato [Città.json](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/ProgettoOOP/CityUVFile/Citt%C3%A0.json) ed un Dataset in formato JSON predefinito con dati scaricati giornalmente in un dato periodo di tempo (dal 05/01/2021 al 19/01/2021), chiamato [Uv.json](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/ProgettoOOP/CityUVFile/Uv.json).  L'utente è libero di modificare entrambi i file in modo tale da poter utilizzare il Servizio WEB con le città che più preferisce.

##  Filtri nelle chiamate POST

**POST/data**

La seguente tabella mostra i filtri applicabili dall'utente nella chiamata POST/data:

|FILTRO| DESCRIZIONE | 
|--|--|
| Cities |  l'utente può specificare una o più città per ottenere un Dataset filtrato esclusivamente per i luoghi inseriti|
| Range | l'utente può specificare, inserendo due interi, inizio e fine di un periodo di tempo (in giorni) a partire dall'ultima data presente nel Dataset |
| Value | l'utente può inserire un filtraggio specifico dei valori dei raggi UV presenti nel Dataset scegliendo tra questi: *Greater*, *Less*, *Included*, *NotIncluded* (<a href="https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella#filtraggio-di-valori-e-statistiche">vedi tabella del filtraggio di valori e statistiche</a>)
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
| Max | l'utente può ottenere il filtraggio dei valori di *Massimo* dei raggi UV presenti nel Dataset scegliendo tra: *Greater*, *Less*, *Included*, *NotIncluded* (<a href="https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella#filtraggio-di-valori-e-statistiche">vedi tabella del filtraggio di valori e statistiche</a>)   |
| Min | l'utente può ottenere il filtraggio dei valori di *Minimo* dei raggi UV presenti nel Dataset scegliendo tra: *Greater*, *Less*, *Included*, *NotIncluded* (<a href="https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella#filtraggio-di-valori-e-statistiche">vedi tabella del filtraggio di valori e statistiche</a>) |
| Avg | l'utente può ottenere il filtraggio della *Media* dei raggi UV presenti nel Dataset scegliendo tra: *Greater*, *Less*, *Included*, *NotIncluded* (<a href="https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella#filtraggio-di-valori-e-statistiche">vedi tabella del filtraggio di valori e statistiche</a>) |
| Var | l'utente può ottenere il filtraggio della *Varianza* dei raggi UV presenti nel Dataset scegliendo tra: *Greater*, *Less*, *Included*, *NotIncluded* (<a href="https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella#filtraggio-di-valori-e-statistiche">vedi tabella del filtraggio di valori e statistiche</a>) |

Un esempio del funzionamento del filtraggio applicabile può essere:

` {"Cities":["Pescara","Ancona"], "Range": 7,"Min":{"Greater": 0.8} }  `

In questo caso, l'utente ottiene in formato JSON un vettore di statistiche per le città inserite (Pescara, Ancona), con un range settimanale, il cui valore "minimo" è superiore a 0.8. Se l'utente inserisse ad esempio  ` "Range": 10 ` , otterrebbe le statistiche del Dataset filtrato a intervalli di dieci giorni.  

**NOTA BENE**: 

 - Non è necessario inserire tutti i tipi di filtraggio, infatti l'utente può utilizzarne uno, due o tre contemporaneamente. In quel caso si otterrebbero solamente le statistiche relative al filtraggio desiderato.
 - All'interno del programma è stato inserito un controllo riguardante l'uso delle lettere maiuscole e minuscole, rendendo il servizio "non case-sensitive". Ad esempio, se l'utente inserisse "max" al posto di "Max", il programma funzionerebbe correttamente poiché sostituisce automaticamente il nome del filtro sbagliato con quello corretto. [Vedi all'interno del programma.](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/ProgettoOOP/src/main/java/com/example/ProgettoOOP/util/StatsParser.java) 

## Filtraggio di valori e statistiche

E' necessaria una sezione specifica per spiegare l'utilizzo dei filtri *Greater*, *Less*, *Included*, *NotIncluded*, i quali possono essere inseriti nel body delle chiamate POST (data o stats). Nel dettaglio:
|FILTRO| DESCRIZIONE |
|--|--|
| Greater | l'utente può inserire **un** valore double per il filtraggio "maggiore di" |
| Less | l'utente può inserire **un** valore double per il filtraggio "minore di" |
| Included |  l'utente può inserire **due** valori double, in ordine crescente, per il filtraggio "incluso tra"|
| NotIncluded | l'utente può inserire **due** valori double, in ordine crescente, per il filtraggio "non incluso tra" |

**NOTA:** I filtri *Greater* e *Less* necessitano l'input di un solo valore double, mentre *Included* e *NotIncluded* di due valori double, altrimenti il programma lancia un'eccezione.

## Struttura del Web Service

**Packages**

Questo diagramma UML mostra il corpo del programma, suddiviso nei vari package di riferimento.

![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/Packages/ClassDiagram.png?raw=true)

 - **com.example.ProgettoOOP.Types**
 
 In questo package sono contenute le classi di modellazione dei tipi utilizzati.
 
![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/Packages/Types.png?raw=true)
 
 - **com.example.ProgettoOOP.owapi**
 
Il seguente package contiene le classi di collegamento alle API di OpenWeather.
 
![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/Packages/owapi.png?raw=true)
 - **com.example.ProgettoOOP.Rate**

In questo package sono presenti le classi utilizzate per il calcolo delle statistiche.

![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/Packages/Rate.png?raw=true)

 - **com.example.ProgettoOOP.Filters**
 
 Questo package contiene le classi di modellazione dei filtri applicabili.

![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/Packages/Filters.png?raw=true)

 - **com.example.ProgettoOOP.util**

Il seguente package contiene le classi addette all'intero funzionamento del programma.

![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/Packages/util.png?raw=true)

## Funzionamento del Controller

I seguenti diagrammi UML delle sequenze descrivono le chiamate gestite dal Controller.

 - **GET/metadata**: il Controller esegue una chiamata alla classe ` DataBase` per mezzo del metodo `getMetaData()`, che restituisce un tipo ` String`.

![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/SequenceDiagrams/GETmetadata.png?raw=true)

 - **GET/data**:  il Controller effettua una chiamata alla classe ` DataBase`  per mezzo del metodo `getUVData()` , la quale a sua volta esegue una chiamata alla classe `Reader`  con il metodo `getVectorUV()` . Quest'ultima classe restituisce un `Vector<UVData>`  alla classe ` DataBase` , che a sua volta fa ritornare al Controller un tipo `String` .
 
![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/SequenceDiagrams/GETdata.png?raw=true)
 
 
 - **GET/stats**:  il Controller esegue una chiamata alla classe `Reader` con il metodo `getVectorUV()`, che restituisce un `Vector<UVData>`.  In seguito, il Controller chiama la classe `Calculator` per mezzo del metodo `ListParser()`, che ritorna un `Vector<String>`. A questo punto, il Controller effettua una chiamata alla classe `DataCity` con il metodo `getResult()`, che restituisce un tipo `String`.
 
![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/SequenceDiagrams/GETstats.png?raw=true)
 
 - **POST/data**:  il Controller esegue una chiamata alla classe `DataParser` con il metodo `getBody()`, la quale a sua volta effettua una chiamata alla classe `Reader`, che le restituisce un `Vector<UVData>`. A questo punto `DataParser` esegue le chiamate alle classi di filtraggio `CitiesFilter`, `RangeFilter` e `ValueFilter`, che restituiscono dei `Vector<UVData>`. Terminate le chiamate ai filtri, la classe `DataParser` restituisce un tipo `String` al Controller.
 
![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/SequenceDiagrams/POSTdata.png?raw=true)
 
 - **POST/stats**:   il Controller esegue una chiamata alla classe `StatsParser` con il metodo `getBody()`, la quale a sua volta effettua una chiamata alla classe `Reader`, che le restituisce un `Vector<UVData>`.  A questo punto la classe `StatsParser` esegue una chiamata alla classe `CitiesFilter`  con il metodo `getCityFilter()` che le restituisce un `Vector<UVData>`, e una chiamata alla classe `Calculator`, attraverso il metodo `ListParser()`, che le restituisce un `Vector<String>`. Ora, la classe `StatsParser` effettua le chiamate alle classi di filtraggio `MaxFilter`, `MinFilter`, `AvgFilter` e `VarFilter`, che restituiscono un `Vector<Result>`. Alla fine, la classe `StatsParser` restituisce un tipo `String` al Controller.
 
 ![enter image description here](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UMLDiagrams/SequenceDiagrams/POSTstats.png?raw=true)

## Software utilizzati

 - [Eclipse](https://www.eclipse.org/) : IDE per lo sviluppo dell'applicativo in Java;
 - [SpringBoot](https://spring.io/projects/spring-boot): framework per lo sviluppo delle applicazioni;
 - [Maven](https://maven.apache.org/): strumento di gestione delle dipendenze;
 - [JUnit5](https://junit.org/junit5/) : framework per lo unit testing;
 - [StackEdit](https://stackedit.io/app#) : strumento di sviluppo e stesura del README;
 - [JavaDoc](https://www.oracle.com/it/technical-resources/articles/java/javadoc-tool.html) : per la generazione della documentazione JavaDoc all'interno del programma.
 - [StarUML](https://staruml.io/): applicazione di sviluppo per la modellazione in UML;
 - [Postman](https://www.postman.com/) : per l'API testing.

