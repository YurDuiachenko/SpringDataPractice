package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.FigureOfBoxer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FigureOfBoxerRepository extends JpaRepository<FigureOfBoxer, Long> {
}
