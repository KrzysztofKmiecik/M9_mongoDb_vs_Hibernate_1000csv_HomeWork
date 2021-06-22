package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port.PersonsToSqlService;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.CuntDurationTime;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonDto;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonMapper;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonSqlDao;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonSqlRepository;

import java.util.ArrayList;
import java.util.List;

@Service
class PersonsToSqlDbUseCase implements PersonsToSqlService {

    private final PersonSqlRepository personSqlRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonsToSqlDbUseCase(PersonSqlRepository personSqlRepository, PersonMapper personMapper) {
        this.personSqlRepository = personSqlRepository;
        this.personMapper = personMapper;
    }

    @Override
    public void deleteAllPersons() {
        personSqlRepository.deleteAll();
    }

    @Override
    @CuntDurationTime
    public void savePersonsToSqlDb(final List<PersonDto> personsDto) {
        List<PersonSqlDao> personSqlDaoList = mapperToDao(personsDto);
        personSqlRepository.saveAll(personSqlDaoList);
    }

    @Override
    @CuntDurationTime
    public List<PersonDto> readPersonsFromSqlDb() {
        List<PersonSqlDao> dataFromDb = personSqlRepository.findAll();
        return mapperFromDao(dataFromDb);
    }

    private List<PersonSqlDao> mapperToDao(final List<PersonDto> personsDto) {
        List<PersonSqlDao> personSqlDaoList = new ArrayList<>();
        for (PersonDto personDto : personsDto) {
            personSqlDaoList.add(personMapper.mapToPersonSqlDao(personDto));
        }
        return personSqlDaoList;
    }

    private List<PersonDto> mapperFromDao(final List<PersonSqlDao> personsSqlDao) {
        List<PersonDto> personList = new ArrayList<>();
        for (PersonSqlDao personSqlDao : personsSqlDao) {
            personList.add(personMapper.mapToPersonDto(personSqlDao));
        }
        return personList;
    }
}
