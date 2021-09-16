import java.util.*;

public class Cafet{
    ArrayList<Person> personList;
    ArrayList<Person> notUsedInShift;
    public static void init(String[] persons, String[] rooms){
        for (String person : persons) {
            personList.add(new Person(person, persons, rooms));
        }
    }

    static void printArrayList(ArrayList array, String[] rooms) {
        System.out.print("ArrayList[");
        for (int i = 0; i < array.size(); i++) {
            System.out.print("\n  Day(" + (i + 1) + ")[");
            Map<String, ArrayList<String>> places = (Map<String, ArrayList<String>>)array.get(i);

            for (String place : rooms) {
                System.out.print("\n    Place(" + place + ") [");
                ArrayList<String> names = places.get(place);

                for (int j = 0; j < names.size(); j++) {
                    System.out.print(names.get(j));
                    if(j < names.size() - 1) System.out.print(", ");
                }
                System.out.print("]");
            }
            System.out.print("\n  ]");
        }
        System.out.print("\n]\n");
    }

    public static ArrayList<Object> findDuos(){
        ArrayList<Object> list = new ArrayList<>();
        while(notUsedInShift.length()>0){
            Map<String, ArrayList<Person>> duo = notUsedInShift[0].findDuo(this.notUsedInShift);
            list.add(duo);
            notUsedInShift.remove(notUsedInShift[0]);
            notUsedInShift.remove(duo.get(1));
        }
    }

    public static byShift(String[] rooms){
        notUsedInShift = personList;
        ArrayList<Object> listShifts = new ArrayList<>();
        for (String rooms : rooms) {
            ArrayList<Object> list = new ArrayList<>();
            list = findDuos();
            list.add(map);
        }
    }
    public static void main(String[] args) {
        String[] employees = {"Marcus", "Lateefa", "Donald", "Rashad", "Quincy", "Mia"};
        String[] cafeteria = {"Lobby", "Dining Room", "Kitchen"};
        int[] shifts={0, 1, 2, 3, 4, 5, 6, 7};


        init(employees, cafeteria);
        ArrayList<Object> list = findDuos();
        printArrayList(list, cafeteria);
        
    }
}