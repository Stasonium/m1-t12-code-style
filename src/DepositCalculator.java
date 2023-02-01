import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d ) {
       double result = a * Math.pow((1 + y / 12), 12 * d);
       return roundValues(result, 2);
    } 
  
    double calculateSimplePercent(double doubleAmount, double doubleYearRate,
                                  int depositPeriod) {
        return roundValues(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double roundValues(double value, int places) {
       double scale= Math.pow(10, places);
       return Math.round(value*scale) / scale;
    }

    void userInputs()
    {
      int period;
      int action;
      int amount;
      double outVar = 0;

      Scanner scanner = new Scanner(System.in); 
      System.out.println("Введите сумму вклада в рублях:");
      amount = scanner.nextInt();

      System.out.println("Введите срок вклада в годах:");
      period = scanner.nextInt();
      System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, " +
              "2 - вклад с капитализацией:");
      action = scanner.nextInt();

      if (action == 1) {
          outVar = calculateSimplePercent(amount, 0.06, period);
      }
      else if (action == 2) {
          outVar = calculateComplexPercent(amount, 0.06, period);
      }
      System.out.println("Результат вклада: " + amount + " за " + period +
              " лет превратятся в " + outVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().userInputs();
    }
}

