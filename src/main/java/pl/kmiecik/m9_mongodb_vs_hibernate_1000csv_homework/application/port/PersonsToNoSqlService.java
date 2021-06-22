package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port;

import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;

import java.util.List;

public interface PersonsToNoSqlService {

    void savePersonsToNoSqlDb(List<Person> persons);
}
