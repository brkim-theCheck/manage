package com.thecheck.manage.repository;

import com.thecheck.manage.model.LandingInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LandingInfoRepository extends JpaRepository<LandingInfoEntity, Integer> {
    Page<LandingInfoEntity> findAll(Specification<LandingInfoEntity> spec, Pageable pageable);

    List<LandingInfoEntity> findAll(Specification<LandingInfoEntity> searchWith);

}
