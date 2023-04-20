public class PalindromeProduct {
    public static void main(String[] args) {
        // Initialize the largest palindrome to zero
        int largestPalindrome = 0;

        // Loop over all possible combinations of two 3-digit numbers
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                // Multiply the two numbers together
                int product = i * j;

                // Convert the product to a string
                String productString = String.valueOf(product);

                // Reverse the string using the StringBuilder class
                String reversedString = new StringBuilder(productString).reverse().toString();

                // Check if the original and reversed strings are equal, and if the product is greater than the current largest palindrome
                if (productString.equals(reversedString) && product > largestPalindrome) {
                    // If so, update the largest palindrome to be the current product
                    largestPalindrome = product;
                }
            }
        }

        // Print out the largest palindrome to the console
        System.out.println("The largest palindrome made from the product of two 3-digit numbers is: " + largestPalindrome);
    }
}

