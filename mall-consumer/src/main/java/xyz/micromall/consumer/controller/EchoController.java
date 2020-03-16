package xyz.micromall.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.micromall.consumer.mapper.LitemallBrandMapper;
import xyz.micromall.consumer.model.LitemallBrand;

import javax.annotation.Resource;

@RestController
@RequestMapping("/v1/echo")
@Validated
public class EchoController {

    @Resource
    private LitemallBrandMapper litemallBrandMapper;

    @SentinelResource(value = "coo", blockHandler = "handleException")
    @GetMapping(path = "/echo")
    public String echo() {

        LitemallBrand litemallBrand = litemallBrandMapper.selectOne(new QueryWrapper<LitemallBrand>().select("name")
                .eq("id",1001000));

        System.out.println(litemallBrand);

        return "111";
    }
}