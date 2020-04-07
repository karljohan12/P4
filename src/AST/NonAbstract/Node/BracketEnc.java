package AST.NonAbstract.Node;

public class BracketEnc {

    public void accept(Visitor v) {
        v.visit(this);
    }
}
