package cambridge.parser;

import cambridge.parser.tokens.Token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public abstract class Tokenizer {
   final static char EOL = 65535;

   private final static int BUFFER_SIZE = 50;
   private final static int maxPeek = 40;

   private final Reader reader;
   // protected InputStream input;

   private int lineNo = 1;

   private final char[] buf = new char[BUFFER_SIZE];

   private int readIndex = -1; // The last read index
   private int writeIndex = -1; // The last written index
   private int column = 1;

   private int getIndex(int no) {
      return no % BUFFER_SIZE;
   }

   private void fillBuffer() throws IOException {
      int c;
      while (true) {
         // reader.read(buf, x, y);
         c = reader.read();
         writeIndex++;
         buf[getIndex(writeIndex)] = (char) c;

         if (readIndex == -1) {
            if (c == -1 || writeIndex == BUFFER_SIZE - 1) break;
         } else {
            if (c == -1 || writeIndex - readIndex == maxPeek) break;
         }
      }
   }

   private char previousChar;

   char nextChar() throws IOException {
      if (readIndex + (BUFFER_SIZE - maxPeek) == writeIndex && (int) buf[getIndex(writeIndex)] != -1) {
         fillBuffer();
      }

      char c = buf[getIndex(++readIndex)];
      if (c == '\n' && previousChar != '\r') {
         lineNo++;
         column = 1;
      } else if (c == '\r') {
         lineNo++;
         column = 1;
      } else {
         column++;
      }
      previousChar = c;
      return c;
   }

   char nextChar(int t) throws IOException {
      for (int i = 0; i < t - 1; i++) {
         nextChar();
      }
      return nextChar();
   }

   char peek(int p) {
      if (p > maxPeek) throw new IllegalArgumentException("Can not peek " + p + " characters");
      return buf[getIndex(readIndex + p)];
   }

   String peekString(int p) {
      if (p > maxPeek) throw new IllegalArgumentException("Can not peek " + p + " characters");
      char[] peek = new char[p];

      for (int i = 0; i < p; i++) {
         peek[i] = buf[getIndex(readIndex + i + 1)];
      }
      return new String(peek);
   }

   int getColumn() {
      return column;
   }

   int getLineNo() {
      return lineNo;
   }

   public Tokenizer(Reader reader) throws IOException {
      this.reader = reader;
      fillBuffer();
   }

   public Tokenizer(InputStream in) throws IOException {
      this(new BufferedReader(new InputStreamReader(in)));
   }

   public void close() throws IOException {
      reader.close();
   }

   public boolean hasMoreTokens() {
      if (readIndex == -1) return writeIndex > readIndex;
      return buf[getIndex(readIndex)] != 65535;
   }

   public abstract Token nextToken() throws IOException;
}
