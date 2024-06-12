package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import menu.Main_menu;
import scoringSystem.ScoringSystem;
import shipDeployment.ShipDeployment;

public class Game {
	public static int highScore;
	public static JFrame gameFrame1 = new JFrame("Battleship Game");
	public static JFrame gameFrame2 = new JFrame("Battleship Game");
	public int score[] = {0, 0};
	public int numberOfMoves[] = {0, 0};
	public int numberOfShips = 14;
	private int shipHit[] = {0, 0};
	JPanel panel[] = { new JPanel(), new JPanel() };
	JButton exitButton[] = { new JButton("Quit Game"), new JButton("Quit Game") };
	JButton scoreButton = new JButton("Score");
	JLabel exitLabel = new JLabel("This button will close the programe");
	JLabel playerLabel[] = new JLabel[2];
	JLabel turnLabel[] = new JLabel[2];
	JLabel labelScore[] = new JLabel[2];
	JButton[][] grid1;
	JButton[][] grid2;
	ShipDeployment shipDeployment;
	private int setX[];
	private int setY[];
	private int setX2[];
	private int setY2[];
	private boolean player1Turn;

	public Game(ShipDeployment shipDeployment) {
		this.shipDeployment = shipDeployment;
	}
	
	// new frame for player
	public void player(final int width, final int length, String playerX, final JFrame gameFrame, int playerId) {
		// set panel

		panel[playerId].setLayout(new GridLayout(width, 5));
		panel[playerId].setSize(100, 100);
		panel[playerId].setBounds(50, 50, 500, 400);
		panel[playerId].setBackground(Color.GRAY);

		// set frame
		// gameFrame = new JFrame("Battleship Game");
		gameFrame.setSize(600, 600);
		gameFrame.setLayout(null);

		// add button

		exitButton[playerId].setBounds(0, 0, 100, 45);
		scoreButton.setBounds(200, 0, 100, 45);

		// set label

		exitLabel.setBounds(100, 0, 300, 50);
		playerLabel[playerId] = new JLabel(playerX);
		playerLabel[playerId].setBounds(500, 0, 300, 50);

		turnLabel[playerId] = new JLabel("Turn: " + numberOfMoves[playerId]);
		turnLabel[playerId].setBounds(100, 0, 300, 50);

		labelScore[playerId] = new JLabel("Score: " + score[playerId]);
		labelScore[playerId].setBounds(400, 0, 300, 50);

		exitButton[playerId].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				gameFrame1.dispose();
				gameFrame2.dispose();
				grid1 = new JButton[][] {};
				grid2 = new JButton[][] {};
				//numberOfMoves = new int[] { 0, 0 };
				score[0] = 0;
				score[1] = 0;
				panel[0] = new JPanel();
				panel[1] = new JPanel();
				return;
			}
		});

		// add elements
		gameFrame.add(panel[playerId]);
		gameFrame.add(exitButton[playerId]);
		gameFrame.add(turnLabel[playerId]);
		gameFrame.add(playerLabel[playerId]);
		gameFrame.add(labelScore[playerId]);
		gameFrame.setVisible(true);

		if (playerId == 0) {
			player1Battlefield(Main_menu.sliderValue, Main_menu.sliderValue, shipDeployment, panel[playerId]);
			player1Move(Main_menu.sliderValue, Main_menu.sliderValue, shipDeployment);
		} else {
			player2Battlefield(Main_menu.sliderValue, Main_menu.sliderValue, shipDeployment, panel[playerId]);
			player2Move(Main_menu.sliderValue, Main_menu.sliderValue, shipDeployment);
		}

	}

	// generate grid of buttons for player1
	public void player1Battlefield(final int width, final int length, ShipDeployment shipDeployment, JPanel panel) {

		grid1 = new JButton[width][length]; // allocate the size of grid

		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				grid1[x][y] = new JButton(); // creates new button
				grid1[x][y].setFocusable(false);
				grid1[x][y].setBackground(new Color(215, 215, 215));
				panel.add(grid1[x][y]); // adds button to grid
			}
		}
	}
	
	// generate grid of buttons for player2
	public void player2Battlefield(final int width, final int length, ShipDeployment shipDeployment, JPanel panel) {

		grid2 = new JButton[width][length]; // allocate the size of grid

		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				grid2[x][y] = new JButton(); // creates new button
				grid2[x][y].setFocusable(false);
				grid2[x][y].setBackground(new Color(215, 215, 215));
				panel.add(grid2[x][y]); // adds button to grid
			}
		}
	}
	
	// action when player 1 push the button
	public void player1Move(final int width, final int length, ShipDeployment shipDeployment) {

		setX = shipDeployment.setOfCoordinatesX1;
		setY = shipDeployment.setOfCoordinatesY1;
		// final int nShips = numberOfShips;
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				final int a = x;
				final int b = y;

				grid1[a][b].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						if (shipHit[0] >= numberOfShips) {
							gameFrame1.dispose();
							gameFrame2.dispose();
							System.out.println("Player 1 has won!");
						}
						if (player1Turn == false) {
							//move(numberOfMoves[0], turnLabel[0]);
							move1();
							setTurn();
							System.out.println("Player2 Turn");
							for (int i = 0; i < numberOfShips; i++) {
								if (event.getSource() == grid1[a][b]) {
									if (a == setX[i] && b == setY[i]) {
										grid1[a][b].setBackground(Color.RED);
										grid1[a][b].setEnabled(false);
										score1Add();
										shipHit[0]++;
										break;
									} else {
										grid1[a][b].setBackground(Color.CYAN);
										grid1[a][b].setEnabled(false);
									}
								}
							}
						}

					}
				});
			}
		}
	}
	
	// action when player 2 push the button
	public void player2Move(final int width, final int length, final ShipDeployment shipDeployment) {

		setX2 = shipDeployment.setOfCoordinatesX2;
		setY2 = shipDeployment.setOfCoordinatesY2;
		// final int nShips = numberOfShips;
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				final int a = x;
				final int b = y;
				if (player1Turn == false) {
					grid2[a][b].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent event) {
							if (shipHit[1] >= numberOfShips) {
								gameFrame1.dispose();
								gameFrame2.dispose();
								System.out.println("Player 2 has won!");
							}
							if (player1Turn == true) {
								//move(numberOfMoves[1], turnLabel[1]);
								move2();
								setTurn();
								System.out.println("Player1 Turn");
								for (int i = 0; i < numberOfShips; i++) {
									if (event.getSource() == grid2[a][b]) {
										if (a == setX2[i] && b == setY2[i]) {
											grid2[a][b].setBackground(Color.RED);
											grid2[a][b].setEnabled(false);
											score2Add();
											shipHit[1]++;
											break;
										} else {
											grid2[a][b].setBackground(Color.CYAN);
											grid2[a][b].setEnabled(false);
										}
									}
								}
							}

						}
					});
				}
			}
		}
	}

	//add score to player1 (depending on scoring system)
	public void score1Add() {
		// int scoreS = score;
		if (ScoringSystem.scoringSystem1 == true) {
			score[0] += 10;
		} else {
			score[0] += 10;
		}
		labelScore[0].setText("Score: " + score[0]);

	}
	//add score to player 2 (depending on scoring system)
	public void score2Add() {
		// int scoreS = score;
		if (ScoringSystem.scoringSystem1 == true) {
			score[1] += 10;
		} else {
			score[1] += 11;
		}
		labelScore[1].setText("Score: " + score[1]);

	}

	// add turn
	/*
	private void move(int numberOfMoves, JLabel turnLabel) {
		numberOfMoves++;
		turnLabel.setText("Turn: " + numberOfMoves);
	}
	*/
	
	private void move1() {
		numberOfMoves[0]++;
		turnLabel[0].setText("Turn: " + numberOfMoves[0]);
	}
	private void move2() {
		numberOfMoves[1]++;
		turnLabel[1].setText("Turn: " + numberOfMoves[1]);
	}

	// launch the game
	public void play(final int width, final int length) {
		player(width, length, "Player 1", Game.gameFrame1, 0);
		player(width, length, "Player 2", Game.gameFrame2, 1);
	}

	// switch between player1 and player2 turn
	private void setTurn() {
		if (player1Turn) {
			this.player1Turn = false;
		} else {
			this.player1Turn = true;
		}
	}

	// get high score and save
	public int getHighScore() {

		if (score[0] > highScore) {
			highScore = score[0];
		}
		if (score[1] > highScore) {
			highScore = score[1];
		}
		return highScore;
	}
}
