import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Phonebook {

    private HashMap<String, ArrayList<String>> phones;

    public Phonebook() {
        this.phones = new HashMap<>();
    }

    public void add(String surname, String ... phone){
        if (phones.get(surname) != null){
            this.phones.get(surname).addAll(Arrays.asList(phone));
        }
        else {
            ArrayList<String> phone_temp = new ArrayList<>();
            phone_temp.addAll(Arrays.asList(phone));
            this.phones.put(surname, phone_temp);
        }
    }

    public ArrayList get(String surname){
        return this.phones.get(surname);
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "phones=" + phones +
                '}';
    }

    public static void main (String[]args){

        Phonebook  phonebook = new Phonebook();

        System.out.println(phonebook.toString());
        phonebook.add("Mother", "123", "789");
        System.out.println(phonebook.toString());
        phonebook.add("Mother", "456");
        System.out.println(phonebook.toString());
        phonebook.add("Father", "456");
        System.out.println(phonebook.toString());

        System.out.println(phonebook.get("Sister"));
        System.out.println(phonebook.get("Father"));
        System.out.println(phonebook.get("Mother"));
    }
}