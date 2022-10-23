package miu.edu.cs.cs425.eregistrar2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"","/","/eregistrar"})
public class HomePageController {

    @GetMapping(value={"", "/home"})
    //@GetMapping(value={"", "/eregistrar/home"})
    public String displayHomePage(){
        return  "index";
    }
}
