package com.thecheck.manage.service;
/*
 * @author brKim
 * @date 2020/10/27
 * @desc
 */

import com.thecheck.manage.model.UserEntity;
import com.thecheck.manage.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public UserEntity findByUserid(String id) {
        return memberRepository.findByUserid(id);
    }
}
