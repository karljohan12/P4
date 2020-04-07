package AST.NonAbstract.Node;

import AST.Abstract.AbstractPrimaryNoNewArray;
import AST.NonAbstract.Nonterminal.FunctionCall;
import AST.Visitor.Visitor;

public class FunctionCallArray extends AbstractPrimaryNoNewArray {
    public FunctionCall fc;

    public FunctionCallArray(FunctionCall fc1, int ln){
        super(ln);
        fc = fc1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
