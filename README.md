# Enigma

## Setup:
- Java 17
- MacOS Ventura 13.0.1 

## Task 1: Utworzenie abstrakcji klas drzewa liściastego i iglastego
#### Projekt implementuje klase abstrakcyjną Tree z metodą grow() : void oraz metodą introduceYourself() : String oraz dwie dziedziczące podklasy z polami trunk,branches oraz roots.
#### Metoda grow() dodaje nową gałąź, zwiększa długość każdej gałęzi o 3 i ilość liści na niej o 4. Dodaje również nowy korzeń i zwiększa długość korzeni o 5. Metoda zwiększa także wysokość pnia o 2.Ponadto zaimpolementowano przebieg pór roku. Podczas zimy drzewo liściaste zrzuca wszystkie liście. 




## Task 2: Utworzenie wydajnej usługi REST, której zadaniem będzie odbieranie i zapisywanie informacji o geolokalizacji urządzeń mobilnych.
#### - Stworzona została baza danych PostgreSQL, która przechowuję dane lokalizacyjne urządzeń w formie jednej tabeli o nazwie coordinates.
#### - Tabela składa się z 3 pól: deviceId (UUID), latitude(string) i longitude(string).
#### - Została utworzona usługa REST, dająca możliwość dodawania, aktualizacji oraz pobierania lokalizacji urządzenia z bazy danych.
#### - Została zaimplementowana walidacja parametrów (latitude i longitude) poprzez użycie patternu który dopuszcza liczby od -90 do +90 dla latitude i od -180 do +180 dla longitude z sześcioma miejscami po przecinku. 
#### - Zostały dodane własne exceptiony: deviceNotFoundException i invalidCoordinatesException.
#### - Został dodany Logger Log4j2 z logowaniem w konsoli i do pliku logs.log.
#### - Został użyty swagger-ui (openAPI w .yml).
#### - Zostały dodane testy jednostkowe sprawdzające poprawne działanie endpointów.
