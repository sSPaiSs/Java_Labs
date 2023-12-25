package Lab_2;

public class Lab_2{
     public static void main(String[] args) throws Exception
    {
        System.out.println("Tusk_2: " + Tusk_2(2.34, 0.756, 2.23, -1.653) + "\n");
        System.out.println("Tusk_12: " + Tusk_12(1.478, 9.26, 0.68, 2.24) + "\n");
        System.out.println("Tusk_22: " + Tusk_22(1.23, -0.34, 0.707, 2.312) + "\n");
    }

    public static double Tusk_2(double a,double b,double c,double d) throws Exception
    {
        double result = 0;

        double numerator = Math.pow(Math.E, d) + 3 * Math.log10(c);
        double denominator = Math.pow(Math.pow(b, c), 1.0/2);

        double firstPart = numerator / denominator;

        double secondPart = Math.abs(Math.atan(d));

        result = firstPart * secondPart;

        return result;
    }

    public static double Tusk_12(double a,double b,double c,double d) throws Exception
    {
        double result = 0;

        double firstPart = 6 * Math.pow(Math.sin(Math.abs(2 * a)), Math.log10(b));
        double secondPart = Math.pow(c * Math.cosh(-1 * d), 1.0/2);
        result = firstPart + secondPart;

        return result;
    }

    public static double Tusk_22(double a,double b,double c,double d) throws Exception
    {
        double result = 0;

        double firstPart = 4 * Math.sinh(Math.pow(Math.abs(a/b), 1.0/2));
        double secondPart = 3 * Math.asin(c);

        result = Math.pow(firstPart + secondPart, d);

        return result;
    }
}