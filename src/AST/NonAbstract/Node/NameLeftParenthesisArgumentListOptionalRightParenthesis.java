package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractArgumentListOpt;
import AST.NonAbstract.Nonterminal.Name;
import AST.Visitor.Visitor;

public class NameLeftParenthesisArgumentListOptionalRightParenthesis extends ASTNode {
    public Name n;
    public AbstractArgumentListOpt aalo;

    public NameLeftParenthesisArgumentListOptionalRightParenthesis(Name n1, AbstractArgumentListOpt aalo1, int ln){
        super(ln);
        n = n1;
        aalo = aalo1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
