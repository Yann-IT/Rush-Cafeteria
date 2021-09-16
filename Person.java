import java.util.*;

public class Person{
    String name;
    ArrayList<Person> duoUsed;
    ArrayList<String> roomsAvailable;

    public Person(String name, String[] rooms){
        this.name = name;
        for (String room : rooms) {
            roomsAvailable.add(room);
        }
    }

    private boolean isDuoAvailable(Person person){
        return (this.duoUsed.contains(person)) ? false : true;
    }
    private boolean isRoomAvailable(String room){
        return (this.roomsAvailable.contains(room)) ? true : false;
    }
    public int useDuo(Person person){
        if(this.isDuoAvailable(person)){
            duoUsed.add(person);
            return 0;
        }else{
            return -1;
        }
    }
    public int useRoom(String room){
        if(this.isRoomAvailable(room)){
            roomsAvailable.remove(room);
            return 0;
        }else{
            return -1;
        }
    }

    public Map<String, ArrayList<Person>> findDuo(ArrayList<Person> persons){
        Map<String, ArrayList<Person>> map= new HashMap<String, ArrayList<Person>>();
        ArrayList<Person> array = new ArrayList<Person>();
        for (Person person : persons) {
            if(this.isDuoAvailable(person)){
                for (String room : this.roomsAvailable) {
                    if(person.isRoomAvailable(room)){
                        array.add(this);
                        array.add(person);
                        map.put(room, array);
                        this.useDuo(person);
                        this.useRoom(room);
                        return map;
                    }
                }
            }
        }
        array.add(this);
        map.put(this.roomsAvailable.get(0), array);
        this.useRoom(this.roomsAvailable.get(0));
        return map;
    }
}