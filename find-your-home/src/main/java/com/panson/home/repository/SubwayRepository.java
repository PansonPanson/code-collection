package com.panson.home.repository;

import java.util.List;

import com.panson.home.entity.Subway;
import org.springframework.data.repository.CrudRepository;



public interface SubwayRepository extends CrudRepository<Subway, Long>{
    List<Subway> findAllByCityEnName(String cityEnName);
}
