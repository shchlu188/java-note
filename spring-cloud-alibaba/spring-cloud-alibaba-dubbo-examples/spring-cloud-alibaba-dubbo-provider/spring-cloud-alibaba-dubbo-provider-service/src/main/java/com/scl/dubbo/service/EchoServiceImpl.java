package com.scl.dubbo.service;

import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1.0.0
 * Description:
 * @package: com.scl.dubbo.service
 * @author: chenglu
 * @create: 2020/4/2
 */
@RestController
public class EchoServiceImpl implements EchoService {
    @Override
    public String test() {
        return "hello alibaba cloud dubbo";
    }
}
