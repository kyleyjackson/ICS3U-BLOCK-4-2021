package week6;

public class ComparingObjects {
    public static void main(String[] args) {
        // *Never use "==" in Java when comparing strings
        // *If an object isn't instantiated, the variable stores null
        // *Otherwise it'll store an address

        // *When "==" is used, you're comparing what's stored in the variable
        // *Which is the address (location in memory where the object is stored)

        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println(s1.equals(s2));
    }
}
