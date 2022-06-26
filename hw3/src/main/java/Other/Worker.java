package Workers;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Worker")

public class Worker {
    public Worker() {
    }
    public static int id;
    public String firstname;
    public String lastname;
    public String patronymic;
    public int experience;
    public int salary;

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", experience=" + experience +
                ", salary=" + salary +
                '}';
    }

    public Worker(String firstname, String lastname, String patronymic, int experience, int salary) {
        id++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.experience = experience;
        this.salary = salary;

    }
}
