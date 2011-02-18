/*
 *  Copyright 2008 erdincyilmazel.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package cambridge.parser;

import java.io.IOException;
import java.io.InputStream;

/**
 * An InputStream to read from Strings.
 */
class StringInputStream extends InputStream {
   private final String input;

   public StringInputStream(String input) {
      this.input = input;
   }

   private int current;

   @Override
   public int read() throws IOException {
      if (current + 1 == input.length()) return -1;
      return (int) input.charAt(current++);
   }
}
