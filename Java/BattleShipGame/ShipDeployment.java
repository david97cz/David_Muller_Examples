package shipDeployment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import menu.Main_menu;

public class ShipDeployment {

	JPanel panelSD = new JPanel();
	JPanel panelSD2 = new JPanel();
	JFrame frameSD = new JFrame("Battleship Deployment");
	JFrame frameSD2 = new JFrame("Battleship Deployment");
	JButton exitButtonSD = new JButton("Save and Exit");
	JButton exitButtonSD2 = new JButton("Save and Exit");
	JButton resetButtonSD = new JButton("Reset");
	JButton resetButtonSD2 = new JButton("Reset");
	JButton horizontalButton = new JButton("horizontal/vertical");
	JButton horizontalButton2 = new JButton("horizontal/vertical");
	JLabel exitLabelSD = new JLabel("This button will close the programe");
	JLabel exitLabelSD2 = new JLabel("This button will close the programe");
	JLabel playerLabel1, playerLabel2;
	JButton[][] grid;
	JButton[][] grid2;

	int numberOfMovesSD = 0;
	int numberOfMovesSD2 = 0;
	// public int coordinateX;
	// public int coordinateY;

	public int setOfCoordinatesX1[] = {};
	public int setOfCoordinatesY1[] = {};
	public int setOfCoordinatesX2[] = {};
	public int setOfCoordinatesY2[] = {};
	private int nullSet[] = {};
	private boolean horizontal = true;
	private boolean horizontal2 = true;
	private int numberOfShips = 14;
	public boolean shipDeployed = false;
	public boolean shipDeployed2 = false;
	
	// generate new frame
	public void newCanvasSD(final int width, final int length) {

		// set panel
		panelSD = new JPanel();
		panelSD.setLayout(new GridLayout(width, 5));
		panelSD.setSize(100, 100);
		panelSD.setBounds(50, 50, 500, 400);
		panelSD.setBackground(Color.GRAY);

		// set frame
		frameSD.setSize(600, 500);
		frameSD.setLayout(null);

		// add button
		exitButtonSD.setBounds(0, 0, 200, 45);
		resetButtonSD.setBounds(200, 0, 100, 45);
		horizontalButton.setBounds(300, 0, 200, 45);

		// add label
		exitLabelSD.setBounds(100, 0, 300, 45);

		playerLabel1 = new JLabel("Player2");
		playerLabel1.setBounds(500, 0, 300, 50);

		exitButtonSD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (setOfCoordinatesX1.length == numberOfShips) {
					frameSD.dispose();
					shipDeployed = true;
					System.out.println("Deployment was saved");
				} else {
					System.out.println("not all ships were deployed");
				}
			}

		});

		resetButtonSD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				reset(width, length);
			}

		});

		horizontalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (horizontal == true) {
					horizontal = false;
					System.out.println("vertical");
				} else {
					horizontal = true;
					System.out.println("horizontal");
				}

			}

		});

		// add elements
		frameSD.add(panelSD);
		frameSD.add(exitButtonSD);
		frameSD.add(resetButtonSD);
		frameSD.add(playerLabel1);
		frameSD.add(horizontalButton);
		frameSD.setVisible(true);
	}

	public void newCanvasSD2(final int width, final int length) {

		// set panel
		panelSD2 = new JPanel();
		panelSD2.setLayout(new GridLayout(width, 5));
		panelSD2.setSize(100, 100);
		panelSD2.setBounds(50, 50, 500, 400);
		panelSD2.setBackground(Color.GRAY);

		// set frame
		frameSD2.setSize(600, 500);
		frameSD2.setLayout(null);

		// add button
		exitButtonSD2.setBounds(0, 0, 200, 45);
		resetButtonSD2.setBounds(200, 0, 100, 45);
		horizontalButton2.setBounds(300, 0, 200, 45);

		// add label
		exitLabelSD2.setBounds(100, 0, 300, 45);

		playerLabel2 = new JLabel("Player1");
		playerLabel2.setBounds(500, 0, 300, 50);

		exitButtonSD2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (setOfCoordinatesX2.length == numberOfShips) {
					frameSD2.dispose();
					shipDeployed2 = true;
					System.out.println("Deployment was saved");
				} else {
					System.out.println("Not all ships were deployed!");
				}
			}

		});

		resetButtonSD2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				reset2(width, length);
			}

		});

		horizontalButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (horizontal2 == true) {
					horizontal2 = false;
					System.out.println("vertical");
				} else {
					horizontal2 = true;
					System.out.println("horizontal");
				}

			}

		});

		// add elements
		frameSD2.add(panelSD2);
		frameSD2.add(exitButtonSD2);
		frameSD2.add(resetButtonSD2);
		frameSD2.add(playerLabel2);
		frameSD2.add(horizontalButton2);
		frameSD2.setVisible(true);
	}
	
	// generate grid of buttons
	public void deployShipCanvas(final int width, final int length) {
		grid = new JButton[width][length]; // allocate the size of grid
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				grid[x][y] = new JButton(); // creates new button
				grid[x][y].setFocusable(false);
				grid[x][y].setBackground(Color.WHITE);
				panelSD.add(grid[x][y]); // adds button to grid

			}
		}
	}
	// generate grid of buttons
	public void deployShipCanvas2(final int width, final int length) {
		grid2 = new JButton[width][length]; // allocate the size of grid
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				grid2[x][y] = new JButton(); // creates new button
				grid2[x][y].setFocusable(false);
				grid2[x][y].setBackground(Color.WHITE);
				panelSD2.add(grid2[x][y]); // adds button to grid

			}
		}
	}
	
	// set coordinates of deployed ships
	public void addCoordinates1(int n, int coordinatesX, int coordinatesY) {

		int newSetOfCoordinatesX[] = new int[n + 1];
		int newSetOfCoordinatesY[] = new int[n + 1];
		newSetOfCoordinatesX[n] = coordinatesX;
		newSetOfCoordinatesY[n] = coordinatesY;
		for (int i = 0; i < n; i++) {
			newSetOfCoordinatesX[i] = setOfCoordinatesX1[i];

			newSetOfCoordinatesY[i] = setOfCoordinatesY1[i];

		}

		setOfCoordinatesX1 = newSetOfCoordinatesX;
		setOfCoordinatesY1 = newSetOfCoordinatesY;

	}

	// set coordinates of deployed ships
	public void addCoordinates2(int n, int coordinatesX, int coordinatesY) {

		int newSetOfCoordinatesX2[] = new int[n + 1];
		int newSetOfCoordinatesY2[] = new int[n + 1];
		newSetOfCoordinatesX2[n] = coordinatesX;
		newSetOfCoordinatesY2[n] = coordinatesY;
		for (int i = 0; i < n; i++) {
			newSetOfCoordinatesX2[i] = setOfCoordinatesX2[i];
			newSetOfCoordinatesY2[i] = setOfCoordinatesY2[i];

		}

		setOfCoordinatesX2 = newSetOfCoordinatesX2;
		setOfCoordinatesY2 = newSetOfCoordinatesY2;

	}

	// deploy arbitrary ship
	public void ship(int numberOfMoves, int coordA, int coordB, int lengthOfShip, String type) {

		if (numberOfMovesSD == numberOfMoves) {

			// if (event.getSource()==grid[coordA][coordB]) {
			if (horizontal == true) {
				if (coordA <= Main_menu.sliderValue - lengthOfShip) {
					System.out.println("Ship type " + type + " was deployed:" + " x: " + coordA + " y: " + coordB);
					for (int l = 0; l < lengthOfShip; l++) {
						addCoordinates1(setOfCoordinatesX1.length, coordA + l, coordB);
						// addCoordinates(setOfCoordinatesX1.length, setOfCoordinatesX1, coordA + l,
						// setOfCoordinatesY1,
						// coordB);
						grid[coordA + l][coordB].setBackground(Color.GREEN);
						// numberOfShips += lengthOfShip;
					}
				} else {
					numberOfMovesSD -= 1;
				}
			}

			else {
				if (coordB <= Main_menu.sliderValue - lengthOfShip) {
					System.out.println("Ship type " + type + " was deployed:" + " x: " + coordA + " y: " + coordB);
					for (int l = 0; l < lengthOfShip; l++) {
						addCoordinates1(setOfCoordinatesY1.length, coordA, coordB + l);
						// addCoordinates(setOfCoordinatesY1.length, setOfCoordinatesX1, coordA,
						// setOfCoordinatesY1,
						// coordB + l);

						grid[coordA][coordB + l].setBackground(Color.GREEN);

					}

				} else {
					numberOfMovesSD -= 1;
				}
			}

		}
	}

	public void ship2(int numberOfMoves, int coordA, int coordB, int lengthOfShip, String type) {

		if (numberOfMovesSD2 == numberOfMoves) {

			// if (event.getSource()==grid[coordA][coordB]) {
			if (horizontal2 == true) {
				if (coordA <= Main_menu.sliderValue - lengthOfShip) {
					System.out.println("Ship type " + type + " was deployed:" + " x: " + coordA + " y: " + coordB);
					for (int l = 0; l < lengthOfShip; l++) {
						addCoordinates2(setOfCoordinatesX2.length, coordA + l, coordB);
						grid2[coordA + l][coordB].setBackground(Color.BLUE);
						// numberOfShips += lengthOfShip;
					}
				} else {
					numberOfMovesSD2 -= 1;
				}
			}

			else {
				if (coordB <= Main_menu.sliderValue - lengthOfShip) {
					System.out.println("Ship type " + type + " was deployed:" + " x: " + coordA + " y: " + coordB);
					for (int l = 0; l < lengthOfShip; l++) {
						addCoordinates2(setOfCoordinatesY2.length, coordA, coordB + l);
						grid2[coordA][coordB + l].setBackground(Color.BLUE);

					}

				} else {
					numberOfMovesSD2 -= 1;
				}
			}

		}
	}
	
	// deploy specific ship
	public void deployShip(final int width, final int length) {
		// grid=new JButton[width][length]; //allocate the size of grid
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				final int a = x;
				final int b = y;
				grid[a][b].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {

						numberOfMovesSD += 1;
						ship(1, a, b, 5, "Carrier");
						ship(2, a, b, 4, "Battleship");
						ship(3, a, b, 3, "Submarine");
						ship(4, a, b, 2, "Destroyer");

					}

				});

			}
		}

	}

	public void deployShip2(final int width, final int length) {
		// grid=new JButton[width][length]; //allocate the size of grid
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				final int a = x;
				final int b = y;
				grid2[a][b].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {

						numberOfMovesSD2 += 1;
						ship2(1, a, b, 5, "Carrier");
						ship2(2, a, b, 4, "Battleship");
						ship2(3, a, b, 3, "Submarine");
						ship2(4, a, b, 2, "Destroyer");

					}

				});

			}
		}

	}
	
	//reset button function
	public void reset(final int width, final int length) {
		numberOfShips = 0;
		setOfCoordinatesX1 = nullSet;
		setOfCoordinatesY1 = nullSet;
		numberOfMovesSD = 0;
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				grid[x][y].setBackground(Color.WHITE);
			}
		}

	}
	//reset button function
	public void reset2(final int width, final int length) {
		numberOfShips = 0;
		setOfCoordinatesX2 = nullSet;
		setOfCoordinatesY2 = nullSet;
		numberOfMovesSD2 = 0;
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				grid2[x][y].setBackground(Color.WHITE);
			}
		}

	}

}
