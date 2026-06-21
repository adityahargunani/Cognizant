public class BinarySearch {
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