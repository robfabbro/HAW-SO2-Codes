// write a program that prints "Hello World" 10 times

public class Main {
    public static void main(String[] args) {
        int number = 156;
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println("Sum of digits: " + sum);
    }
}

