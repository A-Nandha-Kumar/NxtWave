package com.example.apirouting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.apirouting.MyService;

@RestController
public class MyController{
    MyService service = new MyService();

    @GetMapping("/")
    public String getHome(){
        return service.getHome();
    }

    @GetMapping("/about")
    public String getAbout(){
        return service.getAbout();
    }
}
