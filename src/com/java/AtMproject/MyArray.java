package com.java.AtMproject;

public class MyArray {
    private Object[] items;
    private int itemCount;

    public MyArray(int size){
        items = new Object[size];
        itemCount =0;
    }

    public int getItemCount() {
        return itemCount;
    }

    //adding new item
    public void add(Object data){
        if(itemCount < items.length){
           items[itemCount] =data;
            itemCount++;
        }
    }

    //geting items
    public Object get(int index){
        if(index >= 0 && index < itemCount){
            return items[index];
        }
        return null;
    }
    //if no items
    public boolean isEmpty(){
        return itemCount == 0;
    }
    public void delete(int index){
        if(index >= 0 && index < itemCount){
            for(int i=index;i<itemCount;i++){
                items[i] = items[i+1];
            }
            itemCount--;
        }
    }
}



