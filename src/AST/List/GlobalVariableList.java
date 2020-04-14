package AST.List;

import AST.Abstract.ASTNode;
import AST.Abstract.VariableInitial;

import java.util.ArrayList;
import java.util.List;

public class GlobalVariableList extends ASTNode {
    private List<VariableInitial> list;

    public GlobalVariableList(int ln) {
        super(ln);
        list = new ArrayList<VariableInitial>();
    }

    public void add(VariableInitial e) { list.add(e); }

    public VariableInitial get(int i) { return list.get(i); }

    public int size() { return list.size(); }
}
