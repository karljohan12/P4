package AST.List;

import AST.Abstract.ASTNode;
import AST.Abstract.VariableInitial;
import Interfaces.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class VariableInitializationList extends ASTNode {
    public List<VariableInitial> list;

    public VariableInitializationList() {
        super(0);
        list = new ArrayList<VariableInitial>();
    }

    public void add(VariableInitial e) {
        list.add(e);
    }

    public VariableInitial get(int i) {
        return list.get(i);
    }

    public int size() {
        return list.size();
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }


}
