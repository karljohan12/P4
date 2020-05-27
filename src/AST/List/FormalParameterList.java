package AST.List;

import AST.Abstract.AFunction;
import AST.Abstract.ASTNode;
import Interfaces.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class FormalParameterList extends ASTNode {
    public List<AFunction> list;

    public FormalParameterList(int ln) {
        super(ln);
        list = new ArrayList<AFunction>();
    }

    public void add(AFunction e) { list.add(e); }

    public AFunction get(int i) { return list.get(i); }

    public int size() { return list.size(); }

    public void accept(IVisitor v) {
        v.visit(this);
    }

}
