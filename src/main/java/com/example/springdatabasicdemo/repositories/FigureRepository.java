package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.models.Belt;
import com.example.springdatabasicdemo.models.Figure;
import com.example.springdatabasicdemo.models.FigureOfBoxer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FigureRepository extends JpaRepository <Figure, Long> {

    //Найти фигурки по прозвищу боксёра
    @Query(value = "SELECT f FROM Figure AS f " +
            "INNER JOIN FigureOfBoxer as fb ON f.id = fb.figure_id " +
            "INNER JOIN boxer AS b ON b.id = fb.boxer_id WHERE b.nickname = :nickname")
//Найти фигурки по прозвищу боксёра
    List<Figure> findAllByNickname(@Param(value = "nickname") String nickname);

    //Найти фигурки по организации
    @Query(value = "SELECT fb FROM Figure AS f " +
            "INNER JOIN FigureOfBoxer as fb ON f.id = fb.figure_id " +
            "INNER JOIN boxer AS b ON b.id = fb.boxer_id " +
            "INNER JOIN Belt AS be ON be.boxer_ID=b.id " +
            "INNER JOIN BoxingOrganization AS org ON org.id=be.org_ID " +
            "WHERE org.org_name=:name")
    List<FigureOfBoxer> findAllByBelt(@Param(value = "name") String name);

    @Query(value = "SELECT f FROM Figure AS f WHERE f.size IN :size")
    List<Figure> findPriceBySize(@Param(value = "size") String size);
    
//    List<Figure> findAllByBoxer_id(Long boxer_id);
//
//    @Query(value = "SELECT f FROM Figure AS f INNER JOIN FigureOfBoxer as fb ON f.id = fb.figure_id INNER JOIN boxer AS b ON b.id = fb.boxer_id WHERE b.nickname = :nickname")
//    List<Figure> findAllByOrg_name(@Param(value = "org_name") String org_name);

//    List<Figure> findAllByOrg_name(String org_name);
}
