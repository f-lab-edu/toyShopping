package com.iam.shopping.web;

import com.iam.shopping.domain.Member;
import com.iam.shopping.dto.LoginDTO;
import com.iam.shopping.exception.LoginException;
import com.iam.shopping.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Tag(name = "login", description = "로그인/로그아웃 API")
@Slf4j
@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Tag(name = "login")
    @Operation(summary = "로그인 API", description = "Email과 Password가 맞으면 로그인에 성공한다.")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@Valid @RequestBody LoginDTO loginDTO, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            log.info("error={}", bindingResult);
            throw new LoginException(bindingResult.getFieldError().getDefaultMessage());
        }

        Member login = loginService.login(loginDTO.getLoginId(), loginDTO.getPassword());

        // 로그인 성공 처리
        // 세션이 있으면 세션 반환, 없으면 세션 신규 생성
        HttpSession session = request.getSession(true);

        // 세션에 로그인 회원 정보 보관
        session.setAttribute("loginId", login.getName());

        log.info("sessionId={}", session.getId());
        log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval());
        log.info("getCreationTime={}", new Date(session.getCreationTime()));
        log.info("getLastAccessedTime={}", new Date(session.getLastAccessedTime())); // 세션에 마지막으로 사용자가 접근한 시간
        log.info("isNew={}", session.isNew());
    }

    @Tag(name = "login")
    @Operation(summary = "로그인아웃 API", description = "로그아웃 시 세션 삭제와 index.html을 초기화면으로 되돌린다.")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate(); // 세션이랑 그 안에 Data가 다 날라간다.

        // 정상적으로 세션이 무효화 됐는지 검증
        if (session == null || !request.isRequestedSessionIdValid()) {
            log.info("session.invalidate success");
        }

        // TODO session.invalidate()를 실행해도 JSESSIONID가 남아있다. 남아있는 이유 찾고 issue 등록하기.
    }
}
