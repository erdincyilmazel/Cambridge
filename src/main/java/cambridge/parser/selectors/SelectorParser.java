package cambridge.parser.selectors;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: erdinc
 * Date: Nov 6, 2009
 * Time: 1:39:09 AM
 */
public class SelectorParser {

   public SelectorParser(String selector) {

   }

   static Pattern selectorPattern = Pattern.compile("(<|>|=|(<=)|(>=)|(<>)|(\\*=))?\\s*(((/|#)([^/#\\s]+)(\\[\\d+\\])?)+)");

   public static void main(String[] args) {
      //SelectorParser tok = new SelectorParser("<= \n\n /html/body");
      Matcher matcher = selectorPattern.matcher("< \n\n /html/body/div[1]#erdinc");

      if (matcher.find()) {
         String operator = matcher.group(1);
         String selector = matcher.group(6);

         StringTokenizer tokenizer = new StringTokenizer(selector, "/#", true);

         while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
         }
      }
   }
}
