package com.bookReview.demo;

import com.bookReview.demo.repository.MemberRepository;
import com.bookReview.demo.repository.MemoryMemberRepository;
import com.bookReview.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    //멤버 서비스 빈으로 등록
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    //멤버 저장소 빈으로 등록
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();

    }

}
