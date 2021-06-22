package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port.CSVFileService;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port.PersonsToNoSqlService;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port.PersonsToSqlService;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;

import java.io.FileNotFoundException;
import java.util.List;

@Component
public class Init {


    private final CSVFileService csvFileService;
    private final PersonsToSqlService personsToSqlService;
    private final PersonsToNoSqlService personsToNoSqlService;

    @Autowired
    public Init(CSVFileService csvFileService, PersonsToSqlService personsToSqlService, PersonsToNoSqlService personsToNoSqlService) {
        this.csvFileService = csvFileService;
        this.personsToSqlService = personsToSqlService;
        this.personsToNoSqlService = personsToNoSqlService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void Start() throws FileNotFoundException {

        List<Person> persons = csvFileService.readPersonsFromCsvFile();
        personsToSqlService.savePersonsToSqlDb(persons);
        personsToNoSqlService.savePersonsToNoSqlDb(persons);

      personsToSqlService.readPersonsFromSqlDb();
      personsToNoSqlService.readPersonsFromNoSqlDb();
    }
}
