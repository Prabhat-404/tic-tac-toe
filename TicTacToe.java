import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {

    private JButton[][] buttons = new JButton[3][3];
    private boolean player1Turn = true;

    public TicTacToe() {
        super("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton)e.getSource();
        if(player1Turn) {
            buttonClicked.setText("X");
        } else {
            buttonClicked.setText("O");
        }
        buttonClicked.setEnabled(false);
        player1Turn = !player1Turn;
        if(checkForWin()) {
            JOptionPane.showMessageDialog(null, "Game over!");
            System.exit(0);
        }
        
    }

    public boolean checkForWin() {
        String[][] board = new String[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText();
            }
        }
        for(int i = 0; i < 3; i++) {
            if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals("")) {
                return true;
            }
            if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals("")) {
                return true;
            }
        }
        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals("")) {
            return true;
        }
        if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals("")) {
            return true;
        }
        return false;
    }
    private boolean checkForDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().equals("")) {
                    return false;
                }
            }
        }
            return true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
