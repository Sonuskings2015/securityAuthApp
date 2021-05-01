package com.naggaro.usermanage;


import antlr.build.Tool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naggaro.usermanage.controller.AuthController;
import com.naggaro.usermanage.model.User;
import com.naggaro.usermanage.payload.SignUpRequest;
import com.naggaro.usermanage.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AuthController.class)

public class AuthControllerTest {

   @MockBean
    UserRepository userRepository;
    @Autowired
    WebApplicationContext webApplicationContext;


    @Autowired private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }



    ObjectMapper mapper=new ObjectMapper();

    @Test
    public void testUserCreate()throws Exception{
        SignUpRequest request=new SignUpRequest();
        request.setName("admin");
        request.setEmail("admin@naggaro.com");
        request.setUsername("admin");
        request.setPassword("admin");

        User user=new User();
        user.setName("user");
        user.setEmail("user@naggaro.com");
        user.setUsername("user");
        user.setPassword("user");

       // when(userRepository.save(ArgumentMatchers.any(SignUpRequest.class))).thenReturn(user);

        String uri="/api/auth/signup";

        mockMvc.perform(post("/api/auth/signup")
        .content(mapper.writeValueAsString(user))
                .header("Content-Type",MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post(uri)
        .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(user))).andReturn();

        int status=mvcResult.getResponse().getStatus();
        assertEquals(201,status);
        String content =mvcResult.getResponse().getContentAsString();
        assertEquals(content,"Successfully created");



    }
}
