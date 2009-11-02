package cambridge.runtime;

import cambridge.ExpressionEvaluationException;
import cambridge.Template;
import cambridge.BehaviorInstantiationException;
import cambridge.parser.model.Fragment;
import cambridge.parser.model.FragmentList;

import java.io.IOException;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 3:38:35 PM
 */
public class DynamicTemplate implements Template {

   final FragmentList fragments;

   public DynamicTemplate(FragmentList fragments) {
      this.fragments = fragments;
      properties = new HashMap<String, Object>();
   }

   HashMap<String, Object> properties;

   public String toString() {
      try {
         StringBuilder builder = new StringBuilder();
         printTo(builder);
         return builder.toString();
      } catch (IOException e) {
         return null;
      } catch (ExpressionEvaluationException e) {
         return null;
      } catch (RecognitionException e) {
         return null;
      } catch (BehaviorInstantiationException e) {
         return null;
      }
   }

   @Override
   public void setProperty(String name, Object property) {
      properties.put(name, property);
   }

   @Override
   public void printTo(Appendable out) throws IOException, ExpressionEvaluationException, RecognitionException, BehaviorInstantiationException {
      properties.put("this", null);
      properties.put("super", null);
      for (Fragment f : fragments) {
         f.eval(properties, out);
      }
   }
}
