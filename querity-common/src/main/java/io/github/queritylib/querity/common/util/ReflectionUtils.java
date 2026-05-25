package io.github.queritylib.querity.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReflectionUtils {

    private static final Object SCAN_LOCK = new Object();

    /**
     * Find all concrete subclasses of the given base class within the same package.
     * <p>
     * This method uses the Reflections library to scan the package of the base class for subclasses. It filters out abstract classes, returning only concrete implementations.
     * Note that this method uses a shared lock to avoid race conditions when scanning the classpath via ZipFile, concurrent class loading causes "IllegalStateException: zip file closed".
     *
     * @param baseClass the base class to find subclasses of
     * @param <T>       the type of the base class
     * @return a set of concrete subclasses of the given base class
     */
    public static <T> Set<Class<? extends T>> findSubclasses(Class<T> baseClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean isConcreteClass(Class<?> clazz) {
        return !Modifier.isAbstract(clazz.getModifiers());
    }

    @SuppressWarnings("java:S3011")
    public static <T> Optional<Field> getAccessibleField(Class<T> beanClass, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> Optional<Field> getField(Class<T> beanClass, String fieldName) {
        Class<?> currentClass = beanClass;
        do {
            Optional<Field> field = Arrays.stream(currentClass.getDeclaredFields()).filter(e -> e.getName().equals(fieldName)).findFirst();
            if (field.isPresent()) {
                return field;
            } else {
                currentClass = currentClass.getSuperclass();
            }
        } while (currentClass != null);
        return Optional.empty();
    }

    public static <T, A> Optional<Class<? extends T>> findClassWithConstructorArgumentOfType(Set<Class<? extends T>> allClasses, Class<? extends A> constructorArgumentType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SneakyThrows
    // we want to have this generic constructor but also package-private classes
    @SuppressWarnings("java:S3011")
    public static <T, A> T constructInstanceWithArgument(Class<T> clazz, A argument) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
