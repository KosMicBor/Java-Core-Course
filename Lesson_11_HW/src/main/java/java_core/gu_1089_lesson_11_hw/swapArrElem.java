package java_core.gu_1089_lesson_11_hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class swapArrElem<T> {
    private List<T> outerArray = new ArrayList<>();
    private T firstElem;
    private T secondElem;

    public swapArrElem(T[] outerArray){
        this.outerArray = Arrays.asList(outerArray);
    }

    public List<T> switchArrayElements(T firstElem, T secondElem) throws NullPointerException{

        if(outerArray.contains(firstElem) && outerArray.contains(secondElem)){

            int firstElemIndex = outerArray.indexOf(firstElem);
            int secondElemIndex = outerArray.indexOf(secondElem);

            if (firstElemIndex == secondElemIndex){
                System.out.println("Попытка заменить элемент сам на себя приведёт к схлапыванию вселенной");
                return outerArray;
            }

            outerArray.set(firstElemIndex, secondElem);
            outerArray.set(secondElemIndex, firstElem);

            return outerArray;
        }

        return null;
    }
}



