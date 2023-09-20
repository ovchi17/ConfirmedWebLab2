package aca98b;

import java.util.LinkedList;

public class Elements {
    private static LinkedList<OneElement> tableArr = new LinkedList<OneElement>();

    public static void nullTable(){
        tableArr = new LinkedList<OneElement>();
    }

    public static int sizeOfArr(){
        return tableArr.size();
    }

    public static void addNewElement(OneElement el){
        tableArr.add(el);
    }

    public static LinkedList<OneElement> getArr(){
        return tableArr;
    }
}


