package com.miniproject0705;

import com.miniproject0705.domain.MemberInfoDTO;
import com.miniproject0705.repository.MemberInfoRepoDAO;
import com.miniproject0705.repository.MemberInfoRepoDAOImpl;
import com.miniproject0705.service.MemberService;
import com.miniproject0705.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberInfoRepoDAO memberInfoRepoDAO() { // repo 인터페이스를 구현한 클래스의 생성자 리턴
        return new MemberInfoRepoDAOImpl(memberService());
    }

    @Bean
    public MemberService memberService() { //  service 인터페이스를 구현한 클래스의 생성자 리턴
        return new MemberServiceImpl(memberInfoRepoDAO(), memberInfoDTO());
    } //서비스에서 레포지토리 메서드와 도메인 값을 가져와서 사용해야 하므로 생성자 2개 넣음

    @Bean
    public MemberInfoDTO memberInfoDTO(){
        return new MemberInfoDTO();
    }
}
