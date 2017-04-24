package il.org.spartan;

import static il.org.spartan.Out.*;

import java.lang.management.*;
import java.lang.reflect.*;
import java.util.*;

import org.eclipse.jdt.annotation.Nullable;
import org.jetbrains.annotations.*;

import il.org.spartan.reflection.*;

/** A class to print all properties of an arbitrary object which can be
 * retrieved by getters methods (i.e., getXXX()) methods and boolean inspection
 * methods (i.e., isXXX()), as can be determined by reflection information.
 * @author Yossi Gil
 * @since 24/07/2007 */
public class dump {
  /** Dump a class object
   * @param ¢ JD */
  public static void go(@NotNull final Class<?> ¢) {
    out("\n\n--IDENTIFICATION--\n");
    out("Simple Name", ¢.getSimpleName());
    out("Canonical Name", ¢.getCanonicalName());
    out("Name", ¢.getName());
    out("toString", ¢ + "");
    out("super class", ¢.getSuperclass());
    out("generic super class", ¢.getGenericSuperclass());
    out("class", ¢.getClass());
    out("component type", ¢.getComponentType());
    // out("protection domain", c.getProtectionDomain());
    out("class loader", ¢.getClassLoader());
    out("--MODIFIERS--\n");
    final int flags = ¢.getModifiers();
    out("Package", ¢.getPackage());
    out("Modifiers (decimal form)", flags);
    out("Modifiers (binary form)", ReflectionAnalyzer.toBinary(flags));
    out("IsSynthetic", ¢.isSynthetic());
    out("IsPrimitive", ¢.isPrimitive());
    out("IsFinal", Modifier.isFinal(flags));
    out("IsAbstract", Modifier.isAbstract(flags));
    out("IsStatic", Modifier.isStatic(flags));
    out("IsStrictfp", Modifier.isStrict(flags));
    out("--Visibility--\n");
    out("IsPublic", Modifier.isPublic(flags));
    out("IsPrivate", Modifier.isPrivate(flags));
    out("IsProtected", Modifier.isProtected(flags));
    out("--MEMBERS\n");
    out("fields", ¢.getFields());
    out("methods", ¢.getMethods());
    out("constructors", ¢.getConstructors());
    out("declared fields", ¢.getDeclaredFields());
    out("declared methods", ¢.getDeclaredMethods());
    out("declared constructors", ¢.getDeclaredConstructors());
    out("--CLASS SIGNATURE--\n");
    out("interfaces", ¢.getInterfaces());
    out("annotations", ¢.getAnnotations());
    out("type parameters", ¢.getTypeParameters());
    out("declared annotations", ¢.getDeclaredAnnotations());
    out("generic interfaces", ¢.getGenericInterfaces());
    out("--CONTAINERS--\n");
    out("declared classes", ¢.getDeclaredClasses());
    out("declaring class", ¢.getDeclaringClass());
    out("enclosing class", ¢.getEnclosingClass());
    out("enclosing constructor", ¢.getEnclosingConstructor());
    out("enclosing method", ¢.getEnclosingMethod());
    out("--CLASS MEMBERS--\n");
    out("public classes", ¢.getClasses());
    out("declared classes", ¢.getDeclaredClasses());
    out("declared annotations", ¢.getDeclaredAnnotations());
    out("---------------------------\n");
  }

  public static <T> void go(@NotNull final List<T> ts, @NotNull final String... ss) {
    out("Exploring list");
    for (final String ¢ : ss)
      out(¢);
    for (final T ¢ : ts)
      dump.go(¢);
  }

  public static void go(final Object os[], @NotNull final String... ss) {
    for (final String ¢ : ss)
      out(¢);
    out("elements", os);
  }

  public static void go(final @Nullable Object o, @NotNull final String... ss) {
    for (final String ¢ : ss)
      out(¢);
    if (o == null) {
      out("NULL");
      return;
    }
    final Class<?> c = o.getClass();
    out("\n\n--BEGIN " + c.getSimpleName() + " object: " + o + "\n");
    out("Class canonical name", c.getCanonicalName());
    out("Class name", c.getName());
    for (@NotNull final Method m : c.getMethods()) {
      if (m.getParameterTypes().length != 0)
        continue;
      String name = m.getName();
      if ("getClass".equals(name) || "toString".equals(name))
        continue;
      if (name.matches("^get[A-Z].*$"))
        name = name.replaceFirst("^get", "");
      else if (name.matches("^is[A-Z].*$"))
        name = name.replaceFirst("^is", "");
      else if ("size".equals(name))
        name = "size";
      else if (!name.matches("^to[A-Z].*$"))
        continue;
      try {
        final Object $ = m.invoke(o);
        if ($ == null) {
          out(name, "null");
          continue;
        }
        if ($ instanceof Object[])
          out(name, (Object[]) $);
        out(name, !($ instanceof Collection) ? $ : (Collection<Object>) $);
      } catch (@NotNull final Throwable ¢) {
        // For some reason, a reflection call to method
        // getContent() in URL objects throws this exception.
        // We do not have much to do in this and other similar cases.
        out(name, m.getName() + " THROWS " + ¢);
      }
    }
    out("--END OBJECT--\n\n");
    System.out.flush();
  }

  public static void main(final String[] args) {
    // Explore.go(Package.class);
    final ClassLoadingMXBean a = ManagementFactory.getClassLoadingMXBean();
    System.out.println(a.getLoadedClassCount());
    System.out.println(a.getTotalLoadedClassCount());
    System.out.println(a.getUnloadedClassCount());
    dump.go(ManagementFactory.getClassLoadingMXBean());
    final CompilationMXBean b = ManagementFactory.getCompilationMXBean();
    System.out.println(b.getTotalCompilationTime());
    System.out.println(b.getName());
    System.out.println(b.isCompilationTimeMonitoringSupported());
    System.exit(1);
    dump.go(ManagementFactory.getGarbageCollectorMXBeans());
    dump.go(ManagementFactory.getMemoryManagerMXBeans());
    dump.go(ManagementFactory.getMemoryPoolMXBeans());
    dump.go(ManagementFactory.getOperatingSystemMXBean());
    dump.go(ManagementFactory.getPlatformMBeanServer());
    dump.go(ManagementFactory.getRuntimeMXBean());
    dump.go(ManagementFactory.getThreadMXBean());
  }
}
