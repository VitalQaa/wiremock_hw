package Tasks;

import Address.Address;
import Orders.Order;
import Products.Apple;
import Products.Orange;
import Products.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hw2 {
    public static void main(String[] args) throws IOException {

        Faker faker = new Faker();
        final int houses = 100;
        final int floors = 16;
        final int flats = 100;
        final int maxPrice = 500;
        final int maxWeight = 200;
        final int numOrders = 100;

        String[] titlesApple = {"Pink Lady", "Empire", "Fuji", "Gala", "Golden Delicious", "Honeycrisp"};
        String[] colorsApple = {"red", "yellow", "green", "pink"};
        String[] titlesOrange = {"Naval", "Blood", "Tangerine", "Acid-less", "Clementine", "Seville"};
        List<Order> orders = new ArrayList<>();
        Random rand = new Random();

        for (int currentNumOrder = 0; currentNumOrder < numOrders; currentNumOrder++) {
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
            int randPriceApple = rand.nextInt(maxPrice)+1;
            int randPriceOrange = rand.nextInt(maxPrice)+1;
            int randWeightApple = rand.nextInt(maxWeight)+1;
            int randWeightOrange = rand.nextInt(maxWeight)+1;
            int indexForRandTitleApple = rand.nextInt(titlesApple.length);
            int indexForRandTitleOrange = rand.nextInt(titlesOrange.length);
            int indexForRandColor = rand.nextInt(colorsApple.length);
            boolean randomWithPips = rand.nextBoolean();
            Apple apple = new Apple(randPriceApple, titlesApple[indexForRandTitleApple], randWeightApple, colorsApple[indexForRandColor]);
            Orange orange = new Orange(randPriceOrange, titlesOrange[indexForRandTitleOrange], randWeightOrange, randomWithPips);
            List<Product> products = new ArrayList<>();
            products.add(apple);
            products.add(orange);
            Order order = new Order(address, products);
            orders.add(order);
        }

        ObjectMapper mapper = new ObjectMapper();
        FileWriter fileWriter = new FileWriter("src/orders.json");
        mapper.writeValue(fileWriter, orders);
        FileReader fileReader = new FileReader("src/orders.json");
        orders = mapper.readValue(fileReader, List.class);
        System.out.println(orders);
    }
}
