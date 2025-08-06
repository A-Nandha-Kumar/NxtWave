package com.example.apirouting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    MyService apiservice = new MyService();

    @GetMapping("/")
    public String getHomePage() {
        return apiservice.getHomePage();
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return apiservice.getAboutPage();
    }

}
