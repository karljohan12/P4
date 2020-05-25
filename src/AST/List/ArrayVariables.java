package AST.List;

import AST.Abstract.VariableInitial;
import Interfaces.IVisitor;

public class ArrayVariables extends VariableInitial {

   public VariableInitializationList il;

   public ArrayVariables(VariableInitializationList il, int ln){
       super(ln);
       this.il = il;

   }





    /*private List<VariableInitial> list;

    public ArrayVariables(VariableInitializationList vil, int ln) {
        super(ln);
        list = new ArrayList<VariableInitial>();
    }

    public void add(VariableInitial e) { list.add(e); }

    public VariableInitial get(int i) { return list.get(i); }

    public int size() { return list.size(); }*/

    public void accept(IVisitor v) {
        v.visit(this);
    }


    }
