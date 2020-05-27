package AST.Abstract;

import Interfaces.INode;

abstract public class ASTNode implements INode {
    public int lineNumber;

    public ASTNode(int ln) {lineNumber = ln;}
}
