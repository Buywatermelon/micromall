package xyz.micromall.consumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {
    public static void main(String[] args) {
        disableWarning(); //禁用警告
        SpringApplication.run(ConsumerApplication.class);
    }

    public static void disableWarning() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe u = (Unsafe) theUnsafe.get(null);

            Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
        } catch (Exception e) {
            // ignore
        }
    }

    @Service
    public class TestService {

        @SentinelResource(value = "sayHello")
        public String sayHello(String name) {
            return "Hello, " + name;
        }
    }

    @RestController
    public class TestController {

        @Autowired
        private TestService service;

        @GetMapping(value = "/hello/{name}")
        public String apiHello(@PathVariable String name) {
            return service.sayHello(name);
        }
    }
}
