package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Date;
import java.util.function.Predicate;

//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Configuration;
//        if (F1 == null) F1 = new java.util.Date();
@Configuration
public class StringBean {
    @Bean("GetStrBean")
    String GetStrBean(){return new String("Hello world!");};

    @Bean("GetDateBean")
    Date GetDateBean(){return new java.util.Date();};

    @Bean("max")
    Integer GetIntMax(){return new Integer(5);};

    @Bean("min")
    Integer GetIntMin(){return new Integer(2);};

    @Bean("GetPredicateInteger")
    Predicate<Integer> GetPredicateInteger(){
        return new PredicateExample();
    };

    @Bean("GetPredicateInteger2")
    Predicate<Integer> GetPredicateInteger2(){
        Predicate<Integer> predicateExample = i -> (i <= 5 && i >= 2);
        return predicateExample;
    };


    @Bean("RandomIntWithConditions")
    @DependsOn({"max","min"})
    Integer RandomIntWithConditions()
    {
        return new Integer(2);
    };


}
