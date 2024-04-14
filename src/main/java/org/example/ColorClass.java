package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ColorClass {
    public String Color;
    public Integer SecStart;
    public Integer SecEnd;

    public ColorClass() {
    }
    public ColorClass(String color) {
        Color = color;
    }


    public ColorClass(String color, Integer secStart, Integer secEnd) {
        Color = color;
        SecStart = secStart;
        SecEnd = secEnd;
    }

    @Bean("RedBean")
    ColorClass MakeRed(){
        return new ColorClass("Красный");
    }

    @Bean("Yellow1Bean")
    @DependsOn({"RedBean"})
    ColorClass MakeYellow1(){
        return new ColorClass("Жёлтый");
    }

    @Bean("GreenBean")
    @DependsOn({"Yellow1Bean"})
    ColorClass MakeGreen(){
        return new ColorClass("Зеленый");
    }

    @Bean("Yellow2Bean")
    @DependsOn({"GreenBean"})
    ColorClass MakeYellow2(){
        return new ColorClass("Жёлтый");
    }

    @Bean("Yellow3TimeBean")
    ColorClass MakeYellow3Time(){
        return new ColorClass("Жёлтый"
                ,0
                ,5*60*60//(5утра)

        );
    }


    @Override
    public String toString() {
        return "ColorClass{" +
                "Color='" + Color + '\'' +
                ", SecStart=" + SecStart +
                ", SecEnd=" + SecEnd +
                '}';
    }


}
