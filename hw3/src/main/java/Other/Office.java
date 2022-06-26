package Other;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
@JacksonXmlRootElement(localName = "Office")
public class Office {
    public Office() {
    }

    @Override
    public String toString() {
        return "Office{" +
                "address=" + address +
                ", workers=" + workers +
                '}';
    }

    public Office(Address address, List<Object> workers) {
        this.address = address;
        this.workers = workers;
    }
    @JacksonXmlElementWrapper(useWrapping=false)
    @JacksonXmlProperty(localName = "address")
    public Address address;
    @JacksonXmlProperty(localName = "worker")
    public List<Object> workers;
}
