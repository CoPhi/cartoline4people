/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.himeros.parser.io;

import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 *
 * @author federico
 */
public class DomOutputter {
    public static void println(Node node, PrintStream printStream){
        StringWriter sw=new StringWriter();
        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter=new XMLWriter(sw,outputFormat);
        try{
            xmlWriter.write(node);
        }catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        printStream.println(sw.toString());
    }
    
    public static void println(ParseTree tree, Parser parser, PrintStream printStream){
        //Show AST in console
        printStream.println(tree.toStringTree(parser));
    }
    
}
