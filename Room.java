import java.util.*;

public class Room {
    public String name;
    ArrayList<Person> personAvailable = new ArrayList<Person>();

    public Room(String name, ArrayList<Person> persons) {
        this.name = name;
        for (Person person : persons) {
            this.personAvailable.add(person);
        }
    }

}
