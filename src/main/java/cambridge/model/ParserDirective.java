package cambridge.model;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.TagNode;
import cambridge.model.TemplateNode;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

/**
 * Nodes to represent parser directives in the document.
 */
public class ParserDirective extends TemplateNode implements Fragment {
   String value;

   public ParserDirective(String value) {
      this.value = value;
   }

   public String getSource() {
      return value;
   }

   public void print(PrintStream out) throws IOException {
      out.print(value);
   }

   @Override
   public boolean isDynamic() {
      return true;
   }

   @Override
   public void normalize(FragmentList f) {
      f.addFragment(this);
   }

   @Override
   public TagNode getElementById(String id) {
      return null;
   }

   @Override
   public void eval(Map<String, Object> properties, Appendable out) throws IOException {
      // Do nothing
   }
}
