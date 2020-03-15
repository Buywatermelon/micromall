package xyz.micromall.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/echo")
@Validated
public class EchoController {

    @SentinelResource(value = "coo")
    @GetMapping(path = "/echo")
    public String echo() {
        return "111";
    }
}