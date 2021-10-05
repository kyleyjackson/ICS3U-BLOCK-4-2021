package week2;

public class StringExamples {
    public static void main(String[] args) {
        String s1 = "max"; // *String literal
        String s2 = "fred"; // *String literal
        String s4 = new String("kyle"); // *String object
        String s3 = "max"; // *String literal
        String s5 = new String("max"); // *String object
        String x = "ABCDEF";
        String y = "ABC";

        System.out.println(s1.length()); // *.length() returns the number of characters in a String

        System.out.println(s1.equals(s5)); // * .equals() returns true only if both strings have the same character
                                           // * sequence, otherwise returns false
        System.out.println(s1.equals("Max")); // * false because "m" and "M" are different

        System.out.println("Brad".indexOf("ra")); // * returns 1, since that's where the first character in "ra" is
                                                  // located
        System.out.println(s2.indexOf("Red")); // * returns -1, r is not capital in "fred"

        System.out.println(x.substring(2)); // * starts at 2nd index (C) and returns everything after (CDEF)
        System.out.println(x.substring(2, 4)); // * starts at 2nd index (C) but ends before the second argument (E/4)
        System.out.println(x.substring(2, 3)); // * prints only C, as the second argument is not included
        System.out.println("Friday".substring(1, "Friday".length())); // * prints everything except x, since it starts
    }
}
