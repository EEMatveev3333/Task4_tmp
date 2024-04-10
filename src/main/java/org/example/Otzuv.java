package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Otzuv {

    //@Autowired
    String txt;

    //@Autowired
    //@Qualifier("max")
    Integer rate;

    public Otzuv() {
    }

    //@Autowired
    public Otzuv(String txt, Integer rate) {
        this.txt = txt;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Otzuv{" +
                "txt='" + txt + '\'' +
                ", rate=" + rate +
                '}';
    }

    @Bean("bean1_Task6")
    Otzuv Otzuv1(){
        //return new Integer(5);
        return new Otzuv("Очень хорошо",4);
    };

    @Bean("bean2_Task6")
    Otzuv Otzuv2(){
        //return new Integer(5);
        return new Otzuv("Сойдёт",3);
    };

    @Bean("bean3_Task6")
    @DependsOn("random")
    @Scope("prototype")
    Otzuv Otzuv3(@Autowired Integer random){
        //return new Integer(5);
        return new Otzuv("Сложно сказать",random);
    };

            /*
        6 Отзывы. Создайте класс «Отзыв», состоящий из текста отзыва в виде строки и целочисленной оценки.
        Далее создайте три бина типа «Отзыв» со следующими значениями:
        1.     Текст: «Очень хорошо». Оценка: 4
        2.     Текст: «Сойдёт». Оценка:3
        3.     Текст: «Сложно сказать». Оценка устанавливается бином random задачи 5
        */
}
