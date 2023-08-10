package pl.pingwit.postservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.pingwit.postservice.senders.controller.model.SenderDTO;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(classes = PostServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SendersLifecycleIT {

    @LocalServerPort
    private Integer port;

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:12");

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getPassword);
        registry.add("spring.datasource.password", postgres::getUsername);
        registry.add("spring.datasource.driver-class-name", postgres::getDriverClassName);
    }

    @Test
    @DisplayName("Check if any senders were created during startup")
    void checkSenders() {

        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<SenderDTO[]> forEntity = restTemplate.getForEntity("http://localhost:" + port + "/senders", SenderDTO[].class);
        SenderDTO[] body = forEntity.getBody();

        assertThat(body).isNotEmpty();
    }

    @Test
    @DisplayName("Tests sender creation and subsequent retrieval")
    void verifyCreateSender() {
        // given
        RestTemplate restTemplate = new RestTemplate();
        SenderDTO someSender = someSender();

        // prepare request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SenderDTO> request = new HttpEntity<>(someSender, headers);

        // user creation
        ResponseEntity<SenderDTO> forEntity = restTemplate.postForEntity("http://localhost:" + port + "/senders", request, SenderDTO.class);
        SenderDTO createdSender = forEntity.getBody();

        // when
        SenderDTO actual = restTemplate.getForObject("http://localhost:" + port + "/senders/" + createdSender.getId(), SenderDTO.class);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getEmail()).isEqualTo("opo@kjkjk.oiio");
        assertThat(actual.getName()).isEqualTo("Pavel");
        assertThat(actual.getSurname()).isEqualTo("Pupkin");
        assertThat(actual.getPhone()).isEqualTo("98878676");
    }

    private SenderDTO someSender() {
        SenderDTO senderDTO = new SenderDTO();
        senderDTO.setEmail("opo@kjkjk.oiio");
        senderDTO.setName("Pavel");
        senderDTO.setSurname("Pupkin");
        senderDTO.setPhone("98878676");
        return senderDTO;
    }
}
