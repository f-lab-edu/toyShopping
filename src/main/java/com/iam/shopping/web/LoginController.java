package com.iam.shopping.web;

import com.iam.shopping.domain.Member;
import com.iam.shopping.dto.LoginDTO;
import com.iam.shopping.service.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "login", description = "로그인 API")
@Slf4j
@RequestMapping("/login")
@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity login(@Validated @RequestBody LoginDTO loginDTO, BindingResult bindingResult) {
        // 검증 실패 시
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult.getModel());
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Member login = loginService.login(loginDTO.getLoginId(), loginDTO.getPassword());
        log.info("로그인ID={}", login.getId());

        return new ResponseEntity(loginDTO, HttpStatus.OK);
    }
}
