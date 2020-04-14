package AST.List;

import AST.Abstract.AFunction;
import AST.Abstract.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class FunctionStatementList extends ASTNode {
    private List<AFunction> list;

    public FunctionStatementList(int ln) {
        super(ln);
        list = new ArrayList<>();
    }

    public void add(AFunction e) { list.add(e); }

    public AFunction get(int i) { return list.get(i); }

    public int size() { return list.size(); }
}
