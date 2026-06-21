import java.util.Scanner;

public class Main {

    public static double predictValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }

        return predictValue(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter annual growth rate (%): ");
        double growthRate = sc.nextDouble() / 100;

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double futureValue = predictValue(currentValue, growthRate, years);

        System.out.printf("Predicted Future Value: %.2f", futureValue);

        sc.close();
    }
}