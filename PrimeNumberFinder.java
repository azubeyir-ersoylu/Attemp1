public class PrimeNumberFinder {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static String getPrimesUpTo(int max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= max; i++) {
            if (isPrime(i)) {
                sb.append(i).append(", ");
            }
        }
        if (sb.length() > 2) sb.setLength(sb.length() - 2); // Remove last comma
        return sb.toString();
    }
}
