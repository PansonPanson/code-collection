package com.panson.home.repository;

import java.util.List;

import com.panson.home.entity.SubwayStation;
import org.springframework.data.repository.CrudRepository;



/**
 * Package: com.panson.home.repository
 * Description：
 * Author: Panson
 * Date: Created in 7/15 17:29
 */
public interface SubwayStationRepository extends CrudRepository<SubwayStation, Long> {
    List<SubwayStation> findAllBySubwayId(Long subwayId);
}
