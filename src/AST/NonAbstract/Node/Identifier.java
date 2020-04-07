package AST.NonAbstract.Node;

public class Identifier extends Name {
    public Identifier i;

    public Identifier(Identifier i1, int ln){
        super(ln);
        i = i1;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
