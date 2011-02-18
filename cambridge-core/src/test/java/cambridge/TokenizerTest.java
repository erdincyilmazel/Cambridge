package cambridge;

import cambridge.parser.TemplateTokenizer;
import cambridge.parser.Tokenizer;
import cambridge.parser.tokens.Token;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 10:51:25 AM
 */
public class TokenizerTest {
   private Tokenizer tokenizer;

   @Before
   public void setUp() {
      try {
         tokenizer = new TemplateTokenizer(new BufferedReader(new InputStreamReader(TokenizerTest.class.getResourceAsStream("input.html"))));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void testScannerOutput() throws IOException {
      StringBuilder inputBuilder = new StringBuilder();
      StringBuilder outputBuilder = new StringBuilder();

      Token token;
      while (tokenizer.hasMoreTokens()) {
         token = tokenizer.nextToken();
         assertNotNull(token);
         if (token.value != null) {
            outputBuilder.append(token.getActualValue());
         }
      }

      InputStream fileIn = TokenizerTest.class.getResourceAsStream("input.html");
      InputStreamReader reader = new InputStreamReader(fileIn);
      int i;
      while ((i = reader.read()) != -1) {
         inputBuilder.append((char) i);
      }

      fileIn.close();

      assertEquals(inputBuilder.toString(), outputBuilder.toString());
   }

   @Test
   public void test() throws IOException {
      Token token;
      while (tokenizer.hasMoreTokens()) {
         token = tokenizer.nextToken();
         assertNotNull(token);
      }
   }

   @After
   public void close() {
      try {
         tokenizer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      try {
         Tokenizer tokenizer = new TemplateTokenizer(TokenizerTest.class.getResourceAsStream("input.html"));

         Token token;
         while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            System.out.println(token);
         }

         tokenizer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
