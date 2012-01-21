package cambridge.janino;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import cambridge.DirectoryTemplateLoader;
import cambridge.Expressions;
import cambridge.Template;
import cambridge.TemplateFactory;
import cambridge.TemplateLoadingException;

/**
 * @author Tom Carchrae
 */
public class JaninoTester {

	public static class Erdinc {
		public static String hello() {
			return "Hello";
		}

		public static String format(String foo, String[] objects) {
			return String.format(foo, (Object[]) objects);
		}
	}

	public static void main(String[] args) {
		try {
			JaninoExpressionLanguage janino = new JaninoExpressionLanguage();

			Expressions.setDefaultExpressionLanguage("janino", janino);
			final DirectoryTemplateLoader loader = new DirectoryTemplateLoader(
					new File("."));

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("a", 3);
			map.put("test", true);
			map.put("list", Arrays.asList("Hi", "Mom"));

			testFile(loader, "test.html", map);

			testFile(loader, "kitchensink.html", map);

		} catch (TemplateLoadingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testFile(final DirectoryTemplateLoader loader,
			String templateFile, HashMap<String, Object> map)
			throws IOException {
		final TemplateFactory f = loader.newTemplateFactory(templateFile);
		Template template = f.createTemplate();

		Writer writer = new OutputStreamWriter(System.out);
		for (Entry<String, Object> e : map.entrySet())
			template.setProperty(e.getKey(), e.getValue());
		template.printTo(writer);
		writer.flush();
		System.out.flush();
	}
}
