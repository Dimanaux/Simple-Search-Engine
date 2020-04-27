import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        if (x.contentEquals(new StringBuilder(x).reverse())) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}