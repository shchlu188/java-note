package com.scl.dubbo.controller;

import com.scl.dubbo.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created with IntelliJ IDEA.
 *
 * @version v1.0.0
 * Description:
 * @package: com.scl.dubbo.controller
 * @author: chenglu
 * @create: 2020/4/2
 */
@RestController
public class EchoController {
    @Autowired
    private EchoService echoService;

    @GetMapping("/test")
    public String test(){
        return echoService.test();
    }

}
