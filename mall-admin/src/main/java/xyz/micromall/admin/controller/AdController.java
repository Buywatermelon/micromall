package xyz.micromall.admin.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.micromall.consumer.client.EchoClient;

@RestController
@RequestMapping("/admin/ad")
@Validated
public class AdController {

    @Autowired
    private EchoClient echoClient;

    @SentinelResource(value = "echo")
    @GetMapping("/echo")
    public String echo() {
        System.out.println("111");
        return echoClient.echo();
    }
}
