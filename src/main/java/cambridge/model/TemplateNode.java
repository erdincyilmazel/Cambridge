package cambridge.model;

import cambridge.BehaviorInstantiationException;

import java.util.ArrayList;

public abstract class TemplateNode {
   ParentNode parent;

   int beginLine, beginColumn;
   int endLine, endColumn;

   public void setParent(ParentNode parent) {
      this.parent = parent;
   }

   public ParentNode getParent() {
      return parent;
   }

   public TemplateNode getPreviousSibling() {
      return parent.getPreviousChild(this);
   }

   public TemplateNode getNextSibling() {
      return parent.getNextChild(this);
   }

   public int getBeginLine() {
      return beginLine;
   }

   public void setBeginLine(int beginLine) {
      this.beginLine = beginLine;
   }

   public int getBeginColumn() {
      return beginColumn;
   }

   public void setBeginColumn(int beginColumn) {
      this.beginColumn = beginColumn;
   }

   public int getEndLine() {
      return endLine;
   }

   public void setEndLine(int endLine) {
      this.endLine = endLine;
   }

   public int getEndColumn() {
      return endColumn;
   }

   public void setEndColumn(int endColumn) {
      this.endColumn = endColumn;
   }

   public abstract boolean isDynamic();

   public abstract void normalize(FragmentList f) throws BehaviorInstantiationException;

   public abstract boolean normalizeUntil(TemplateNode reference, FragmentList f, boolean inclusive) throws BehaviorInstantiationException;

   public abstract Tag getElementById(String id);

   void addElementsbyTagName(String tagName, ArrayList<Tag> tags) {
   }
}
