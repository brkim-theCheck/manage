package com.thecheck.manage;

import com.thecheck.manage.service.LandingManageService;
import com.thecheck.manage.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManageApplicationTests {

	@Autowired
	MemberService memberService;

	@Autowired
	LandingManageService landingManageService;

	@Test
	void contextLoads() {
		/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String before_enc_pass = "$2a$10$yIJRnHVXVSacqGoQ2DB2mOZZD57OQV07BsbwlaVoyUP.trGj51USe";
		String prev_enc_pass = "rlaqudfo";
		String enc_pass = encoder.encode(prev_enc_pass);

		System.out.println("password : " + enc_pass);

		System.out.println("pass match Test: " + encoder.matches(prev_enc_pass, before_enc_pass));

		UserEntity user = memberService.findByUserid("brkim");

		System.out.println(user);*/


	}
}
