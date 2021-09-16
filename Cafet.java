public class Cafet{
    ArrayList<Person> personList;
    ArrayList<Person> notUsedInShift;
    public static void init(String[] persons, String[] rooms){
        for (String person : persons) {
            personList.add(new Person(person, persons, rooms));
        }
    }

    public static ArrayList<Object> findDuos(){
        ArrayList<Object> list = new ArrayList<>();
        while(notUsedInShift.length()>0){
            duo = notUsedInShift[0].findDuo(this.notUsedInShift);
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
        
    }
}