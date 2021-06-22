package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port.PersonsToNoSqlService;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.CuntDurationTime;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonNoSqlDao;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonNoSqlRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonsToNoSqlDbUseCase implements PersonsToNoSqlService {

    private final PersonNoSqlRepository personNoSqlRepository;

    @Autowired
    public PersonsToNoSqlDbUseCase(PersonNoSqlRepository personNoSqlRepository) {
        this.personNoSqlRepository = personNoSqlRepository;
    }

    @Override
    @CuntDurationTime
    public void savePersonsToNoSqlDb(List<Person> persons) {
        List<PersonNoSqlDao> personNoSqlDaoList = new ArrayList<>();
        for (Person person : persons) {
            personNoSqlDaoList.add(new PersonNoSqlDao(person.getId(), person.getFirst_name(), person.getLast_name(), person.getEmail(), person.getGender(), person.getIp_address()));
        }
        personNoSqlRepository.saveAll(personNoSqlDaoList);
    }
}
