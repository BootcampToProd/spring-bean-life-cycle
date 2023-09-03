package com.bootcamptoprod.spring.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Character implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private int health;
    private Weapon weapon;
    private Item item;
    private String beanName;
    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    public Character() {
        System.out.println("Instantiation: A new character has been created.");
        this.name = "Default";
        this.health = 100;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        System.out.println("Population of Properties: Equipping " + weapon.getName() + " to " + getName());
    }

    public void setItem(Item item) {
        this.item = item;
        System.out.println("Population of Properties: Adding " + item.getName() + " to " + getName() + "'s inventory");
    }

    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware: Setting bean name: " + name);
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware: Setting application context.");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("BeanFactoryAware: Setting bean factory for " + getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialization: " + getName() + " is undergoing intensive training.");
        trainCharacter();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean: " + getName() + " is saying goodbye and resting.");
        restAndRecover();
    }

    public void customInit() {
        System.out.println("Custom Initialization: Executing custom init for " + getName());
        performSpecialTraining();
    }

    public void customDestroy() {
        System.out.println("Custom Destruction: " + getName() + " is bidding farewell and performing a final action.");
        sayGoodbye();
        performFinalAction();
    }

    private void trainCharacter() {
        System.out.println("Initialization: " + getName() + " is training to become stronger.");
    }

    private void restAndRecover() {
        System.out.println("DisposableBean: " + getName() + " is resting and recovering energy.");
    }

    private void performSpecialTraining() {
        System.out.println("Custom Initialization: " + getName() + " is performing a special training routine.");
    }

    private void sayGoodbye() {
        System.out.println("Custom Destruction: " + getName() + " says goodbye.");
    }

    private void performFinalAction() {
        System.out.println("Custom Destruction: " + getName() + " performs a final action.");
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct: " + getName() + " is preparing for action.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy: " + getName() + " is saying goodbye and preparing to rest.");
    }

    // Other methods
}
