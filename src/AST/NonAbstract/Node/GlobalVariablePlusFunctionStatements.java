package AST.NonAbstract.Node;


import AST.List.FunctionStatementList;
import AST.List.GlobalVariableList;
import AST.Visitor.Visitor;

public class GlobalVariablePlusFunctionStatements extends FunctionStatementList {
    public GlobalVariableList v;
    public FunctionStatementList sl;

    public GlobalVariablePlusFunctionStatements(GlobalVariableList v, FunctionStatementList sl, int ln){
        super(ln);
        this.v = v;
        this.sl = sl;


    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
