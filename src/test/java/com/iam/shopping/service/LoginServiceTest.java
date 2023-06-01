package com.iam.shopping.service;

import com.iam.shopping.domain.Member;
import com.iam.shopping.exception.LoginException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @DisplayName("findByLoginId 메서드 테스트, 사용자 ID가 존재하지 않는 경우 LoginException 예외 발생하며, 메시지는 이메일 ID가 존재하지 않습니다. 출력")
    @Test
    void findByLoginIdFailTest() {
        // given
        String id = "dho@naver.com";

        // when

        // then
        assertThrows(LoginException.class, () -> loginService.findByLoginId(id));
        assertThatThrownBy(() -> loginService.findByLoginId(id)).isInstanceOf(LoginException.class)
                .hasMessage("이메일 ID가 존재하지 않습니다.");
    }

    @DisplayName("findByLoginId 메서드 테스트, 사용자 ID가 존재하는 경우, Member 객체 리턴")
    @Test
    void findByLoginIdSuccessTest() {
        // given
        String id = "dho0647@naver.com";

        // when
        Optional<Member> member = loginService.findByLoginId(id);

        // then
        assertThat(member).isInstanceOf(Optional.class);
        assertThat(member.get()).isInstanceOf(Member.class);
    }

    @DisplayName("login 성공 테스트, id와 password가 맞으면 로그인이 성공해야한다.")
    @Test
    void loginSuccessTest() {
        // given
        String id = "dho0647@naver.com";
        String password = "1234";

        // when
        Member login = loginService.login(id, password);

        // then
        assertThat(login.getId()).isEqualTo("dho0647@naver.com");
        assertThat(login.getName()).isEqualTo("이동호");
    }

    @DisplayName("login 실패 테스트, id와 password가 맞지 않으면 LoginException 예외가 발생하며, 비밀번호가 맞지 않습니다. 출력")
    @Test
    void loginFailTest() {
        // given
        String id = "dho0647@naver.com";
        String password = "123456";

        // when

        // then
        assertThatThrownBy(() -> loginService.login(id, password))
                .isInstanceOf(LoginException.class)
                .hasMessage("비밀번호가 맞지 않습니다.");
    }


}