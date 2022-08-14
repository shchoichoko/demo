package com.bookReview.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data","LiLa");
        return "hello";
    }

    @GetMapping("/helloMVC")
    public String helloMVC(@RequestParam(value = "name") String name,@RequestParam("age") String age,Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "hello_template";
    }

    //화면에서 바로 출력하기. html 형식이 아니라 그대로 출력함.
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name")String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value = "name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
