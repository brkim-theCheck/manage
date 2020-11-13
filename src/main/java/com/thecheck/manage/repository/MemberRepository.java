package com.thecheck.manage.repository;
/*
 * @author brKim
 * @date 2020/10/27
 * @desc
 */

import com.thecheck.manage.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByUserid(String userId);
}
