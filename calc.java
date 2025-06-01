import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            pro(islem(scanner), ikiSayiAl(scanner), scanner);
            System.out.print("Devam etmek istiyor musunuz? (e/h): ");
            char devam = scanner.next().toLowerCase().charAt(0);
            if (devam != 'e') {
                System.out.println("Program sonlandırıldı.");
                break;
            }
        }
        scanner.close();
    }

    // Hesaplama süreci burada gerçekleşiyor.
    public static void pro(char a, double[] d, Scanner scanner) {
        double x = 0;
        switch (a) {
            case '+':
                x = d[0] + d[1];
                break;
            case '-':
                x = d[0] - d[1];
                break;
            case '/':
                d[1] = payda_kontrol(d[1], scanner);
                x = d[0] / d[1];
                break;
            case '*':
                x = d[0] * d[1];
                break;
            default:
                System.out.println("Geçersiz işlem.");
                return;
        }
        System.out.println("Sonucunuz : " + x);
    }

    // Payda sıfır olma durumu kontrol mekanizması
    public static double payda_kontrol(double c, Scanner scanner) {
        while (c == 0) {
            System.out.print("Payda 0 olamaz, yeni değer girin: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Geçersiz giriş. Lütfen sayı girin: ");
                scanner.next();
            }
            c = scanner.nextDouble();
        }
        return c;
    }

    // Sayılar alınıyor
    public static double[] ikiSayiAl(Scanner scanner) {
        double a = 0, b = 0;

        System.out.print("Birinci sayıyı girin: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Geçersiz giriş. Lütfen sayı girin: ");
            scanner.next();
        }
        a = scanner.nextDouble();

        System.out.print("İkinci sayıyı girin: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Geçersiz giriş. Lütfen sayı girin: ");
            scanner.next();
        }
        b = scanner.nextDouble();

        return new double[]{a, b};
    }

    // İşlem seçimi burada gerçekleştiriliyor
    public static char islem(Scanner scanner) {
        while (true) {
            System.out.print("İşlem seç (+), (-), (/), (*): ");
            String input = scanner.next();
            if (input.length() == 1) {
                char x = input.charAt(0);
                if (x == '+' || x == '-' || x == '/' || x == '*') {
                    return x;
                }
            }
            System.out.println("Geçersiz giriş, lütfen tekrar deneyin.");
        }
    }
}
