package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractFormalParamListOpt extends ASTNode {
    public AbstractFormalParamListOpt(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
