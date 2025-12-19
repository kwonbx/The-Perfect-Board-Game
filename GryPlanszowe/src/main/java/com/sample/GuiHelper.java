package com.sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;

public class GuiHelper {
	
	private static final Map<String, String> images = Map.ofEntries(
		Map.entry("Candy Land", "images/Candy_Land.jpg"),
	    Map.entry("Sorry!", "images/Sorry.jpg"),
	    Map.entry("Life", "images/Life.jpg"),
	    Map.entry("Mouse Trap", "images/Mouse_Trap.jpg"),
	    Map.entry("Operation", "images/Operation.jpg"),
	    Map.entry("Monopoly", "images/Monopoly.jpg"),
	    Map.entry("Yahtzee!", "images/Yahtzee.jpg"),
	    Map.entry("Small World", "images/Small_World.jpg"),
	    Map.entry("Forbidden Island", "images/Forbidden_Island.jpg"),
	    Map.entry("Axis and Allies", "images/Axis_and_Allies.jpg"),
	    Map.entry("Le Havre", "images/Le_Havre.jpg"),
	    Map.entry("Game of Thrones", "images/Game_of_Thrones.jpg"),
	    Map.entry("Risk", "images/Risk.jpg"),
	    Map.entry("Warhammer", "images/Warhammer.jpg"),
	    Map.entry("Magic", "images/Magic.jpg"),
	    Map.entry("Battlestar Galactica", "images/Battlestar_Galactica.jpg"),
	    Map.entry("Cosmic Encounter", "images/Cosmic_Encounter.jpg"),
	    Map.entry("Arkham Horror", "images/Arkham_Horror.jpg"),
	    Map.entry("Shadows over Camelot", "images/Shadows_over_Camelot.jpg"),
	    Map.entry("Last Night on Earth", "images/Last_Night_on_Earth.jpg"),
	    Map.entry("Pandemic", "images/Pandemic.jpg"),
	    Map.entry("Dungeon Run", "images/Dungeon_Run.jpg"),
	    Map.entry("Rummoli", "images/Rummoli.jpg"),
	    Map.entry("Cribbage", "images/Cribbage.jpg"),
	    Map.entry("Go", "images/Go.jpg"),
	    Map.entry("Chess", "images/Chess.jpg"),
	    Map.entry("Backgammon", "images/Backgammon.jpg"),
	    Map.entry("Twister", "images/Twister.jpg"),
	    Map.entry("Ca$h'N'Gun$", "images/Cash_n_Guns.jpg"),
	    Map.entry("Cranium", "images/Cranium.jpg"),
	    Map.entry("Beyond Balderdash", "images/Beyond_Balderdash.jpg"),
	    Map.entry("Wits and Wagers", "images/Wits_and_Wagers.jpg"),
	    Map.entry("Jenga (DK Edition)", "images/Jenga_DK_Edition.jpg"),
	    Map.entry("Taboo", "images/Taboo.jpg"),
	    Map.entry("Trivial Persuit", "images/Trivial_Persuit.jpg"),
	    Map.entry("Scrabble", "images/Scrabble.jpg"),
	    Map.entry("Steam", "images/Steam.jpg"),
	    Map.entry("Ticket to Ride", "images/Ticket_to_Ride.jpg"),
	    Map.entry("Qwirkle", "images/Qwirkle.jpg"),
	    Map.entry("Scattergories", "images/Scattergories.jpg"),
	    Map.entry("Agricola", "images/Agricola.jpg"),
	    Map.entry("Puerto Rico", "images/Puerto_Rico.jpg"),
	    Map.entry("Domaine", "images/Domaine.jpg"),
	    Map.entry("Cities and Knights", "images/Cities_and_Knights.jpg"),
	    Map.entry("7 Wonders", "images/Seven_Wonders.jpg"),
	    Map.entry("Dominion", "images/Dominion.jpg"),
	    Map.entry("Settlers of Catan", "images/Settlers_of_Catan.jpg"),
	    Map.entry("Pillars of the Earth", "images/Pillars_of_the_Earth.jpg"),
	    Map.entry("Carcassonne", "images/Carcassonne.jpg")
		);


    private JFrame frame;

    public GuiHelper(JFrame frame) {
        this.frame = frame;
    }

    public void showResult(String gameName) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel textLabel = new JLabel("You should play '" + gameName + "'");
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        String imagePath = images.get(gameName);
        ImageIcon icon = new ImageIcon(
            getClass().getClassLoader().getResource(imagePath)
        );
        
        Image scaledImage = icon.getImage().getScaledInstance(300, -1, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(textLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(imageLabel);

        JOptionPane.showMessageDialog(frame, panel, "Result", JOptionPane.PLAIN_MESSAGE);
    }


    public String ask(String questionText, ArrayList<String> options) {
        final String[] selectedAnswer = { options.get(0) };

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel(questionText));

        ButtonGroup group = new ButtonGroup();
        ArrayList<JRadioButton> buttons = new ArrayList<>();

        for (String text : options) {
            JRadioButton radioButton = new JRadioButton(text);
            
            radioButton.addActionListener(e -> {
                selectedAnswer[0] = text;
            });

            if (text.equals(options.get(0))) {
                radioButton.setSelected(true);
            }

            group.add(radioButton);
            buttons.add(radioButton);
            panel.add(radioButton);
        }

        JOptionPane.showConfirmDialog(frame, panel, "Question", JOptionPane.DEFAULT_OPTION);

        return selectedAnswer[0];
    }
}