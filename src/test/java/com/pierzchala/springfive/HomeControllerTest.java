package com.pierzchala.springfive;

import com.pierzchala.springfive.controller.HomeController;
import io.sentry.Sentry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    JavaMailSender mailSender;

//    @Autowired
//    private MailService mailService;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(
                        containsString("Witaj w...")));
    }

    @Test
    public void sentryStart() {
        Sentry.init("https://52c6d9c2d6b54968bb42fef5cc9ae5f0@sentry.io/5186900?environment=dev&stacktrace.app.packages=com.pierzchala");
        Sentry.capture("This is a test");

        System.out.println(Sentry.isInitialized());
    }

    @Test
    public void sendMail() {
//        sendMail("statek.kosmiczny@gmail.com","Jest Super", "Wiadomość",false);
    }


}
