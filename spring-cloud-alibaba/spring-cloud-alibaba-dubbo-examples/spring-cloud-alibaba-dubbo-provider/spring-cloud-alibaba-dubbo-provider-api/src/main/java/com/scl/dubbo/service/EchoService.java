package com.scl.dubbo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1.0.0
 * Description:
 * @package: com.scl.dubbo.service
 * @author: chenglu
 * @create: 2020/4/2
 */
@FeignClient("provider")
public interface EchoService {
    @GetMapping("/hi")
    public String test();
}
