package cambridge.model;

import cambridge.ExpressionEvaluationException;
import cambridge.ExpressionParsingException;
import cambridge.TemplateRuntimeException;
import cambridge.parser.expressions.Expression;
import cambridge.parser.expressions.ExpressionLexer;
import cambridge.parser.expressions.ExpressionParser;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

/**
 * ExpressionNodes are nodes within the documents that are
 * valid cambridge template expressions. Expression nodes
 */
public class ExpressionNode extends TemplateNode implements Fragment {
   String value;
   Expression expression;

   public ExpressionNode(String value) throws ExpressionParsingException {
      this.value = value;
      try {
         ANTLRStringStream stream = new ANTLRStringStream(value);
         ExpressionLexer lexer = new ExpressionLexer(stream);
         TokenStream tokenStream = new CommonTokenStream(lexer);
         ExpressionParser parser = new ExpressionParser(tokenStream);
         expression = parser.compilationUnit();
         if (parser.getErrors() != null) {
            throw new ExpressionParsingException(parser.getErrors());
         }
      } catch (RecognitionException e) {
         throw new ExpressionParsingException(e);
      }
   }

   public String getSource() {
      return "${" + value + "}";
   }

   public void print(PrintStream out) throws IOException {
      out.print("${");
      out.print(value);
      out.print("}");
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
   public Tag getElementById(String id) {
      return null;
   }

   @Override
   public void eval(Map<String, Object> properties, Appendable out) throws IOException, TemplateRuntimeException {
      try {
         Object value = expression.eval(properties);
         if (value != null) {
            out.append(value.toString());
         }
      } catch (ExpressionEvaluationException e) {
         throw new TemplateRuntimeException("Could not execute the expression: " + e.getMessage(), getBeginLine(), getBeginColumn(), value);
      }
   }

   public String toString() {
      return getSource();
   }
}
