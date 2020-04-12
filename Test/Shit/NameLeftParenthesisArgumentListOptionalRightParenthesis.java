package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractArgumentListOpt;
import AST.Visitor.Visitor;

public class NameLeftParenthesisArgumentListOptionalRightParenthesis extends ASTNode {
    public Identifier n;
    public AbstractArgumentListOpt aalo;

    public NameLeftParenthesisArgumentListOptionalRightParenthesis(Identifier n1, AbstractArgumentListOpt aalo1, int ln){
        super(ln);
        n = n1;
        aalo = aalo1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
