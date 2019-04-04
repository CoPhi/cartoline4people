/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.himeros.parser.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author federico
 */
public class FileInputter {

    public static String fileToString(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.lines().forEach(line -> {
                sb.append(line).append('\n');
            });
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return sb.toString();
    }
}
