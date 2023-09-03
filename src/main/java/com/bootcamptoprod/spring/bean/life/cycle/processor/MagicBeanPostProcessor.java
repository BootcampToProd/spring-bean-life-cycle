package com.bootcamptoprod.spring.bean.life.cycle.processor;

import com.bootcamptoprod.spring.bean.life.cycle.beans.Character;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MagicBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof Character) {
            System.out.println("BeanPostProcessor: Adding a touch of magic to " + ((Character) bean).getName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof Character) {
            System.out.println("BeanPostProcessor: Magic continues for " + ((Character) bean).getName());
        }
        return bean;
    }
}
