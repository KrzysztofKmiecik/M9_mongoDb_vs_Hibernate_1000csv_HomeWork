package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonNoSqlRepository extends MongoRepository<PersonNoSqlDao,String>{
}
