package com.example.m9_mongodb_vs_hibernate_1000csv_homework;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;
import java.io.FileReader;

@Component
public class cvsFile {


    private final PersonSqlRepository sqlRepository;
    private final PersonNoSqlRepository noSqlRepository;

    @Autowired
    public cvsFile(PersonSqlRepository sqlRepository, PersonNoSqlRepository noSqlRepository) {
        this.sqlRepository = sqlRepository;
        this.noSqlRepository = noSqlRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void readCsv() throws FileNotFoundException {

        List<Person> persons = new CsvToBeanBuilder(new FileReader("src/main/resources/static/MOCK_DATA.csv"))
                .withType(Person.class).build().parse();

       persons.forEach(System.out::println);




    }
}
