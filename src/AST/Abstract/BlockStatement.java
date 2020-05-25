package AST.Abstract;

import Interfaces.IVisitor;

abstract public class BlockStatement extends AFunction {

    public BlockStatement(int ln) {
        super(ln);
    }
    public abstract void accept(IVisitor v);
}
