import java.util.Scanner;

class toh {
    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move the disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move the disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int num_of_disks = scanner.nextInt();
        scanner.close();
        towerOfHanoi(num_of_disks, 'S', 'A', 'D');
    }
}