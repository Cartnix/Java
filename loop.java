import java.util.Scanner;

public class loop{

    public static double average(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }

        return (double) sum / arr.length;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Ввведите количество элементов: ");
        int numbers = input.nextInt();

        int arr[] = new int[numbers];

        for(int i = 0; i < numbers; i++)
        {
            System.out.print("Введите число "+ (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        double avg = average(arr);
        System.out.print("Среднее: " + avg);
    }
}