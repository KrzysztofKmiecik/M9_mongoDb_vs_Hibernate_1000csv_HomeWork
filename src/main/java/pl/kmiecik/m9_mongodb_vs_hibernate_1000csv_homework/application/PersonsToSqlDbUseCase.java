package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port.PersonsToSqlService;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.CuntDurationTime;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonSqlDao;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonSqlRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonsToSqlDbUseCase implements PersonsToSqlService {

    private final PersonSqlRepository personSqlRepository;

    @Autowired
    public PersonsToSqlDbUseCase(PersonSqlRepository personSqlRepository) {
        this.personSqlRepository = personSqlRepository;
    }

    @Override
    @CuntDurationTime
    public String savePersonsToSqlDb(List<Person> persons) {
        List<PersonSqlDao> personSqlDaoList = new ArrayList<>();
        for (Person person : persons) {
            personSqlDaoList.add(new PersonSqlDao(person.getId(), person.getFirst_name(), person.getLast_name(), person.getEmail(), person.getGender(), person.getIp_address()));
        }
        personSqlRepository.saveAll(personSqlDaoList);
        return "";
    }
}
