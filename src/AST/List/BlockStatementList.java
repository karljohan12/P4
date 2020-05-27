package AST.List;

import AST.Abstract.ASTNode;
import AST.Abstract.BlockStatement;
import Interfaces.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class BlockStatementList extends ASTNode {
    private List<BlockStatement> list;

    public BlockStatementList(int ln) {
        super(ln);
        list = new ArrayList<BlockStatement>();
    }

    public void add(BlockStatement e) { list.add(e); }

    public BlockStatement get(int i) { return list.get(i); }

    public int size() { return list.size(); }

    public void accept(IVisitor v) {
        v.visit(this);
    }
}
