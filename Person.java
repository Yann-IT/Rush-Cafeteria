public class Person{
    String name;
    ArrayList<Person> duoUsed;
    ArrayList<String> roomsAvailable;

    public Person(name, String[] rooms){
        this.name = name;
        for (String room : rooms) {
            roomsAvailable.add(room);
        }
    }

    private isDuoAvailable(Person person){
        return (this.duoUsed.contains(person) ? false : true;
    }
    private isRoomAvailable(String room){
        return (this.roomUsed.contains(room) ? true : false;
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
            roomUsed.remove(room);
            return 0;
        }else{
            return -1;
        }
    }

    public Map<String, ArrayList<Person>> findDuo(Person[] persons){
        Map<String, ArrayList<Person>> map= new HashMap<String, ArrayList<Person>>();
        for (Person person : persons) {
            if(this.isDuoAvailable(person)){
                for (String room : this.roomsAvailable) {
                    if(person.isRoomAvailable(room)){
                        map.put(room, [this, person]);
                        this.useDuo(person);
                        this.useRoom(room);
                        return map;
                    }
                }
            }
        }
    }
}