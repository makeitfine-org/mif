/*
 * Created under not commercial project "Make it fine"
 *
 *  Copyright 2017-2019
 *  @author stingion
 */

package com.stingion.makeitfine.controller.it;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.stingion.makeitfine.testconfiguration.IntegrationTest;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@IntegrationTest
abstract class ControllerITProvision {

  @LocalServerPort
  private int port;

  @Value("${protocolHost}")
  private String protocolHost;

  private String hostPort;

  @PostConstruct
  private void init() {
    hostPort = protocolHost + ":" + port;
  }

  @Autowired
  protected TestRestTemplate restTemplate;

  protected String getResponseBody(String relativePath) {
    return restTemplate.getForEntity(hostPort + relativePath, String.class).getBody();
  }
}