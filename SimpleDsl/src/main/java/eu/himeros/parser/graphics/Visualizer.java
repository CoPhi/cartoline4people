/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.himeros.parser.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author federico
 */
public class Visualizer {

    public static void visualize(String title, Parser parser, ParseTree tree) {
        try {
            //show AST in GUI
            JFrame frame = new JFrame(title);
            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setScale(2);//scale a little
            panel.add(viewer);
            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setBounds(5, 5, 1195, 595);
            JPanel contentPane = new JPanel(null);
            contentPane.setPreferredSize(new Dimension(1200, 600));
            contentPane.add(scrollPane);
            frame.setContentPane(contentPane);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 630);
            frame.setVisible(true);
        } catch (HeadlessException ex) {
            ex.printStackTrace(System.err);
        }

    }

}
