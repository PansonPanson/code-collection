package com.panson.home.repository;

import java.util.List;

import com.panson.home.entity.HouseTag;
import org.springframework.data.repository.CrudRepository;



/**
 * Created by 瓦力.
 */
public interface HouseTagRepository extends CrudRepository<HouseTag, Long> {
    HouseTag findByNameAndHouseId(String name, Long houseId);

    List<HouseTag> findAllByHouseId(Long id);

    List<HouseTag> findAllByHouseIdIn(List<Long> houseIds);
}
