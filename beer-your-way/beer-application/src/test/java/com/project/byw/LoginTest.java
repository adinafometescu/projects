package com.project.byw;

import com.project.byw.config.WebSecurityConfig;
import com.project.byw.form.UserForm;
import login.LoginConfiguration;
import login.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Import({WebSecurityConfig.class, LoginConfiguration.class})
public class LoginTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;

    @Before
    public void init() {
        userService.deleteUser("example@domain.com");
    }

    @Test
    public void testRegisterWithSuccess() throws Exception {
        UserForm userForm = new UserForm();
        userForm.setEmail("example@domain.com");
        userForm.setPassword("password");
        this.mockMvc.perform(
                post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .flashAttr("userForm", userForm)
                        .with(csrf()))
                .andExpect(status().isCreated());
    }

    @Test
    public void testRegisterWithDuplicateAccount() throws Exception {
        UserForm userForm = new UserForm();
        userForm.setEmail("example@domain.com");
        userForm.setPassword("password");
        this.mockMvc.perform(
                post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .flashAttr("userForm", userForm)
                        .with(csrf()))
                .andExpect(status().isCreated());

        this.mockMvc.perform(
                post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .flashAttr("userForm", userForm)
                        .with(csrf()))
                .andExpect(status().isConflict());
    }

}
