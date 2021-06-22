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
class PersonsToSqlDbUseCase implements PersonsToSqlService {

    private final PersonSqlRepository personSqlRepository;

    @Autowired
    public PersonsToSqlDbUseCase(PersonSqlRepository personSqlRepository) {
        this.personSqlRepository = personSqlRepository;
    }

    @Override
    public void deleteAllPersons(){
        personSqlRepository.deleteAll();
    }

    @Override
    @CuntDurationTime
    public void savePersonsToSqlDb(final List<Person> persons) {
        List<PersonSqlDao> personSqlDaoList = mapperToDao(persons);
        personSqlRepository.saveAll(personSqlDaoList);
    }

    @Override
    @CuntDurationTime
    public List<Person> readPersonsFromSqlDb() {
        List<PersonSqlDao> dataFromDb = personSqlRepository.findAll();
        return mapperFromDao(dataFromDb);
    }

    private List<PersonSqlDao> mapperToDao(final List<Person> persons) {
        List<PersonSqlDao> personSqlDaoList = new ArrayList<>();
        for (Person person : persons) {
            personSqlDaoList.add(new PersonSqlDao(
                    person.getId(),
                    person.getFirst_name(),
                    person.getLast_name(),
                    person.getEmail(),
                    person.getGender(),
                    person.getIp_address()));
        }
        return personSqlDaoList;
    }

    private List<Person> mapperFromDao(final List<PersonSqlDao> personsSqlDao) {
        List<Person> personList = new ArrayList<>();
        for (PersonSqlDao personSqlDao : personsSqlDao) {
            personList.add(new Person(
                    personSqlDao.getIdFile(),
                    personSqlDao.getFirst_name(),
                    personSqlDao.getLast_name(),
                    personSqlDao.getEmail(),
                    personSqlDao.getGender(),
                    personSqlDao.getIp_address()));
        }
        return personList;
    }
}
