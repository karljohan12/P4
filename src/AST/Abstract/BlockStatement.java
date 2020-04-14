package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class BlockStatement extends AFunction {

    public BlockStatement(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
