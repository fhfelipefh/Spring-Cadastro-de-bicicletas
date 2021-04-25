package com.registerbicycle.register_bicycle.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BikeRepository extends PagingAndSortingRepository<BikeModel, Long> {

    List<BikeModel> findAllByModelContaining(String Model);
    List<BikeModel> findAll();
}
