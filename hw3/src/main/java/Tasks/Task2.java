package Tasks;

import Other.Address;
import Other.Office;
import Workers.Worker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.javafaker.Faker;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) throws IOException {
        Faker faker = new Faker();
        final int houses = 100;
        final int floors = 16;
        final int flats = 100;
        Random rand = new Random();
        List <Object> offices = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int randHouse = rand.nextInt(houses) + 1;
            int randFloor = rand.nextInt(floors) + 1;
            int randFlat = rand.nextInt(flats) + 1;
            Address address = new Address(
                    faker.address().country(),
                    faker.address().city(),
                    faker.address().streetName(),
                    randHouse,
                    randFloor,
                    randFlat
            );
            List<Object> workers = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Worker worker = new Worker(faker.name().firstName(), faker.name().lastName(), faker.name().firstName()+"vich", rand.nextInt(50)+1, rand.nextInt(200000)+1);
                workers.add(worker);
            }
            Office office = new Office(address, workers);
            offices.add(office);
            //workers.clear();

        }

        FileWriter fileWriter = new FileWriter("src/office.xml");
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writeValue(fileWriter, offices);
        FileReader fileReader = new FileReader("src/office.xml");
        offices = objectMapper.readValue(fileReader, List.class);
        System.out.println(offices.toString());
    }
}
