package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port.CSVFileService;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonDto;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
class CvsFileUseCase implements CSVFileService {


    private final PersonMapper personMapper;

    @Autowired
    public CvsFileUseCase(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @Value("${CvsFileUseCase.readPersonsFromCsvFile}")
    public String fileName;

    @Override
    public List<PersonDto> readPersonsFromCsvFile() {
        List<Person> persons = null;
        try {
            persons = new CsvToBeanBuilder(new FileReader(this.fileName))
                    .withType(Person.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return persons.stream().map(person -> personMapper.mapToPersonDto(person))
                .collect(Collectors.toList());
    }

}
