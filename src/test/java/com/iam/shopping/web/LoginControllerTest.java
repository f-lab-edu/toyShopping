package com.iam.shopping.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iam.shopping.dto.LoginDTO;
import com.iam.shopping.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class LoginControllerTest {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new LoginController(loginService)).build();
    }

    @DisplayName("LoginController URL 접속 테스트")
    @Test
    void viewTest() throws Exception {
        // given
        String content = objectMapper.writeValueAsString(new LoginDTO("dho0647@naver.com", "1234"));

        mockMvc.perform(post("/login")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("로그인 성공 시 세션 테스트")
    @Test
    void sessionTest() throws Exception {
        MockHttpSession session = new MockHttpSession();

        // given
        String content = objectMapper.writeValueAsString(new LoginDTO("dho0647@naver.com", "1234"));

        mockMvc.perform(post("/login")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(session))
                .andExpect(status().isOk())
                .andDo(print());
    }
}