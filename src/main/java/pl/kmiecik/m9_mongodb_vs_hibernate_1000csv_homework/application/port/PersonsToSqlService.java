package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port;

import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonDto;

import java.util.List;

public interface PersonsToSqlService {
    void deleteAllPersons();

    void savePersonsToSqlDb(List<PersonDto> persons);

    List<PersonDto> readPersonsFromSqlDb();
}
