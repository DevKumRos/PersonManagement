package com.ebl.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebl.entity.Person;
@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {

}
