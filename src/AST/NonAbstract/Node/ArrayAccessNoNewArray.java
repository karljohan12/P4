package AST.NonAbstract.Node;

public class ArrayAccessNoNewArray extends AbstractPrimaryNoNewArray {
    public ArrayAccess aa;

    public ArrayAccessNoNewArray(ArrayAccess aa1, int ln){
        super(ln);
        aa = aa1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
