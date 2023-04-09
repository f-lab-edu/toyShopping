package com.iam.shopping.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @RequestMapping(value = "/healthcheck")
    public HealthStatus healthcheck() {
        return new HealthStatus("ok");
    }

    class HealthStatus {
        private String status;

        HealthStatus(String status) {
            this.status = status;
        }

        String getStatus() {
            return status;
        }
    }
}
