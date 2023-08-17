package com.teamProject.mentoring.controller;


import com.teamProject.mentoring.dto.UserDto;
import com.teamProject.mentoring.entity.Center;
import com.teamProject.mentoring.entity.Message;
import com.teamProject.mentoring.entity.UserEntity;
import com.teamProject.mentoring.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;



@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("user/sign_up_in")
    public String registerHome(){
        return "sign_up_in";
    }

    @PostMapping("user/sign_up")
    public ModelAndView save(@ModelAttribute UserDto userDto, ModelAndView modelAndView){

        System.out.println(userDto.toString());


        // 회원가입 성공 시 로그인 페이지.
        if(userService.save(userDto)) {
            System.out.println("성공");
            modelAndView.addObject("data", new Message("회원가입 성공.", "/user/sign_up_in"));
        }
        // 회원가입 실패 (이메일 중복) 시 알림창 띄우고 다시 회원가입 페이지
        else {
            System.out.println("실패");
            modelAndView.addObject("data", new Message("이미 가입된 이메일입니다. 다시 회원가입 해주세요.", "/user/sign_up_in"));
        }
        modelAndView.setViewName("Message");


        return modelAndView;
    }

    @PostMapping("user/sign_in")
    public ModelAndView login(@ModelAttribute UserDto userDto, HttpSession session, ModelAndView modelAndView){
        System.out.println("로그인 dto = "+userDto.toString());
        UserDto loginResult = userService.login(userDto);
        if(loginResult != null){
            // 로그인 성공
            // 앞으로 이 세션 정보를 이용.
            session.setAttribute("userEmail", loginResult.getEmail());
            System.out.println("성공!");
            modelAndView.addObject("data", new Message("", "/mainPage"));
//            return "mainPage";
        }
        else{
            // 로그인 실패
            System.out.println("실패!");
            modelAndView.addObject("data", new Message("계정 정보가 일치하지 않습니다.", "/user/sign_up_in"));
//            return "loginHome";
        }
        modelAndView.setViewName("Message");
        return modelAndView;
    }


    @GetMapping("mainPage2")
    public String mainPage2(){
        return "mainPage2";
    }

    @GetMapping("buttonTest")
    public String buttonTest(HttpSession httpSession){
        System.out.println(httpSession.getAttribute("userEmail"));
        return "buttonTest";
    }

    @GetMapping("buttonTest2")
    public String buttonTest2(Model model){
        List<Center> centerList = userService.buttonTest();
        model.addAttribute("centerList", centerList);

        return "buttonTest2";
    }
//    @PostMapping("buttonTest")
//    public String save_branch(HttpSession httpSession){
//        List<Center> centerList = userService.buttonTest("힘찬지역아동센터");
//        for(Center c : centerList){
//            System.out.println(c.getInfo());
//            System.out.println(c.getIntro());
//            System.out.println(c.getProgram());
//            System.out.println(c.getName());
//        }
//
//
//        return "buttonTest";
//    }

    @Configuration
    public class MvcConfig implements WebMvcConfigurer {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("buttonTest2").setViewName("buttonTest2");
        }
    }


    @GetMapping("fstPage")
    public String fstPage(){
        return "fstPage";
    }
    @GetMapping("mainPage")
    public String mainPage(){
        return "mainPage";
    }

    @GetMapping("test/a1")
    public String test_a1(){
        return "test_a1";
    }
    @GetMapping("test/a2")
    public String test_a2(){
        return "test_a2";
    }
    @GetMapping("test/a3")
    public String test_a3(){
        return "test_a3";
    }
    @GetMapping("test/a4")
    public String test_a4(){
        return "test_a4";
    }
    @GetMapping("test/a5")
    public String test_a5(){
        return "test_a5";
    }
    @GetMapping("test/a6")
    public String test_a6(){
        return "test_a6";
    }
    @GetMapping("test/a7")
    public String test_a7(){
        return "test_a7";
    }
    @GetMapping("test/a8")
    public String test_a8(){
        return "test_a8";
    }

    @PostMapping("/test/a1")
    @ResponseBody
    public String handleA1Request(HttpSession httpSession){
        userService.updateUserProfile((String) httpSession.getAttribute("userEmail"), "과학");
        return "test/a1";
    }
    @PostMapping("/test/a2")
    @ResponseBody
    public String handleA2Request(HttpSession httpSession){
        userService.updateUserProfile((String) httpSession.getAttribute("userEmail"), "코딩");
        return "test/a2";
    }
    @PostMapping("/test/a3")
    @ResponseBody
    public String handleA3Request(HttpSession httpSession){
        userService.updateUserProfile((String) httpSession.getAttribute("userEmail"), "생활");
        return "test/a3";
    }
    @PostMapping("/test/a4")
    @ResponseBody
    public String handleA4Request(HttpSession httpSession){
        userService.updateUserProfile((String) httpSession.getAttribute("userEmail"), "독서");
        return "test/a4";
    }
    @PostMapping("/test/a5")
    @ResponseBody
    public String handleA5Request(HttpSession httpSession){
        userService.updateUserProfile((String) httpSession.getAttribute("userEmail"), "미술");
        return "test/a5";
    }
    @PostMapping("/test/a6")
    @ResponseBody
    public String handleA6Request(HttpSession httpSession){
        userService.updateUserProfile((String) httpSession.getAttribute("userEmail"), "수학");
        return "test/a6";
    }
    @PostMapping("/test/a7")
    @ResponseBody
    public String handleA7Request(HttpSession httpSession){
        userService.updateUserProfile((String) httpSession.getAttribute("userEmail"), "체육");
        return "test/a7";
    }
    @PostMapping("/test/a8")
    @ResponseBody
    public String handleA8Request(HttpSession httpSession){
        userService.updateUserProfile((String) httpSession.getAttribute("userEmail"), "영어");
        return "test/a8";
    }



    @GetMapping("test/q1")
    public String test_q1(){
        return "test_q1";
    }
    @GetMapping("test/q2")
    public String test_q2(){
        return "test_q2";
    }
    @GetMapping("test/q3")
    public String test_q3(){
        return "test_q3";
    }
    @GetMapping("test/q4")
    public String test_q4(){
        return "test_q4";
    }
    @GetMapping("test/q5")
    public String test_q5(){
        return "test_q5";
    }
    @GetMapping("test/q6")
    public String test_q6(){
        return "test_q6";
    }
    @GetMapping("test/q7")
    public String test_q7(){
        return "test_q7";
    }
    @GetMapping("test/main")
    public String test_main(){
        return "test_main";
    }
    @GetMapping("test/a_list")
    public String test_a_list(){
        return "test_a_list";
    }







}
