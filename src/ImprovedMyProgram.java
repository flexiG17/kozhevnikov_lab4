import java.util.Scanner;

public class ImprovedMyProgram {
    private static void printProgramDescription() {
        System.out.println("Данная программа поможет вам посчитать значение центростремительного ускорения с точностью до тысячных");
    }

    private static void printProgrammerDescription() {
        System.out.println("Кожевников Арсений\nСтудент магистратуры ИРИТ-РТФ\nАкадем группа: РИМ-140970");
    }

    private static int getNumberOfCalculations(Scanner scanner) {
        System.out.print("Сколько расчетов вы хотите выполнить? ");
        return scanner.nextInt();
    }

    private static double getSpeed(Scanner scanner, int index) {
        System.out.print("Скорость V(м/с) для " + (index + 1) + " расчета: ");
        return scanner.nextDouble();
    }

    private static double getRadius(Scanner scanner, int index) {
        System.out.print("Радиус кривизны окружности R(м) для " + (index + 1) + " расчета: ");
        return scanner.nextDouble();
    }

    private static String calculateCentripetalAccelerations() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder results = new StringBuilder();

        int count = getNumberOfCalculations(scanner);
        CentripetalAcceleration[] calculators = new CentripetalAcceleration[count];

        for (int i = 0; i < count; i++) {
            try {
                double speed = getSpeed(scanner, i);
                double radius = getRadius(scanner, i);
                calculators[i] = new CentripetalAcceleration(speed, radius);
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Введённые значения не могут быть строкой!");
                return "";
            }
        }

        results.append("Результаты расчетов центростремительного ускорения:\n");
        for (int i = 0; i < calculators.length; i++) {
            double acceleration = calculators[i].calculate();
            results.append(String.format("a для %d расчета = %.3f м/с^2\n", i + 1, acceleration));
        }

        return results.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет юный физик или просто преподаватель, проверяющий дз!");

        String programText = """
                Введите 1, чтобы выполнить расчет
                Введите 2, чтобы получить информацию о программе
                Введите 3, чтобы получить информацию о разработчике
                Введите 4, чтобы выйти из программы.
                """;

        System.out.println(programText);
        int programCode;

        while (true) {
            System.out.print("Для продолжения введите цифру от 1 до 4: ");
            programCode = scanner.nextInt();
            if (programCode < 1 || programCode > 4) {
                System.out.println("Введённое значение не может быть меньше 1 и больше 4!");
                continue;
            }
            switch (programCode) {
                case 1: {
                    System.out.print("Вы выбрали раздел для проведения расчётов\n");
                    String resultText = calculateCentripetalAccelerations();
                    System.out.print(resultText);
                }
                break;
                case 2:
                    printProgramDescription();
                    break;
                case 3:
                    printProgrammerDescription();
                    break;
                case 4: {
                    System.out.println("До свидания!");
                    return;
                }
            }
            System.out.println(programText);
        }
    }
}
