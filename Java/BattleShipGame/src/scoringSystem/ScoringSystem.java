package scoringSystem;

import java.awt.event.*;
import javax.swing.*;

public class ScoringSystem {

	JFrame frame = new JFrame("Scoring System");
	JButton exitButton = new JButton("Save and Exit");
	JButton system1 = new JButton("Scoring System 1");
	JButton system2 = new JButton("Scoring System 2");
	JLabel label = new JLabel("Choose Scoring System: ");

	public static boolean scoringSystem1 = true;

	public void scoringSystem() {

		frame.setSize(200, 300);
		frame.setLayout(null);

		exitButton.setBounds(0, 0, 200, 45);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
			}
		});

		system1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				scoringSystem1 = true;
				System.out.println("Scoring System 1 was set");
			}
		});

		system2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				scoringSystem1 = false;
				System.out.println("Scoring System 2 was set");
			}
		});

		system1.setBounds(0, 150, 200, 45);
		system2.setBounds(0, 200, 200, 45);
		label.setBounds(0, 100, 200, 45);

		frame.setVisible(true);
		frame.add(exitButton);
		frame.add(system1);
		frame.add(system2);
		frame.add(label);
	}
}
