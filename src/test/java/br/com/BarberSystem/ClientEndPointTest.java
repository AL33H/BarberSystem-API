package br.com.BarberSystem;

import br.com.BarberSystem.Domain.Entity.Client;
import br.com.BarberSystem.Repository.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClientEndPointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private MockMvc mockMvc;

//    @TestConfiguration
//    static class config{
//        public RestTemplateBuilder restTemplateBuilder(){
//            return new RestTemplateBuilder().basicAuthentication("Ale", "asdasd")
//        }
//    }

    /*
                        TEST
     */

//    @Test
//    void saveClientAndReturnStatusCode200(){
//        Client client = new Client(null,"Aleff","Santos", "Homen", "11/06/1994", "88123", "Tabuleiro do Norte");
//            OngoingStubbing<Client> clientOngoingStubbing = BDDMockito.when(clientRepository.save(client)).thenReturn(client);
////        ResponseEntity response = restTemplate.postForEntity("/clients", client, Client.class);
////        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(201);
//
//        Assertions.assertThat(clientOngoingStubbing.getMock().equals(client)).isEqualTo(client);
//    }

    @Test
    public void getListClientsAndReturn401(){
    ResponseEntity<String> response = restTemplate.getForEntity("/clients",String.class);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }


}
