package aca98b;

import java.beans.JavaBean;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@JavaBean
public class BeanSessionStorage implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<OneElement> tableArr;

    public BeanSessionStorage(){
        this.tableArr = new LinkedList<OneElement>();
    }

    public BeanSessionStorage(List<OneElement> ms){
        this.tableArr = new LinkedList<>(ms);
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

    public List<OneElement> getArr(){
        return new LinkedList<>(tableArr);
    }
}

