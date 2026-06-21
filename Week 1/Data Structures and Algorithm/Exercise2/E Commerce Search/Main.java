import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Product " + (i + 1));

            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Category: ");
            String category = sc.nextLine();

            products[i] = new Product(id, name, category);
        }

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.print("\nEnter Product ID to search: ");
        int key = sc.nextInt();

        LinearSearch linear = new LinearSearch();
        Product result1 = linear.search(products, key);

        System.out.println("\nLinear Search Result:");
        if (result1 != null) {
            result1.display();
        } else {
            System.out.println("Product not found");
        }

        BinarySearch binary = new BinarySearch();
        Product result2 = binary.search(products, key);

        System.out.println("\nBinary Search Result:");
        if (result2 != null) {
            result2.display();
        } else {
            System.out.println("Product not found");
        }

        sc.close();
    }
}