package com.bookReview.demo.controller;


import com.bookReview.demo.domain.Member;
import com.bookReview.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //URL 창에 쳐서 입력되는 GET방식
    @GetMapping("/members/new")
    public String creatForm(){
        return "members/createMemberForm";
    }

    //POST방식
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        //회원 개체 저장
        memberService.join(member);
        return "redirect:/";
    }

    //
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);

        return "members/memberList";
    }
}
