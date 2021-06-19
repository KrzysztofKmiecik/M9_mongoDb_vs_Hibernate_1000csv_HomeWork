package com.example.m9_mongodb_vs_hibernate_1000csv_homework;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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

        List<PersonSqlDao> personSqlDaoList = new ArrayList<>();
        List<PersonNoSqlDao> personNoSqlDaoList = new ArrayList<>();


        for (Person person : persons) {
            personSqlDaoList.add(new PersonSqlDao(person.getId(), person.getFirst_name(), person.getLast_name(), person.getEmail(), person.getGender(), person.getIp_address()));
            personNoSqlDaoList.add(new PersonNoSqlDao(person.getId(), person.getFirst_name(), person.getLast_name(), person.getEmail(), person.getGender(), person.getIp_address()));
        }

        long startSql = System.currentTimeMillis();
        sqlRepository.saveAll(personSqlDaoList);
        long stopSql = System.currentTimeMillis();
        long sqlTime=stopSql-startSql;
        System.out.println("SQL time= " + sqlTime);


        long startNoSql = System.currentTimeMillis();
        noSqlRepository.saveAll(personNoSqlDaoList);
        long stopNoSql = System.currentTimeMillis();
        long noSqlTime=stopNoSql-startNoSql;
        System.out.println("NoSQL time= " + noSqlTime);
        double howMuchNoSqlIsFasetThenSql = sqlTime / noSqlTime * 1.0;
        System.out.println("NoSql jest "+howMuchNoSqlIsFasetThenSql +" razy szybsza");



    }
}
