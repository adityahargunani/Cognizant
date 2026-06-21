import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
    }
}

class LinearSearch {
    public Product search(Product[] products, int key) {
        for (Product product : products) {
            if (product.productId == key) {
                return product;
            }
        }
        return null;
    }
}

class BinarySearch {
    public Product search(Product[] products, int key) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (products[mid].productId == key) {
                return products[mid];
            }

            if (products[mid].productId < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

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