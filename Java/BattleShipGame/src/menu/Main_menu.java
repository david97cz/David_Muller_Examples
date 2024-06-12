package menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import game.Game;
import scoringSystem.ScoringSystem;
import shipDeployment.ShipDeployment;

import javax.swing.event.*;

public class Main_menu {

	public static int sliderValue = 8;
	final JFrame frame;
	final JButton exitButton, authorButton, startGameButton, shipDeploymentButton, highScoreButton, rulesButton,
			chooseScoringSystemButton;
	final JLabel ruleLabel, sizeLabel, battleship_pic;

	final JSlider slider;
	public int highScore = 0;
	ShipDeployment shipDeployment;
	Game playGame;
	ScoringSystem scoring = new ScoringSystem();

	public Main_menu(String location) {
		shipDeployment = new ShipDeployment();
		playGame = new Game(shipDeployment);

		// set frame
		frame = new JFrame("Battleship Game Menu");
		frame.setSize(500, 400);
		frame.setLayout(null);

		// set picture
		battleship_pic = new JLabel(new ImageIcon("../Project_DM/bin/menu/" + location));
		battleship_pic.setBounds(250, 0, 256, 256);

		// set exitButton
		exitButton = new JButton("Exit");
		exitButton.setBounds(350, 300, 100, 45);

		// set authorButton
		authorButton = new JButton("Author");
		authorButton.setBounds(0, 300, 100, 45);

		// set startGameButton
		startGameButton = new JButton("Start game");
		startGameButton.setBounds(200, 295, 100, 55);
		startGameButton.setBackground(new Color(125, 125, 250));

		// set shipDeploymentButton
		shipDeploymentButton = new JButton("Choose ship placement");
		shipDeploymentButton.setBounds(0, 200, 200, 45);

		// set Buttons
		highScoreButton = new JButton("High Score");
		highScoreButton.setBounds(100, 300, 100, 45);
		rulesButton = new JButton("Rules");
		rulesButton.setBounds(0, 0, 100, 45);
		chooseScoringSystemButton = new JButton("Choose Scooring System");
		chooseScoringSystemButton.setBounds(0, 250, 200, 45);

		// set label
		ruleLabel = new JLabel("Read rules first!");
		ruleLabel.setBounds(110, 0, 300, 50);

		// set sizeLabel
		sizeLabel = new JLabel("Set size of battlefield");
		sizeLabel.setBounds(0, -20, 400, 200);

		// set JSlider
		slider = new JSlider(JSlider.HORIZONTAL, 6, 12, 8);
		slider.setBounds(0, 100, 200, 50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				sliderValue = slider.getValue();
				// System.out.println(value);
			}
		});

		// exitButton function
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
			}
		});

		// authorButton function
		authorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				JOptionPane.showMessageDialog(frame, "<html>Author: David Muller <br> r0827111 <html>");
			}
		});
		// highScoreButton function
		highScoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				highScore = playGame.getHighScore();
				JOptionPane.showMessageDialog(frame, "High Score: " + highScore);
			}
		});

		// startGameButton function
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (shipDeployment.shipDeployed == true && shipDeployment.shipDeployed2 == true) {
					playGame.play(slider.getValue(), slider.getValue());
				} else {
					System.out.println("Ship was not deployed");
				}
			}
		});

		// shipDeploymentButton function
		shipDeploymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				shipDeployment.newCanvasSD(slider.getValue(), slider.getValue());
				shipDeployment.newCanvasSD2(slider.getValue(), slider.getValue());
				shipDeployment.deployShipCanvas(slider.getValue(), slider.getValue());
				shipDeployment.deployShipCanvas2(slider.getValue(), slider.getValue());
				shipDeployment.deployShip(slider.getValue(), slider.getValue());
				shipDeployment.deployShip2(slider.getValue(), slider.getValue());
			}
		});

		// rules Button function
		rulesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(frame, "<html>1) Set size of the battlefield"
						+ " <br> 2) Push 'Choose Ship placement' and deploy all you ships (you can set if you want to deplay ship horizontally o vertically)"
						+ " <br> 3) Push 'Choose Scoring system' and set you scoring system"
						+ " <br>  -a) Scoring System 1 is: The points-per-hit are the same for each player"
						+ " <br>  -b) Scoring System 2 is: The points-per-hit are different for each player in order to compensate the player going second"
						+ " <br> 4) Push 'Start Game' and play the game"
						+ " <br> 5) Game will end when all ship will be sunk.<html>");
			}
		});

		// chooseScoringSystemButton function
		chooseScoringSystemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				scoring.scoringSystem();
				System.out.println("Choose Scoring System: ");

			}
		});

		// add elememts
		frame.getContentPane().add(battleship_pic);
		frame.add(ruleLabel);
		frame.add(authorButton);
		frame.add(exitButton);
		frame.add(startGameButton);
		frame.add(shipDeploymentButton);
		frame.add(highScoreButton);
		frame.add(rulesButton);
		frame.add(chooseScoringSystemButton);
		frame.add(sizeLabel);
		frame.add(slider);
		frame.setVisible(true);

	}

	// main method
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main_menu("Battleship_(Civ6).png");

			}
		});

	}
}
