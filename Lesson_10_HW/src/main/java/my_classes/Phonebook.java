package my_classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {

    private Map<String, List<Long>> phonebookMap;

    public Phonebook(){
        this.phonebookMap = new HashMap<>();
    }

    /**
     * This method adds new pairs of key-value to Map Collection of this class
     * @param lastName String value with someone's Lastname
     * @param phoneNumber Long value with someone's phone number
     */
    public void add(String lastName, Long phoneNumber){

        if(phonebookMap.containsKey(lastName)){
            phonebookMap.get(lastName).add(phoneNumber);
        } else{
            List<Long> newNumber = new ArrayList<>();
            newNumber.add(phoneNumber);
            phonebookMap.put(lastName, newNumber);
        }
    }

    /**
     * This method allows to find phone numbers (values) by using Map keys
     * @param lastName the keys of Map
     * @return List of phone numbers (Long) or null if there is no received key
     */
    public List<Long> get(String lastName){

        if(phonebookMap.containsKey(lastName)){
            return phonebookMap.get(lastName);
        }

        return null;
    }

    @Override
    public String toString() {
        return "Телефонная книга содержит следующие номера:\n" + phonebookMap;
    }
}
