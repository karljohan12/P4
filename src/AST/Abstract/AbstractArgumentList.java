package AST.Abstract;


import AST.Visitor.Visitor;

abstract public class AbstractArgumentList extends ASTNode {
    public AbstractArgumentList(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
