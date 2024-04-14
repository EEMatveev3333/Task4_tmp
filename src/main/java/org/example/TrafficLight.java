package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.*;





@Component
public class TrafficLight {

    // Список вариантов
    @Autowired
    private List<ColorClass> CurColor;

    // Текущий цвет
    @Autowired
    @Qualifier("RedBean") // Начальное значение на момент запуска
    private ColorClass SingleColor;

    public TrafficLight() {
    }

    @Bean("TrafficLightCnt")
    Integer TrafficLightCnt(){
        return new Integer(CurColor.size());
    }

    @Bean("TrafficLightArrayString")
    String TrafficLightArrayString(){
        return new String(Arrays.toString(CurColor.toArray()));
    }

    @Bean("TrafficLightList")
    List TrafficLightList(){
        //return new ArrayList(CurColor);
        return CurColor;
    }

    //@Bean("RedBean")
    public ColorClass next(){
        System.out.println(SingleColor.toString());
        //Обработка с учетом времени по первому вхождению
        Optional<ColorClass> tmp = CurColor.stream().filter(sl1->sl1.SecStart != null && sl1.SecEnd != null).filter(sl-> LIB.CurrentTimeBetweenBorder(new Date(),sl.SecStart,sl.SecEnd)).findFirst();
        if (!tmp.isEmpty()) {
            SingleColor = tmp.get();
            return SingleColor;
        }
        //Обработка с учетом времени
        //CurColor.
        //Обработка без учета времени
        List<ColorClass> curColor = CurColor.stream().filter(sl1->sl1.SecStart == null && sl1.SecEnd == null).toList();

        if (curColor.indexOf(SingleColor) == (curColor.size() - 1) && curColor.size() >= 1 )
            SingleColor = curColor.get(0);
        else if  (curColor.indexOf(SingleColor) < (curColor.size() - 1) && curColor.size() >= 1 )
            SingleColor = curColor.get(curColor.indexOf(SingleColor) + 1);

        return SingleColor;//new //ColorClass("Красный");
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "CurColor=" + CurColor +
                ", SingleColor=" + SingleColor +
                '}';
    }

    @PostConstruct
    public void init() {
        // Код инициализации
        System.out.println("@PostConstruct called");
        //System.out.println(CurColor.indexOf(null));
        System.out.println(CurColor.size());
        CurColor.removeIf(sl->sl.Color == null);
        //System.out.println(CurColor.stream().filter(t->t.));
        System.out.println(CurColor.size());

//        @Override
//        public void run() {
//            while (!this.interrupted()) {
//                try {
//                    godHashMap.entrySet().removeIf(entry -> entry.getKey().before(new Timestamp(System.currentTimeMillis())));
//                    this.sleep(1000);
//                } catch (InterruptedException e) {
//                    this.interrupt();
//                }
//            }
//        }
//    }

    }
}

