package play.mvc;

import cambridge.Cambridge;
import cambridge.parser.PlayActionsExtensionPoint;
import cambridge.parser.PlayMessagesExtensionPoint;
import cambridge.parser.TemplateParser;
import play.Play;
import play.classloading.enhancers.LocalvariablesNamesEnhancer;
import play.data.validation.Validation;
import play.exceptions.PlayException;
import play.exceptions.TemplateNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: erdincyilmazel
 * Date: 1/7/11
 * Time: 9:32 PM
 */
public class CambridgeController extends Controller {
   static {
      TemplateParser.registerExtensionPoint(new PlayActionsExtensionPoint());
      TemplateParser.registerExtensionPoint(new PlayMessagesExtensionPoint());

      Cambridge cambridge = Cambridge.getInstance();
      cambridge.registerFunction("Action", new ActionFunction(false));
      cambridge.registerFunction("AAction", new ActionFunction(true));
   }

   protected static void render(Object... args) {
      String templateName = null;
      if (args.length > 0 && args[0] instanceof String && LocalvariablesNamesEnhancer.LocalVariablesNamesTracer.getAllLocalVariableNames(args[0]).isEmpty()) {
         templateName = args[0].toString();
      } else {
         templateName = template();
      }
      renderTemplate(templateName, args);
   }

   protected static void renderTemplate(String templateName, Object... args) {
      // Template datas
      Map<String, Object> templateBinding = new HashMap<String, Object>(16);
      for (Object o : args) {
         List<String> names = LocalvariablesNamesEnhancer.LocalVariablesNamesTracer.getAllLocalVariableNames(o);
         for (String name : names) {
            templateBinding.put(name, o);
         }
      }
      renderTemplate(templateName, templateBinding);
   }

   protected static void renderTemplate(String templateName, Map<String, Object> args) {
      // Template datas
      Scope.RenderArgs templateBinding = Scope.RenderArgs.current();
      templateBinding.data.putAll(args);
      templateBinding.put("session", Scope.Session.current());
      templateBinding.put("request", Http.Request.current());
      templateBinding.put("flash", Scope.Flash.current());
      templateBinding.put("params", Scope.Params.current());
      templateBinding.put("errors", Validation.errors());

      try {
         throw new RenderCambridgeTemplate(templateName, templateBinding.data);
      } catch (TemplateNotFoundException ex) {
         if (ex.isSourceAvailable()) {
            throw ex;
         }
         StackTraceElement element = PlayException.getInterestingStrackTraceElement(ex);
         if (element != null) {
            throw new TemplateNotFoundException(templateName, Play.classes.getApplicationClass(element.getClassName()), element.getLineNumber());
         } else {
            throw ex;
         }
      }
   }

   protected static void renderTemplate(Map<String, Object> args) {
      renderTemplate(template(), args);
   }
}
