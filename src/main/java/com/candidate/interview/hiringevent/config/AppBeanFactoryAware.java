package com.candidate.interview.hiringevent.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppBeanFactoryAware implements BeanFactoryAware {

    @Value("${spring.beans.remove}")
    private String removeBeanDefinitions;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BeanDefinitionRegistry configurableBeanFactory =  (BeanDefinitionRegistry) beanFactory;
//        Arrays.stream(removeBeanDefinitions.split(",")).forEach(beanName->{
//            try {
//                configurableBeanFactory.removeBeanDefinition(beanName);
//            } catch (NoSuchBeanDefinitionException e) {
//                e.printStackTrace();
//            }
//        });
       // configurableBeanFactory.getBeanDefinition("flywayInitializer")
    }
}
