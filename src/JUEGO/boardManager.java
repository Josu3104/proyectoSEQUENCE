/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JUEGO;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Josue Gavidia
 */
public class boardManager {

    JButton[][] lol = new JButton[10][10];
    String[][] cartas = {
        {"corner", "10S", "QS", "KS", "AS", "2D", "3D", "4D", "5D", "corner",},
        {"9S", "10H", "9H", "8H", "7H", "6H", "5H", "4H", "3H", "6H",},
        {"8S", "QH", "7D", "8D", "9D", "10D", "QD", "KD", "2H", "7D",},
        {"7S", "KH", "6D", "2C", "AH", "KH", "QH", "AD", "2S", "8D",},
        {"6S", "AH", "5D", "3C", "4H", "3H", "10H", "AC", "3S", "9D",},
        {"5S", "2C", "4D", "4S", "5H", "2H", "9H", "KS", "4S", "10D",},
        {"4S", "3C", "3D", "5C", "6H", "7H", "8H", "QC", "5S", "QD",},
        {"3S", "4C", "2D", "6C", "7C", "8C", "9C", "10C", "6S", "KD",},
        {"2S", "5C", "AS", "KS", "QS", "10S", "9S", "8S", "7S", "AD",},
        {"corner", "6C", "7C", "8C", "9C", "10C", "QC", "KC", "AC", "corner",}};

    public void initBoard(JPanel pan) {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                lol[row][col] = new JButton(row + "," + col);
                lol[row][col].setBounds((pan.getWidth() / 10) * col, (pan.getHeight() / 10) * row, (pan.getWidth() / 10), (pan.getHeight() / 10));
                lol[row][col].setName("Button_" + row + "_" + col);
                lol[row][col].setText(null);
                try {
                    String imagePath = "CARDS/" + cartas[row][col] + ".png";
                    ImageIcon neocard = new ImageIcon(imagePath);
                    Image Scalecard = neocard.getImage().getScaledInstance(lol[row][col].getWidth(), lol[row][col].getHeight(), Image.SCALE_SMOOTH);
                    neocard = new ImageIcon(Scalecard);
                    lol[row][col].setIcon(neocard);

                } catch (Exception e) {
                    System.out.println("Muere aqui" + row + " " + col);
                    System.out.println(e.getMessage());
                }
                pan.add(lol[row][col]);

            }
        }
    }

}
