package postTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class PostRequester {

    private final String DOMAIN = "http://qaguru.lv";
    private RestTemplate restTemplate = new RestTemplate();

    public void storeClient(Client client) {
        String url = DOMAIN + "/addNewTestClient";

        restTemplate.postForEntity(url, client, String.class);
    }

    public List<Client> getAllClient() throws IOException {
        String url = DOMAIN + "/getAllTestUsers";

        String stringToConvert = restTemplate.getForEntity(url, String.class).getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();

        return objectMapper.readValue(stringToConvert, typeFactory.constructCollectionType(List.class, Client.class));
        //vozvrawaem client
    }
}
