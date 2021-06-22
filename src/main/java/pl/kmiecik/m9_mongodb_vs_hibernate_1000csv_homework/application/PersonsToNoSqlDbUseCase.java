package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port.PersonsToNoSqlService;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.CuntDurationTime;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonDto;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonMapper;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonNoSqlDao;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonNoSqlRepository;

import java.util.ArrayList;
import java.util.List;

@Service
class PersonsToNoSqlDbUseCase implements PersonsToNoSqlService {

    private final PersonNoSqlRepository personNoSqlRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonsToNoSqlDbUseCase(PersonNoSqlRepository personNoSqlRepository, PersonMapper personMapper) {
        this.personNoSqlRepository = personNoSqlRepository;
        this.personMapper = personMapper;
    }

    @Override
    public void deleteAllPersons() {
        personNoSqlRepository.deleteAll();
    }

    @Override
    @CuntDurationTime
    public void savePersonsToNoSqlDb(final List<PersonDto> personsDto) {
        List<PersonNoSqlDao> personNoSqlDaoList = mapperToDao(personsDto);
        personNoSqlRepository.saveAll(personNoSqlDaoList);
    }

    @Override
    @CuntDurationTime
    public List<PersonDto> readPersonsFromNoSqlDb() {
        List<PersonNoSqlDao> dataFromDb = personNoSqlRepository.findAll();
        return mapperFromDao(dataFromDb);
    }

    private List<PersonNoSqlDao> mapperToDao(final List<PersonDto> personsDto) {
        List<PersonNoSqlDao> personNoSqlDaoList = new ArrayList<>();
        for (PersonDto personDto : personsDto) {
            personNoSqlDaoList.add(personMapper.mapToPersonNoqlDao(personDto));
        }
        return personNoSqlDaoList;
    }

    private List<PersonDto> mapperFromDao(final List<PersonNoSqlDao> personsNoSqlDao) {
        List<PersonDto> personList = new ArrayList<>();
        for (PersonNoSqlDao personNoSqlDao : personsNoSqlDao) {
            personList.add(personMapper.mapToPersonDto(personNoSqlDao));
        }
        return personList;
    }

}
