package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.Person;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonDto;
import pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure.PersonMapper;

@SpringBootApplication
public class M9MongoDbVsHibernate1000csvHomeWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(M9MongoDbVsHibernate1000csvHomeWorkApplication.class, args);
    }

}
