package com.chunyue.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo {

    private static void getClassDemo() throws Exception {
        Class clazz1 = Dog.class;
        System.out.println(clazz1);

        Class clazz2 = new Dog().getClass();
        System.out.println(clazz2);

        Class clazz3 = Class.forName("com.chunyue.reflect.Dog");
        System.out.println(clazz3);
    }

    private static void getAllConstructors() {
        Class clazz = Dog.class;
        // This will only get public constructors
        for (Constructor c : clazz.getConstructors()) {
            System.out.println(c.getName() + " takes " + c.getParameterCount() + " arguments.");
        }

        // This will get all constructors
        for (Constructor c : clazz.getDeclaredConstructors()) {
            System.out.println(c.getName() + " takes " + c.getParameterCount() + " arguments.");
        }
    }

    private static void createInstances() throws Exception {
        Class clazz = Class.forName("com.chunyue.reflect.Dog");

        // Use *public* argument constructor to create instance
        Dog dog = (Dog) clazz.getConstructor(String.class, int.class)
                .newInstance("Ray", 3);
        System.out.println(dog);

        // If use *private* constructor, need to use getDeclaredConstructors
        Constructor dogConstructor = clazz.getDeclaredConstructor(String.class);
        dogConstructor.setAccessible(true);
        Dog dog2 = (Dog) dogConstructor.newInstance("Ray");
        System.out.println(dog2);
    }

    private static void getPropertiesAndSetValue() throws Exception {
        Class clazz = Dog.class;
        Dog dog = (Dog) clazz.getDeclaredConstructor().newInstance();

        // get public properties => 0 because Dog class does not have public fields
        System.out.println(clazz.getFields().length);

        // get all properties
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(dog, "Tom");
            }
        }
        System.out.println(dog);
    }

    public static void main(String[] args) throws Exception {
        // getClassDemo();
        // getAllConstructors();
        // createInstances();
        getPropertiesAndSetValue();
    }
}
