package my_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Duplicates {
    private static final int ZERO_VAL = 0;
    private int duplicatesCounter = 0;
    private String duplicatedWord = "";

    public Duplicates(){
        // empty default Constructor
    }

    /**
     * This method counts quantity of duplicates of words
     * @param someOuterArray Some one-dimensional array
     * @param maxArrSize Max possible array size
     */
    public void countDuplicates(String[] someOuterArray, int maxArrSize) {
        ArrayList<String> arrayListForChecking = new ArrayList<>(maxArrSize);
        arrayListForChecking.addAll(Arrays.asList(someOuterArray));

        System.out.println(arrayListForChecking);

        for (int i = ZERO_VAL; i < arrayListForChecking.size(); i++) {
            duplicatedWord = arrayListForChecking.get(i);

            for (int j = ZERO_VAL; j < arrayListForChecking.size(); j++) {

                if (i == j) {
                    continue;
                } else if (arrayListForChecking.get(j).equals(duplicatedWord)) {
                    duplicatesCounter++;
                    arrayListForChecking.set(j, "Duplicate");
                }

            }
            //There are original word and its duplicates. The method prints message about specifically about duplicates
            if (duplicatesCounter > ZERO_VAL && !duplicatedWord.equals("Duplicate")) {
                StringBuilder builder = new StringBuilder();
                builder.append("Слово \"");
                builder.append(duplicatedWord);
                builder.append("\" имеет дублекаты в количестве ");
                builder.append(duplicatesCounter);
                System.out.println(builder);
            }

            duplicatesCounter = ZERO_VAL;
        }
    }

    /**
     * This methods checks if there are duplicates of words in the array and remove them
     * @param someOuterArray Some one-dimensional array
     * @param maxArrSize Max possible array size
     * @return HashSet Collection
     */
    public HashSet<String> CheckAndRemoveDuplicates(String[] someOuterArray, int maxArrSize){
        HashSet<String> uniqueSuperHaroes = new HashSet<>(maxArrSize);

        uniqueSuperHaroes.addAll(Arrays.asList(someOuterArray));

        return uniqueSuperHaroes;
    }
}
