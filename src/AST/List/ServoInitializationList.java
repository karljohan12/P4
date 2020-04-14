package AST.List;

import AST.Abstract.ASTNode;
import AST.Abstract.VariableInitial;
import AST.Visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ServoInitializationList extends ASTNode {
    public List<VariableInitial> list;

    public ServoInitializationList(int ln) {
        super(ln);
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


}

