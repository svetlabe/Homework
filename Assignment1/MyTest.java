package reskillAssignmentOne;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MyTest {

    public static void main(String[] args) {
        ArrayList <Item> list = new ArrayList<>();
        HashSet<Item> set = new HashSet<>();
        Item item1 = new Item("Vegetables", 150.3, 120.5);
        list.add(item1);
        set.add(item1);
        Item item2 = new Item("Vegetables", 150.3, 120.5);
        list.add(item2);
        set.add(item2);
        Item item3 = new Item("Vegetables", 150.3, 120.5);
        list.add(item3);
        set.add(item3);

        System.out.println("Printing out list");
        for(Item i: list){
            System.out.println(i.toString());
        }

        System.out.println("Printing out set");
        for(Item i : set){
            System.out.println(i.toString());
        }

        HashSet<Item> newset = new HashSet<>();
        for (Item i: list){
            newset.add(i);
        }

        System.out.println("Printing newset");
        for(Item i : newset){
            System.out.println(i.toString());
        }





    }



}
