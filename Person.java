import java.util.*;

public class Person {
    public String name;
    ArrayList<Person> duoAvailable = new ArrayList<Person>();

    public Person(String name) {
        this.name = name;
    }

    public void setDuoAvailable(ArrayList<Person> persons) {
        for (Person person : persons) {
            if (person != this) {
                duoAvailable.add(person);
            }
        }
    }

    public boolean isDuoAvailable(ArrayList<Person> persons) {
        for (Person person : persons) {
            if (duoAvailable.contains(person)) {
                return true;
            }
        }
        return false;
    }

    public Person findDuo(ArrayList<Person> persons) {
        Person duo = new Person("none");
        for (Person person : persons) {
            if (duoAvailable.contains(person)) {
                this.duoAvailable.remove(person);
                person.duoAvailable.remove(this);
                duo = person;
                break;
            }
        }
        return duo;
    }

}