package learn.rsb.bootstrap;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

public abstract class SpringUtils {

    public static ConfigurableApplicationContext run(Class<?> source, String profile) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        if (StringUtils.hasText(profile)) {
            applicationContext.getEnvironment().setActiveProfiles(profile);
        }

        applicationContext.register(source);
        applicationContext.refresh();

        applicationContext.start();
        return applicationContext;
    }
}
