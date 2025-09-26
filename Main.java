import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Первое число: ");
        int number_one = scanner.nextInt();

        System.out.print("Второе число: ");
        int number_two = scanner.nextInt();

        System.out.println("Выберите операцию (+, -, /, *): ");
        String operation = scanner.next();

        switch(operation){
            case "+":
                System.out.println(number_one + number_two);
                break;
            case "-":
                System.out.println(number_one - number_two);
                break;
            case "^":
                System.out.println(number_one * number_two);
                break;
            case "/":
                System.out.println(number_one / number_two);
                break;
            default: 
                System.err.println("Вы ввели неверное действие");
        }
    }
}
