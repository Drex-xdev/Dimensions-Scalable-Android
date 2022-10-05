package fr.coding.zip;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.io.*;


public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException {

        //style ui
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        home ss = new home();
        ss.setVisible(true);


    }
}