package Products;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Orange extends Product{
    public boolean withPips;
    public Orange() {
    }
    public Orange(int price, String title, int weight, boolean withPips) {
        super(price, title, weight);
        this.withPips = withPips;
    }

    @Override
    public String toString() {
        return "Products.Orange{" +
                "withPips=" + withPips +
                ", weight=" + weight +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}