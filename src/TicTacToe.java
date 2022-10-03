import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textFeild = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;

	TicTacToe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		textFeild.setBackground(new Color(25, 25, 25));
		textFeild.setForeground(new Color(25, 255, 0));
		textFeild.setFont(new Font("Ink Free", Font.BOLD, 75));
		textFeild.setHorizontalAlignment(JLabel.CENTER);
		textFeild.setText("Tic-Tac-Toe");
		textFeild.setOpaque(true);

		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);

		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(new Color(150, 150, 150));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		title_panel.add(textFeild);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);

		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (player1_turn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						player1_turn = false;
						textFeild.setText("O Turn");
						check();
					}
				} else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						player1_turn = true;
						textFeild.setText("X Turn");
						check();
					}
				}
			}
		}
	}

	public void firstTurn() {
		try {
			for(int i=0; i<9; i++) {
				buttons[i].setEnabled(false);
			}
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (random.nextInt(2) == 0) {
			player1_turn = true;
			textFeild.setText("X Turn");
			for(int i=0; i<9; i++) {
				buttons[i].setEnabled(true);
			}
		} else {
			player1_turn = false;
			textFeild.setText("O Turn");
			for(int i=0; i<9; i++) {
				buttons[i].setEnabled(true);
			}
		}
	}

	public void check() {
		// check X wins
		if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
			xWins(0, 1, 2);
		}else if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
			xWins(3, 4, 5);
		}else if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(6, 7, 8);
		}else if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(0, 3, 6);
		}else if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
			xWins(1, 4, 7);
		}else if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(2, 5, 8);
		}else if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
			xWins(0, 4, 8);
		}else if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
			xWins(2, 4, 6);
		}

		// check O wins
		if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
			oWins(0, 1, 2);
		}else if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
			oWins(3, 4, 5);
		}else if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(6, 7, 8);
		}else if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
			oWins(0, 3, 6);
		}else if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
			oWins(1, 4, 7);
		}else if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(2, 5, 8);
		}else if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
			oWins(0, 4, 8);
		}else if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
			oWins(2, 4, 6);
		}
	}

	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
			textFeild.setText("X Wins");
		}
	}

	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
			textFeild.setText("O Wins");
		}
	}
}
