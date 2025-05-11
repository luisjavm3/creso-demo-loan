package co.luisjavm3.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String test() {
        return "Loan Service - OK - v1";
    }

    @GetMapping("/loop")
    public String test1() {
        for (int i = 0; i < 1000; i++) {

        }

        return "Loan Service : Loop OK";
    }
}
