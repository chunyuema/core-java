package com.chunyue.collection.list;

import com.chunyue.collection.comparator.LastDigitComparator;

import java.util.*;

public class ArrayListDemoMain {
    private static List<Integer> values = new ArrayList<>();

    public static void isEmptyAndSizeDemo(){
        // Check ArrayList empty
        System.out.println(values.isEmpty());
        values.add(36);
        values.add(44);
        values.add(55);
        values.add(2, 567); // adding at certain index
        System.out.println(values);
        System.out.println(values.size());
    }

    // iterator() method returns the iterator
    public static void iterationWithIterator(){
        List<String> names = new ArrayList<>();
        names.add("Chunyue");
        names.add("Chunyue01");
        names.add("Chunyue02");
        Iterator<String> itrator = names.iterator();
        while (itrator.hasNext()){
            System.out.println("The item is: " + itrator.next());
        }

        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);

        // Iterating using listIterator
        ListIterator<Integer> listIterator = values.listIterator();
        while (listIterator.hasNext()){
            int num = listIterator.next();
            System.out.println("The item is: " + num);
            System.out.println("Multiplying 10 right now.....");
            listIterator.set(num * 10);
        }

        while (listIterator.hasPrevious()){
            System.out.println("Iterating backwards with item: " + listIterator.previous());
        }

        // Iterating through the array list with for loop
        for (Integer i: values){
            System.out.println("The number is: " + i);
        }
    }

    // get() and set() method of array
    public static void getAndSet(){
        List<Integer> values = new ArrayList<>();
        values.add(34);
        values.add(22);
        values.add(46);
        System.out.println("Getting using get(): " + values.get(2));
        System.out.println("Setting using set(): " + values.set(2, 555));
        System.out.println("Getting again after setting: " + values.get(2));
    }

    // sorting of array list using Collections.sort()
    public static void sortingArrayList(){
        List<String> names = new ArrayList<>();
        names.add("Chunyue");
        names.add("Tracy");
        names.add("Crystal");
        System.out.println("Before sorting: " + names);
        Collections.sort(names);
        System.out.println("After sorting: " + names);
        Collections.reverse(names);
        System.out.println("Reverse the sorted array: " + names);
    }

    public static void main(String[] args) {
        // isEmptyAndSizeDemo();
        // iterationWithIterator();
        // getAndSet();
        sortingArrayList();

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
