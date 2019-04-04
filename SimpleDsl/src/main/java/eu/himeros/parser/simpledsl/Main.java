package eu.himeros.parser.simpledsl;

import eu.himeros.parser.graphics.Visualizer;
import eu.himeros.parser.SimpleDslLexer;
import eu.himeros.parser.SimpleDslParser;
import eu.himeros.parser.io.DomOutputter;
import eu.himeros.parser.io.FileInputter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;
import org.dom4j.Node;

/**
 *
 * @author federico
 */
public class Main {
    
    public Node parse(String text) throws Exception {
        SimpleDslLexer lexer = new SimpleDslLexer(CharStreams.fromString(text));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleDslParser parser = new SimpleDslParser(tokens);
        SimpleDslMainVisitor sdmv = new SimpleDslMainVisitor();
        ParseTree tree = parser.doc();
        Node result = sdmv.visit(tree);
        DomOutputter.println(result, System.out);
        DomOutputter.println(tree, parser, System.out);
        Visualizer.visualize("Cartoline", parser, tree);
        return result;
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.parse(FileInputter.fileToString(args[0]));
    }
}
