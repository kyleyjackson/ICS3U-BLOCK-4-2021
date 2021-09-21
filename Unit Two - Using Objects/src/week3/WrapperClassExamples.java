package week3;

public class WrapperClassExamples {
    public static void main(String[] args) {
        Integer n = new Integer(7); // *Java deprecated since version 9
        Double d = new Double(3.4); // *Same thing here

        Integer num = 7; // *auto-boxing
        int x = new Integer(7); // *auto-unboxing

        int z = num.intValue();
        z = num;

        double f = d;
        f = d.doubleValue();

        System.out.println(Integer.MAX_VALUE);// *Max value for integers
        System.out.println(Integer.MAX_VALUE);// *Min value for integers

        System.out.println(Long.MAX_VALUE);// *Max value for longs
        System.out.println(Long.MAX_VALUE);// *Min value for longs
    }
}