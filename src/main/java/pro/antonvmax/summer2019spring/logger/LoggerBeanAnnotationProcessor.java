package pro.antonvmax.summer2019spring.logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class LoggerBeanAnnotationProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        Class clazz = bean.getClass();

        do {

            for (Field field : clazz.getFields()) {
                Logging annotation = field.getAnnotation(Logging.class);
                if (annotation != null) {
                    boolean fieldAccessible = field.canAccess(bean);
                    field.setAccessible(true);
                    try {
                        if (!annotation.value().isEmpty()) {
                            field.set(bean, LoggerFactory.getLogger(annotation.value()));
                        } else {
                            field.set(bean, LoggerFactory.getLogger(clazz));
                        }
                    } catch (IllegalAccessException e) {
                        LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
                    }
                    field.setAccessible(fieldAccessible);
                }
            }

            clazz = clazz.getSuperclass();

        } while (clazz != null);

        return bean;
    }
}
