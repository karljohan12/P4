package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractFormalParamList extends ASTNode {
    public AbstractFormalParamList(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
