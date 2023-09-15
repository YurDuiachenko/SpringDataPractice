package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.models.Belt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeltRepository extends JpaRepository <Belt, Integer> {

}
