package AST.List;

import AST.Abstract.ASTNode;

import java.util.List;

public class BlockStatementList extends ASTNode {
    private List<?> list;

    public BlockStatementList(int ln) {
        super(ln);
        list = new ArrayList<?>();
    }

    public void add(? e) { list.add(e); }

    public ? get(int i) { return list.get(i); }

    public int size() { return list.size(); }
}
