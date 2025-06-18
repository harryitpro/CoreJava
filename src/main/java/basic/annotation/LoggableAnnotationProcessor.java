package basic.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoggableAnnotationProcessor {
    //Demo how to get annotation info from an annotated method.
    public static void displayLoggingLevelOfMethod() {
        for (Method method : MyService.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Loggable.class)) {
                Loggable loggable = method.getAnnotation(Loggable.class);
                String logLevel = loggable.value();
                System.out.println("Method: " + method.getName() + " is loggable with level: " + logLevel);
                Class<?>[] parameterTypes = method.getParameterTypes();
                System.out.println("Parameter Types:");
                for (Class<?> type : parameterTypes) {
                    System.out.println("  " + type.getSimpleName());
                }
            }
        }
    }


    //demo how to intercept a method call of an object
    public static void invokeAnnotatedMethod() {
        MyService service = new MyService();
        for (Method method : MyService.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Loggable.class)) {
                try {
                    method.invoke(service, "Testing Message");
                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
//                    throw new RuntimeException(e);
                } catch (IllegalArgumentException e) {
                    //ignore
                }
            }
        }
    }

    /**
     * Logging parameters before the method gets called for methods annotated with @Loggable
     */
    public static void main(String[] args) throws Exception {
        displayLoggingLevelOfMethod();
        /**
         * output:
         * Method: getResult is loggable with level: INFO
         * Method: process is loggable with level: DEBUG
         */

        invokeAnnotatedMethod();
        /**
         * output:
         * processing message: Testing Message
         */
    }
}
