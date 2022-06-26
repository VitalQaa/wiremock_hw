package Address;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect
public class Address {
    public String country;
    public String city;
    public String street;
    public int house_number;
    public int floor;
    public int flat_number;

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house_number=" + house_number +
                ", floor=" + floor +
                ", flat_number=" + flat_number +
                '}';
    }



    public Address(String country, String city, String street, int house_number, int floor, int flat_number) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.floor = floor;
        this.flat_number = flat_number;
    }


}