package cambridge.model;

import cambridge.BehaviorInstantiationException;
import cambridge.TemplateParsingException;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Every
 */
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
      return null;
   }

   public TemplateNode getNextSibling() {
      return null;
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

   public abstract String getSource();

   public abstract void print(PrintStream out) throws IOException;

   public abstract boolean isDynamic();

   public abstract void normalize(FragmentList f) throws TemplateParsingException, BehaviorInstantiationException;

   public abstract Tag getElementById(String id);

   public void addElementsbyTagName(String tagName, ArrayList<Tag> tags) {
   }
}
