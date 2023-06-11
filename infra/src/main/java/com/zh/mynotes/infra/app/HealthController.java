package com.zh.mynotes.infra.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author iccry.zeng
 * @Description
 * @Date Create in 2023/06/11 2:20
 */
@RestController
@Slf4j
public class HealthController {

    @GetMapping("ok")
    public boolean ok() {
        log.debug("It's ok!");
        return true;
    }
}
