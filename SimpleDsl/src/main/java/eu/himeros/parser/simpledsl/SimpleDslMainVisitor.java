/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.himeros.parser.simpledsl;

import eu.himeros.parser.dom.DomStaticVisitor;
import eu.himeros.parser.SimpleDslBaseVisitor;
import eu.himeros.parser.SimpleDslParser;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.dom4j.Branch;
import org.dom4j.Node;
import org.dom4j.dom.DOMText;

/**
 *
 * @author federico
 */
public class SimpleDslMainVisitor extends SimpleDslBaseVisitor<Node> implements DomStaticVisitor {

    @Override
    public Node visitText(SimpleDslParser.TextContext ctx) {
        StringBuilder sb=new StringBuilder();
        ((Branch) visitChildren(ctx)).content().forEach((node) -> {
            sb.append(node.getText()).append(" ");
        });
        return new DOMText(sb.toString().trim());
        //return ((Branch) visitChildren(ctx)).content().get(0).detach();
    }

    @Override
    public Node visitTerminal(TerminalNode node) {
        if (node.getSymbol().getType() == SimpleDslParser.SPAN) {
            return new DOMText(node.getText());
        } else {
            return new DOMText("");
        }
    }

    @Override
    public Node visitChildren(RuleNode node) {
        return DomStaticVisitor.visitChildren(node, this);
    }

    @Override
    public Node aggregateResult(Node aggregate, Node nextResult) {
        return DomStaticVisitor.aggregateResult(aggregate, nextResult);
    }

    @Override
    protected Node defaultResult() {
        return DomStaticVisitor.defaultResult();
    }
}
