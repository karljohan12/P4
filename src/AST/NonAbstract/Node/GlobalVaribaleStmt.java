package AST.NonAbstract.Node;

public class GlobalVaribaleStmt extends AbstractGlobalVariables {
    public GlobalVariable gv;

    public GlobalVaribaleStmt(GlobalVariable gv1, int ln){
        super(ln);
        gv = gv1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
