package AST.NonAbstract.Node;

import AST.Abstract.AbstractPrimaryNoNewArray;
import AST.Visitor.Visitor;

public class FunctionCallArray extends AbstractPrimaryNoNewArray {
    public NameLeftParenthesisArgumentListOptionalRightParenthesis fc;

    public FunctionCallArray(NameLeftParenthesisArgumentListOptionalRightParenthesis fc1, int ln){
        super(ln);
        fc = fc1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
