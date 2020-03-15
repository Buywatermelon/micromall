package xyz.micromall.admin.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/auth")
@Validated
public class AuthController {
    private static final Log log = LogFactory.get(AdController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody String body) {
        return body;
    }
}
