package com.chunyue.collection.list;

import com.chunyue.collection.comparator.LastDigitComparator;

import java.util.*;

public class ArrayListDemoMain {
    public static void main(String[] args) {
        // List interface extends the Collection interface
        List<Integer> values = new ArrayList<>();

        // Check ArrayList empty
        System.out.println(values.isEmpty());

        values.add(36);
        values.add(44);
        values.add(55);
        // Not possible with collection interface
        values.add(2, 567);
        System.out.println(values);

        // Get the size of the ArrayList
        System.out.println(values.size());

        // Iterating through the array list
        Iterator<Integer> itrator = values.iterator();
        while (itrator.hasNext()){
            System.out.println("The item is: " + itrator.next());
        }

        // Iterating using listIterator
        ListIterator<Integer> listIterator = values.listIterator();
        while (listIterator.hasNext()){ System.out.println("The item is: " + listIterator.next());}
        while (listIterator.hasPrevious()){
            System.out.println("Iterating backwards with item: " + listIterator.previous());
        }

        // Iterating through the array list with for loop
        for (Integer i: values){
            System.out.println("The number is: " + i);
        }

        // accessing the elements
        System.out.println("The value at position 3 is: " + values.get(2));
        values.set(2, 333);
        System.out.println("The value at position 3 is: " + values.get(2));


        // Not possible is values is a Collection
        // since index does not exist for Collection
        Collections.sort(values);
        System.out.println(values);
        Collections.reverse(values);
        System.out.println(values);

        // Use the comparator we defined to sort the list
        // The list will be sorted with the magnitude of the last digit
        Comparator<Integer> com = new LastDigitComparator();
        Collections.sort(values, com);
        System.out.println(values);

        // Define annnoynous comparator
        Comparator<Integer> com2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 100 > o2 % 100){
                    return 1;
                }
                return -1;
            }
        };
        Collections.sort(values, com2);
        System.out.println(values);

        // Define comparator through lambda comparison
        Collections.sort(values, (o1, o2) ->{
            return o1 * -1 > o2 * -1 ? 1 : -1;
        });
        System.out.println(values);

        // Stream API
        values.forEach(System.out::println);

        // Adding the elements from another list
        ArrayList<Integer> values2 = new ArrayList<>();
        values2.add(444);
        values2.add(568);
        values.addAll(values2);
        System.out.println(values);

        // Removing elements from the list
        values.remove(4);
        System.out.println(values);
        values.removeAll(values2);
        System.out.println(values);

        // ArrayList with objects
        List<Book> bookList = new ArrayList<>();
        Book b1 = new Book(1, "OOP", "CHUNYUE");
        Book b2 = new Book(2, "Design Paradigm", "ALEX");
        Book b3 = new Book(3, "Three Body Problem", "LCX");
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        System.out.println(bookList);
        Collections.sort(bookList, (book1, book2) -> {
            return (book1.getName().compareTo(book2.getName()));
        });
        System.out.println(bookList);
    }
}


class Book{
    private int id;
    private String name;
    private String author;

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
