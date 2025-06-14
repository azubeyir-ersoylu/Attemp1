import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrimeNumberApp extends JFrame {
    public PrimeNumberApp() {
        setTitle("Asal Sayı Bulucu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton button = new JButton("0'dan 1000'e kadar asal sayıları bul");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String primes = getPrimesUpTo(1000);
                textArea.setText(primes);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PrimeNumberApp().setVisible(true);
        });
    }
}
