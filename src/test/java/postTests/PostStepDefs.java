package postTests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PostStepDefs {
    private Client client = new Client();
    private List<Client> clients = new ArrayList<Client>();
    private PostRequester requester = new PostRequester();

    @Given("client to create:")
    public void store_client(Map<String, String> params) {
        client.setName(params.get("name"));
        client.setSurname(params.get("surname"));
        client.setAge(Integer.valueOf(params.get("age")));

        if (params.get("pk").equals("random")) {
            String randomPK = UUID.randomUUID().toString().substring(0, 15);
            client.setPk(randomPK);
        } else{
            client.setPk(params.get("pk"));}

        client.setPk(params.get("pk"));
        client.setEmail(params.get("email"));

    }

    @When("we are sending client to server")
    public void send_client() {
        requester.storeClient(client);
    }

    @When("requesting list of all clients")
    public void get_all_clients()  throws IOException {
        clients = requester.getAllClient();
    }

    @Then("our new client exists in this list")
    public void check_client() {
        boolean isFound = false;

        for (Client client: clients){
            if (client.getPk().equals(this.client.getPk())) {
                isFound = true;
                break;
                //priverjaem clienta po PK
            }

        }
        Assertions.assertTrue(isFound, "Client is not foun to list");

    }
}
