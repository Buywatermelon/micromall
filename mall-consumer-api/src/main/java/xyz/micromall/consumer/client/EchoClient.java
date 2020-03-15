package xyz.micromall.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Mall-Consumer")
public interface EchoClient {

    @GetMapping(path = "/v1/echo/echo")
    String echo();
}
