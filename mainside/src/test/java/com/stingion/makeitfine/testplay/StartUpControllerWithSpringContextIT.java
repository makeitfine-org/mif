package com.stingion.makeitfine.testplay;

import com.stingion.makeitfine.controller.StartUpController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("it")
public class StartUpControllerWithSpringContextIT {

    @Autowired
    private StartUpController startUpController;

    @Test
    public void testContextLoads() {
        assertThat(startUpController).isNotNull();
    }
}