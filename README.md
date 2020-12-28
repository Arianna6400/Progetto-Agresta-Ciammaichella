# OPENWEATHER-UV Data
Il progetto sviluppato dai due contribuenti (Arianna Agresta e Marco Ciammaichella) è relativo all'esame di Programmazione ad Oggetti, A.A. 2020/21.
##  Il Web Service
Il Web Service da noi implementato permette all'utente di scaricare i dati dei raggi UV di diverse città italiane, in funzione delle loro coordinate geografiche, utilizzando l'API [UV Index](https://openweathermap.org/api/uvi#geo)  di OpenWeather . Inoltre, è possibile scaricare, salvare e visualizzare i dati ogni ora. Oltretutto, il servizio genera delle statistiche di massimo, minimo, media e varianza, relative ai dati UV di ogni singola città (o dell'intero dataset). Queste statistiche sono visualizzabili in diversi range: giornaliero, settimanale, mensile, ed in un range personalizzabile dall'utente(ad esempio 10 giorni). 

Il nostro servizio Web permette di richiedere tramite API REST (GET o POST) con diverse rotte:
 - restituzione dei METADATA, cioè l'elenco degli attributi descritti per nome, campo di ricerca e tipo, in formato JSON;
 - restituzione dei DATA, ovvero l'intero dataset, in formato JSON;
 - restituzione dei DATA filtrati, cioè il dataset con i filtri applicati, in formato JSON;
 - restituzione delle STATS, cioè le statistiche generate dal programma sul dataset, in formato JSON;
 - restituzione delle STATS filtrate, cioè le statistiche filtrate generate dal programma sul dataset, in formato JSON.
 
 Questo semplice diagramma descrive il funzionamento delle rotte:
 ![](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UseCase(Metadata,%20Data,%20Stats).png?raw=true)

## Funzionamento interno del Web Service

 Il funzionamento interno del Web service si può riassumere in questo modo:
 ![](https://github.com/Arianna6400/Progetto-Agresta-Ciammaichella/blob/master/UseCaseInterno.png?raw=true)
 L'utente ha quindi la possibilità di selezionare autonomamente, partendo da un dataset predefinito, il percorso da effettuare all'interno del Servizio Web.
 Innanzitutto, per utilizzare il nostro Servizio Web, è necessario clonare questa Repository nel proprio IDE e "runnare" il progetto con "SpringBoot App". In questo modo l'applicazione Web sarà attiva sulla porta http://localhost:8080.
 Da questo momento, sarà possibile utilizzare un API testing, per esempio Postman, per eseguire le rotte GET o POST. 

