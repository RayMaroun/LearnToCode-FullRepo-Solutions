package com.learntocode;

public class JavaOOPExercise {
    public static void main(String[] args) {
        int sum1 = add(5,3);
        System.out.println(sum1);

        int sum2 = add(4,2);
        System.out.println(sum2);

        int sum3 = add(6,3);
        System.out.println(sum3);

        int sum4 = add(5,1);
        System.out.println(sum4);

        int sum5 = add(8,2);
        System.out.println(sum5);

        Person p1 = new Person("Raymond", "Maroun",55,200,"black");
        Person p2 = new Person("Daniel", "Jackson",16,200,"black");

        System.out.println(p1.getEyeColor());
        p1.walk(5);
        System.out.println(p1.getFullName());
        System.out.println(p2.getFullName());
        System.out.println(p1.getFirstNameCapital());
        System.out.println(p2.getFirstNameCapital());

        System.out.println("Eye Color Before: " + p1.getEyeColor());
        p1.changeEyeColor("red");
        System.out.println("Eye Color After: " + p1.getEyeColor());

        System.out.println(p1.isAdult());
        System.out.println(p2.isAdult());
        System.out.println(p1.firstName);

    }

    public static int add(int a, int b){
        int sum = a + b;
        return sum;
    }
}


