package Orders;

import Address.Address;
import Products.Product;

import java.util.List;
public class Order {
    public static int id;
    public Address address;
    public List<Product> productList;
    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "address=" + address + ", " +
                "productList=" + productList +
                '}';
    }

    public Order(Address address, List<Product> productList) {
        id++;
        this.address = address;
        this.productList = productList;
    }

}
