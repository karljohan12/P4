package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class SwitchBlock extends ASTNode {

    public SwitchBlock(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
