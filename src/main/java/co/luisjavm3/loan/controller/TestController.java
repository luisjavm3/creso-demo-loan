package co.luisjavm3.loan.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${instance.id}")
    private String instanceId;

    @GetMapping
    public String test() {
        return "Loan Service : OK";
    }

    @GetMapping("/version")
    public String version() {
        return "Loan Service : v1";
    }

    @GetMapping("/instance-id")
    public String getInstanceId() {
        String shortId = instanceId.length() > 4 ? instanceId.substring(0, 4) : instanceId;
        return "Instance ID: " + shortId;
    }

    @GetMapping("/loop")
    public String test1(@RequestParam(name = "count", defaultValue = "1000") int count) {
        Random r = new Random();

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 10000; j++) {
                r.nextInt(100);
            }
        }

        return "Loan Service : Loop : " + count;
    }
}
