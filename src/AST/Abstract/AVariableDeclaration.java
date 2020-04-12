package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AVariableDeclaration extends ASTNode {

    public AVariableDeclaration(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
