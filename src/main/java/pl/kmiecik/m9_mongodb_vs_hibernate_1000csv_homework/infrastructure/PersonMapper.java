package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure;

import org.mapstruct.Mapper;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonSqlDao mapToPersonSqlDao(PersonDto personDto);

    PersonDto mapToPersonDto(PersonSqlDao personSqlDao);

    PersonNoSqlDao mapToPersonNoqlDao(PersonDto personDto);

    PersonDto mapToPersonDto(PersonNoSqlDao personNoSqlDao);

    Person mapToPerson(PersonDto personDto);

    PersonDto mapToPersonDto(Person person);
}
