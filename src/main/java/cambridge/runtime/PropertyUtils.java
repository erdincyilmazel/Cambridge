package cambridge.runtime;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: erdinc
 * Date: Oct 31, 2009
 * Time: 9:58:38 AM
 */
public class PropertyUtils {
   class Property {
      final Class beanClass;
      final String name;

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Property property = (Property) o;
         return beanClass.equals(property.beanClass) && name.equals(property.name);
      }

      @Override
      public int hashCode() {
         int result = beanClass.hashCode();
         result = 31 * result + name.hashCode();
         return result;
      }

      Property(Class beanClass, String name) {
         this.beanClass = beanClass;
         this.name = name;
      }
   }

   static PropertyUtils instance;

   public static PropertyUtils instance() {
      if (instance == null) {
         instance = new PropertyUtils();
      }

      return instance;
   }

   private PropertyUtils() {
      //accessors = new HashMap<Property, Method>();
   }

   //HashMap<Property, Method> accessors;

   public Object getBeanProperty(Object bean, String property) throws PropertyAccessException {
      try {
         Class beanClass = bean.getClass();
         if (beanClass.equals(Super.class)) {
            if (property.equals("super")) {
               return ((Super) bean).getSuper();
            }

            bean = ((Super) bean).get();
            beanClass = bean.getClass();
         }

         Method m;
         Property p = new Property(beanClass, property);

//         m = accessors.get(p);
//         if (m != null) {
//            return m.invoke(bean);
//         }

         BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);

         PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();

         for (PropertyDescriptor d : descriptors) {
            if (property.equals(d.getName())) {
               m = d.getReadMethod();
               //m.setAccessible(true);
               //accessors.put(p, m);
               return m.invoke(bean);
            }
         }

         try {
            Field f = beanClass.getField(property);
            return f.get(bean);
         } catch (NoSuchFieldException e) {
            //
         }


         try {
            m = beanClass.getMethod(property);
            //accessors.put(p, m);

            return m.invoke(bean);
         } catch (NoSuchMethodException e) {
            throw new PropertyAccessException("Unknown property " + property + " on bean " + beanClass.getName(), bean, property);
         } catch (Exception e) {
            throw new PropertyAccessException("Inaccessible property " + property + " on bean " + beanClass.getName(), bean, property);
         }
      } catch (IntrospectionException e) {
         throw new PropertyAccessException(e.getMessage(), bean, property);
      } catch (InvocationTargetException e) {
         throw new PropertyAccessException(e.getMessage(), bean, property);
      } catch (IllegalAccessException e) {
         throw new PropertyAccessException(e.getMessage(), bean, property);
      }
   }

   public boolean hasBeanProperty(Object bean, String property) throws PropertyAccessException {
      try {
         Method m;
         Property p = new Property(bean.getClass(), property);

         //m = accessors.get(p);
//         if (m != null) {
//            return true;
//         }

         BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
         PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
         for (PropertyDescriptor d : descriptors) {
            if (property.equals(d.getName())) {
               m = d.getReadMethod();
               m.setAccessible(true);
               //accessors.put(p, m);
               return true;
            }
         }

         return false;
      } catch (IntrospectionException e) {
         throw new PropertyAccessException(e.getMessage(), bean, property);
      }
   }
}
