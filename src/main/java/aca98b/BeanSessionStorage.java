package aca98b;

import java.beans.JavaBean;
import java.io.Serializable;
import java.util.LinkedList;

@JavaBean
public class BeanSessionStorage implements Serializable {
    private static final long serialVersionUID = 1L;

    private LinkedList<OneElement> tableArr = new LinkedList<OneElement>();

    public BeanSessionStorage(){
        this.tableArr = new LinkedList<OneElement>();
    }

    public BeanSessionStorage(LinkedList<OneElement> ms){
        this.tableArr = ms;
    }

    public void nullTable(){
        tableArr = new LinkedList<OneElement>();
    }

    public int sizeOfArr(){
        return tableArr.size();
    }

    public void addNewElement(OneElement el){
        tableArr.add(el);
    }

    public LinkedList<OneElement> getArr(){
        return tableArr;
    }

}
