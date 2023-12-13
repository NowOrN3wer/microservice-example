package com.idb.example.microserviceexample.repository;

import com.idb.example.microserviceexample.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISampleRepository extends JpaRepository<Sample, Long> {
}
