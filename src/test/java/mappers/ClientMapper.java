package mappers;

import model.Client;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ClientMapper {

    @Test
    public void mapClientFromFile() throws IOException {
        Client client = new Client();

        File file = new File(Thread.currentThread().getContextClassLoader().getResource("users/pl.txt").getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();

        String[] data = line.trim().replaceAll(" +", " ").split(" ");

        client.setName(data[0]);
        client.setSername(data[1]);
        client.setPesel(data[2]);
        client.setDocumentNumber(data[3]);
        client.setMail(data[4]);
        client.setPhone(data[6]);

        String out = "";

        while ((line = br.readLine()) != null) {
            out = out + line;
        }

        PrintWriter writer = new PrintWriter(file.getPath());
        writer.println(out);
        writer.close();

//        return client;
    }

}
