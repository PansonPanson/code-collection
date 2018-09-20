package com.panson.home.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.panson.home.entity.SupportAddress;
/**
 * Package: com.panson.home.repository
 * Description：
 * Author: Panson
 * Date: Created in 7/15 17:29
 */
public interface SupportAddressRepository extends CrudRepository<SupportAddress, Long>{
    /**
     * 获取所有对应行政级别的信息
     * @return
     */
    List<SupportAddress> findAllByLevel(String level);

    SupportAddress findByEnNameAndLevel(String enName, String level);

    SupportAddress findByEnNameAndBelongTo(String enName, String belongTo);

    List<SupportAddress> findAllByLevelAndBelongTo(String level, String belongTo);

}
