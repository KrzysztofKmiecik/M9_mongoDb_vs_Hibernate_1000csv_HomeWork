# M9_mongoDb vs Hibernate 1000 csv HomeWork

-[x] Wczytaj do aplikacji 1000 obiektów pobranych z https://www.mockaroo.com/ (z formatu CSV)
-[x] Stwórz metodę, która będzie zapisywała wszystkie elementy do lokalnej bazy danych
-[x] Stwórz aspekt, który będzie nasłuchiwać metodę i w momencie startu włączy licznik startu, a po zakończeniu operacji odczytanie zostanie czas wykonania operacji
-[x] Zrób do samo dla operacji wczytywania danych z bazy danych (bez wyświetlania ich, bo to może spowodować przekłamanie wyniku), Odnotuj wynik odczytu
-[x] Zrealizuj to dla relacyjnej bazy danych i nierelacyjnej bazy danych
-[x] Porównaj wyniki, napisz wnioski, podziel się nimi na grupie – zobaczymy komu co udało się osiągnąć ?

## Results:
MySQL_H2 (mem local)
- DurationTime of method savePersonsToSqlDb is equal = 188 ms
- DurationTime of method readPersonsFromSqlDb is equal = 24 ms

MySQl_Workbench (local)
- DurationTime of method savePersonsToSqlDb is equal = 484 ms
- DurationTime of method readPersonsFromSqlDb is equal = 27 ms

NoSQL_mongoDB (local)
- DurationTime of method savePersonsToNoSqlDb is equal = 94 ms
- DurationTime of method readPersonsFromNoSqlDb is equal = 51 ms

## Conclusions
Writing:
NoSQL is 2 times faster then MySQL_H2  and 5 times  faster then  MySql_Workbench

Reading:
NoSQL is 2 times slower then MySQL_H2 and MySql_Workbench

Repeatibility:
NoSQL durationTime measurements are more stable.
