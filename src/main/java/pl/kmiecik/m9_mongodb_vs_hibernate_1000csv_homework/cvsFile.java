package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
    public void Start() throws FileNotFoundException {

        List<Person> persons = readPersonsFromCsvFile();
        sayHello();
        savePersonsToSqlDb(persons);
        //  savePersonsToNoSqlDb(persons);
    }

    @CuntDurationTime
    public void sayHello() {
        System.out.println("Hello");
    }


    private List<Person> readPersonsFromCsvFile() throws FileNotFoundException {
        List<Person> persons = new CsvToBeanBuilder(new FileReader("src/main/resources/static/MOCK_DATA.csv"))
                .withType(Person.class).build().parse();
        // persons.forEach(System.out::println);
        return persons;
    }


    private String savePersonsToSqlDb(List<Person> persons) {
        List<PersonSqlDao> personSqlDaoList = new ArrayList<>();
        for (Person person : persons) {
            personSqlDaoList.add(new PersonSqlDao(person.getId(), person.getFirst_name(), person.getLast_name(), person.getEmail(), person.getGender(), person.getIp_address()));
        }
        sqlRepository.saveAll(personSqlDaoList);
        return "";
    }
   /* @CuntDurationTime
    private void savePersonsToNoSqlDb(List<Person> persons) {
        List<PersonNoSqlDao> personNoSqlDaoList = new ArrayList<>();
        for (Person person : persons) {
            personNoSqlDaoList.add(new PersonNoSqlDao(person.getId(), person.getFirst_name(), person.getLast_name(), person.getEmail(), person.getGender(), person.getIp_address()));
        }
        noSqlRepository.saveAll(personNoSqlDaoList);

    }*/
}
