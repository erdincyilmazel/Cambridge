package cambridge;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author Erdinc YILMAZEL
 * @since 1/29/11
 */
@Provider
public class TemplateMessageBodyWriter implements MessageBodyWriter<Template> {
   public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
      return Template.class.isAssignableFrom(type);
   }

   public long getSize(Template template, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
      return -1;
   }

   public void writeTo(Template template, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(entityStream));
      template.printTo(writer);
      writer.flush();
   }
}
