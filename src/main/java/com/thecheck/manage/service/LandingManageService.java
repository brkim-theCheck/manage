package com.thecheck.manage.service;
/*
 * @author brKim
 * @date 2020/10/29
 * @desc
 */

import com.thecheck.manage.component.LandingInfoSpecification;
import com.thecheck.manage.model.LandingInfoEntity;
import com.thecheck.manage.repository.LandingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class LandingManageService {
    @Autowired
    LandingInfoRepository landingInfoRepository;

    @Autowired
    LandingInfoSpecification landingInfoSpecification;

    public ResponseEntity getLandingInfo(final Pageable pageable, Map<String, Object> param) {

        Page<LandingInfoEntity> landingInfoEntities = param.isEmpty() ? landingInfoRepository.findAll(pageable) : landingInfoRepository.findAll(landingInfoSpecification.searchWith(param), pageable);

        return new ResponseEntity<>(landingInfoEntities, HttpStatus.OK);
    }

    public List<LandingInfoEntity> findAll(Map<String, Object> param) {
        return (List<LandingInfoEntity>) landingInfoRepository.findAll(landingInfoSpecification.searchWith(param));
    }

    public List<LandingInfoEntity> findAll() {
        return (List<LandingInfoEntity>) landingInfoRepository.findAll();
    }

    @Transactional
    public ResponseEntity saveLandingInfo(LandingInfoEntity landingInfoEntity) {

        return new ResponseEntity<>(landingInfoRepository.save(landingInfoEntity), HttpStatus.OK) ;
    }
}
