package org.example.domain;

public class Person extends Animal{

    static String name = "kdshim";

    @Override
    public void foo() {
        System.out.println("나는 자식이라 부모꺼 쓰기싫어!! ");
    }


    public static void printName(){
        System.out.println(name);
    }

}
