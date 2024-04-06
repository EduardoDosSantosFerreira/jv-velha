import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JogoDaVelha extends JFrame implements ActionListener {
    private JButton[] buttons = new JButton[9];
    private int count = 0;
    private boolean win = false;
    private String xo = "";

    public JogoDaVelha() {
        super("Jogo da Velha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
        setSize(300, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        count++;
        JButton buttonClicked = (JButton)e.getSource();
        buttonClicked.setFont(new Font("Arial", Font.BOLD, 50));
        
        if (count % 2 == 0) {
            buttonClicked.setText("O");
            xo = "O";
        } else {
            buttonClicked.setText("X");
            xo = "X";
        }

        buttonClicked.setEnabled(false);
        checkWinner();
    }

    public void checkWinner() {
        if (checkWinCondition(0, 1, 2) || checkWinCondition(3, 4, 5) || checkWinCondition(6, 7, 8) ||
            checkWinCondition(0, 3, 6) || checkWinCondition(1, 4, 7) || checkWinCondition(2, 5, 8) ||
            checkWinCondition(0, 4, 8) || checkWinCondition(2, 4, 6)) {
            JOptionPane.showMessageDialog(null, xo + " venceu!");
            win = true;
            for (int i = 0; i < 9; i++)
                buttons[i].setEnabled(false);
        } else if (count == 9 && !win) {
            JOptionPane.showMessageDialog(null, "Empate!");
        }
    }

    public boolean checkWinCondition(int a, int b, int c) {
        return buttons[a].getText().equals(buttons[b].getText()) && 
               buttons[b].getText().equals(buttons[c].getText()) &&
               !buttons[a].getText().equals("");
    }

    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
