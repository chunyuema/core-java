package com.chunyue.collection.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Movie implements Comparable<Movie>
{

    private int rating;
    private String name;

    public Movie(String name, int rating) {
        this.rating = rating;
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public int compareTo(Movie o) {
        return this.rating - o.rating;
    }

    @Override
    public String toString() {
        return "(" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                ')';
    }
}

class RatingComparator implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        if (o1.getRating() > o2.getRating()) return 1;
        else if (o2.getRating() > o1.getRating()) return -1;
        return 0;
    }
}

public class ComparableVsComparatorDemoMain {

    public static List<Movie> movieList;

    static {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Movie 1", 2));
        movieList.add(new Movie("Movie 2", 1));
        movieList.add(new Movie("Movie 3", 5));
        movieList.add(new Movie("Movie 4", 3));
        movieList.add(new Movie("Movie 5", 4));
    }

    public static void main(String[] args) {
        // comparableSort();
        // comparatorSort();
    }

    public static void comparableSort(){

        System.out.println(movieList);
        // Collections.sort can be used since Movie class implements the comparable interface
        Collections.sort(movieList);
        System.out.println(movieList);
    }

    public static void comparatorSort(){
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Movie 1", 2));
        movieList.add(new Movie("Movie 2", 1));
        movieList.add(new Movie("Movie 3", 5));
        movieList.add(new Movie("Movie 4", 3));
        movieList.add(new Movie("Movie 5", 4));
        System.out.println(movieList);
        // movieList can call the sort function and pass in the comparator object
        movieList.sort(new RatingComparator());
        System.out.println(movieList);
    }
}
