package com.iam.shopping.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@Slf4j
public class HomeController {
    @RequestMapping(value = "/homeLogin", method = RequestMethod.POST)
    public String homeLogin(@SessionAttribute(name = "loginId", required = false) String name) {
        log.info("member Name={}", name);
        return name;
    }
}
