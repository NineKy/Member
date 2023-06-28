package org.example.domain;


public class Animal {

    String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void foo(){
        System.out.println("나는 부모 클래스 ");


    }
}
