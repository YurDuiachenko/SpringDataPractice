package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Boxer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxerRepository extends JpaRepository<Boxer, Long> {

}
