package com.idb.example.microserviceexample.repository;

import com.idb.example.microserviceexample.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IExampleRepository extends JpaRepository<Example, Long> {
}
