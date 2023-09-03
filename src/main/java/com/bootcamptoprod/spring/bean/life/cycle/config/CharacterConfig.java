package com.bootcamptoprod.spring.bean.life.cycle.config;

import com.bootcamptoprod.spring.bean.life.cycle.beans.Character;
import com.bootcamptoprod.spring.bean.life.cycle.beans.Item;
import com.bootcamptoprod.spring.bean.life.cycle.beans.Weapon;
import com.bootcamptoprod.spring.bean.life.cycle.processor.MagicBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CharacterConfig {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public Character character() {
        Character character = new Character();
        character.setWeapon(sword());
        character.setItem(potion());
        return character;
    }

    @Bean
    public Weapon sword() {
        return new Weapon("Sword");
    }

    @Bean
    public Item potion() {
        return new Item("Health Potion");
    }

    @Bean
    public MagicBeanPostProcessor magicBeanPostProcessor() {
        return new MagicBeanPostProcessor();
    }
}
