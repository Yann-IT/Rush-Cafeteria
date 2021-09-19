
import java.util.*;

public class Cafet {

    static ArrayList<Person> personList = new ArrayList<Person>();
    static ArrayList<Room> roomList = new ArrayList<Room>();
    static ArrayList<Person> notUsedInShift = new ArrayList<Person>();

    public static void ini(String[] persons, String[] rooms) {
        for (String person : persons) {
            personList.add(new Person(person));
        }
        for (Person person : personList) {
            person.setDuoAvailable(personList);
        }
        for (String room : rooms) {
            roomList.add(new Room(room, personList));
        }
    }

    static void printArrayList(ArrayList<Object> array, String[] rooms) {
        System.out.print("ArrayList[");
        for (int i = 0; i < array.size(); i++) {
            System.out.print("\n  Day(" + (i + 1) + ")[");
            Map<String, ArrayList<String>> places = (Map<String, ArrayList<String>>) array.get(i);

            for (String place : rooms) {
                System.out.print("\n    Place(" + place + ") [");
                ArrayList<String> names = places.get(place);

                for (int j = 0; j < names.size(); j++) {
                    System.out.print(names.get(j));
                    if (j < names.size() - 1)
                        System.out.print(", ");
                }
                System.out.print("]");
            }
            System.out.print("\n  ]");
        }
        System.out.print("\n]\n");
    }

    public static Map<Room, ArrayList<Person>> findDuos(Room room) {
        System.out.println(room.name);
        ArrayList<Person> availablePerson = new ArrayList<Person>();
        for (Person person : room.personAvailable) {
            if (notUsedInShift.contains(person)) {
                availablePerson.add(person);
            }
        }

        ArrayList<Person> duo = new ArrayList<Person>();

        for (Person person : availablePerson) {
            if (person.isDuoAvailable(availablePerson)) {
                Person foundPerson = person.findDuo(availablePerson);
                System.out.println("found duo : " + person.name + " & " + foundPerson.name);
                room.personAvailable.remove(person);
                room.personAvailable.remove(foundPerson);
                notUsedInShift.remove(person);
                notUsedInShift.remove(foundPerson);
                duo.add(person);
                duo.add(foundPerson);

                break;
            }
        }

        Map<Room, ArrayList<Person>> map = new HashMap<Room, ArrayList<Person>>();
        map.put(room, duo);
        return map;
    }

    public static ArrayList<Object> byShift() {
        for (Person person : personList) {
            notUsedInShift.add(person);
        }

        ArrayList<Object> listShifts = new ArrayList<Object>();
        for (Room room : roomList) {
            Map<Room, ArrayList<Person>> map = findDuos(room);
            listShifts.add(map);
        }
        return listShifts;
    }

    public static void main(String[] args) {
        String[] employees = { "Marcus", "Lateefa", "Donald", "Rashad", "Quincy", "Mia" };
        String[] cafeteria = { "Lobby", "Dining Room", "Kitchen" };
        int[] shifts = { 0, 1, 2, 3, 4, 5, 6, 7 };

        ini(employees, cafeteria);

        ArrayList<Object> list = new ArrayList<>();
        for (int shift : shifts) {
            System.out.println("Day" + shift);
            list.add(byShift());

        }

        // printArrayList(list, cafeteria);

    }
}