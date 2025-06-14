import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrimeNumberGUI extends JFrame {
    public PrimeNumberGUI() {
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
                String primes = PrimeNumberFinder.getPrimesUpTo(1000);
                textArea.setText(primes);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PrimeNumberGUI().setVisible(true);
        });
    }
}
