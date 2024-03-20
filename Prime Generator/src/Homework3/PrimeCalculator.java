package Homework3;

public class PrimeCalculator {
    public static void main(String[] args) {
        new PrimeCalculator().primesTo(20);
        new PrimeCalculator().primesTo(2);
        new PrimeCalculator().primesTo(0);
    }

    void primesTo(int n) {
        try {
            // Queue Initialization
            ArrayQueue<Integer> numbers = new ArrayQueue<>(n);
            ArrayQueue<Integer> primes = new ArrayQueue<>(n);
            for (int i = 2; i <= n; i++) {
                numbers.enqueue(i);
            }
            // Primes Filter
            while (numbers.size() != 1) {
                int p = numbers.dequeue();
                primes.enqueue(p);
                int size = numbers.size();
                for (int i = 1; i <= size; i++) {
                    if (numbers.first() % p != 0) { // If prime
                        int newPrime = numbers.dequeue();
                        numbers.enqueue(newPrime);
                    } else { // If composite
                        numbers.dequeue();
                    }
                }
            }
            primes.enqueue(numbers.dequeue());
            // Print Primes
            System.out.println("Printing primes up to " + n + ":");
            int numberOfPrimes = primes.size();
            for (int i = 1; i <= numberOfPrimes; i++) {
                System.out.print(primes.dequeue());
                if (i != numberOfPrimes) {
                    System.out.print(", ");
                } else System.out.print(". \n \n");
            }
        } catch (Exception e) {  // Exception Handling
            System.out.println("Error: Input must be a number greater than or equal to 2.");
        }
    }
}