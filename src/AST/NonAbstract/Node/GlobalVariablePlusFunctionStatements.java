package AST.NonAbstract.Node;


import AST.Abstract.Initial;
import AST.List.FunctionStatementList;
import AST.List.GlobalVariableList;
import Interfaces.IVisitor;

public class GlobalVariablePlusFunctionStatements extends Initial {
    public GlobalVariableList v;
    public FunctionStatementList sl;

    public GlobalVariablePlusFunctionStatements(GlobalVariableList v, FunctionStatementList sl, int ln){
        super(ln);
        this.v = v;
        this.sl = sl;


    }

    public void accept(IVisitor v) {
        v.visit(this);
    }
}
