package AST.NonAbstract.Node;

import AST.Abstract.AbstractBlockStmt;
import AST.Visitor.Visitor;

public class localVariableDeclBlockStmt extends AbstractBlockStmt {
    public localVariableDeclBlockStmt lvdbs;

    public localVariableDeclBlockStmt(localVariableDeclBlockStmt lvdbs, int ln) {
        super(ln);
        this.lvdbs = lvdbs;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
