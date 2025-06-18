//package basic.annotation;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoggingAspect {
//    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
//
//    @Before("@annotation(loggable)")  // Targets methods with @Loggable
//    public void logMethod(Loggable loggable) {
//        logger.info("Executing method with log level: {}", loggable.value());
//    }
//}
