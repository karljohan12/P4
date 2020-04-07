package AST.NonAbstract.Node;

public class localVariableDeclBlockStmt extends AbstractBlockDeckBlockStmt {
    public localVariableDeclBlockStmt lvdbs;

    public localVariableDeclBlockStmt(localVariableDeclBlockStmt lvdbs, int ln) {
        super(ln);
        this.lvdbs = lvdbs;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
