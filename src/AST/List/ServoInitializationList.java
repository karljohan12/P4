package AST.List;

import AST.Abstract.ASTNode;
import AST.Abstract.VariableInitial;

import java.util.ArrayList;
import java.util.List;

public class ServoInitializationList extends ASTNode {
    public List<VariableInitial> list;
    public List<String> ident;

    public ServoInitializationList(int ln) {
        super(ln);
        list = new ArrayList<VariableInitial>();
        ident = new ArrayList<String>();
    }

    public void add(VariableInitial e) {
        list.add(e);
    }

    public void addIdentifier(String i) {ident.add(i);}

    public VariableInitial get(int i) {
        return list.get(i);
    }

    public int size() {
        return list.size();
    }


}

