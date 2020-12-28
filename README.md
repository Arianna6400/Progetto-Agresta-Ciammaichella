# OPENWEATHER-UV Data
Il progetto sviluppato dai due contribuenti (Arianna Agresta e Marco Ciammaichella) è relativo all'esame di Programmazione ad Oggetti, A.A. 2020/21.
##  Il Web Service
E' possibile definire un Web Service come un sistema software in grado di mettersi al servizio di un applicazione comunicando su di una medesima rete tramite il protocollo HTTP, consentendo quindi alle applicazioni che vi si collegano, cioè al servizio di un Client, di usufruire delle funzioni che mette a disposizione. Attraverso SpringBoot è possibile creare un software che avvia l'intera applicazione web. 
Il Web Service da noi implementato permette all'utente di scaricare i dati dei raggi UV di diverse città italiane, in funzione delle loro coordinate geografiche, utilizzando l'API [UV Index](https://openweathermap.org/api/uvi#geo)  di OpenWeather . Inoltre, è possibile scaricare, salvare e visualizzare i dati ogni ora. Oltretutto, il servizio genera delle statistiche di massimo, minimo, media e varianza, relative ai dati UV di ogni singola città. Queste statistiche sono visualizzabili in diversi range: giornaliero, settimanale, mensile, ed in un range personalizzabile dall'utente(ad esempio 10 giorni). 
La nostra applicazione permette di richiedere tramite API REST(GET o POST) con diverse rotte:
 - restituzione dei METADATA, cioè l'elenco degli attributi descritti per nome, campo di ricerca e tipo, in formato JSON;
 - restituzione dei DATA, ovvero l'intero dataset, in formato JSON;
 - restituzione dei DATA filtrati, cioè il dataset con i filtri applicati, in formato JSON;
 - restituzione delle STATS, cioè le statistiche generate dal programma sul dataset, in formato JSON;
 - restituzione delle STATS filtrate, cioè le statistiche filtrate generate dal programma sul dataset, in formato JSON.

