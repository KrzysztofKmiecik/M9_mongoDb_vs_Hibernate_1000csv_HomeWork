package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonSqlRepository extends JpaRepository<PersonSqlDao, Long> {
}
