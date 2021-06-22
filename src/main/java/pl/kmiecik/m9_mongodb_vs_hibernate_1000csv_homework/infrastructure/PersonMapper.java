package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure;

import org.mapstruct.Mapper;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto mapToPersonDto(Person person);

    Person mapToPerson(PersonDto personDto);
}
