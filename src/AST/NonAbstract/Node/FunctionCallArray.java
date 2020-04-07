package AST.NonAbstract.Node;

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
