package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application.port.CSVFileService;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
class CvsFileUseCase implements CSVFileService {

    @Value("${CvsFileUseCase.readPersonsFromCsvFile}")
    public String fileName;

    @Override
    public List<Person> readPersonsFromCsvFile() {
        List<Person> persons = null;
        try {
            persons = new CsvToBeanBuilder(new FileReader(this.fileName))
                    .withType(Person.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return persons;
    }

}
