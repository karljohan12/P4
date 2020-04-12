package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractFunctionBody;
import AST.Abstract.AbstractFunctionHeader;
import AST.Visitor.Visitor;

public class FunctionHeaderBody extends ASTNode {
    public AbstractFunctionHeader afh;
    public AbstractFunctionBody afb;

    public FunctionHeaderBody(AbstractFunctionHeader afh, AbstractFunctionBody afb, int ln) {
        super(ln);
        this.afh = afh;
        this.afb = afb;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
