package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("Start!");
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");

        //context.registerBean(Integer.class,5);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////
        // 1 task
        String Str = context.getBean("GetStrBean",String.class);
        System.out.println("Str - " + Str);

        ////////////////////////////////////////
        // 2 task
        Date date = context.getBean("GetDateBean",Date.class);
        System.out.println("date - " + date);

        ////////////////////////////////////////
        // 3 task
//        Predicate<Integer> PredInt = context
//                .getBean("GetPredicateInteger",Predicate.class);
//
//        System.out.println("PredInt.test(1) - " + PredInt.test(1));
//        System.out.println("PredInt.test(5) - " + PredInt.test(5));

        Predicate<Integer> PredInt2 = context.getBean("GetPredicateInteger2",Predicate.class);
        System.out.println("PredInt2.test(1) - " + PredInt2.test(1));
        System.out.println("PredInt2.test(5) - " + PredInt2.test(5));

        ////////////////////////////////////////
        // 4 task
        Integer min = context.getBean("min",Integer.class);
        System.out.println("min - " + min);
        Integer max = context.getBean("max",Integer.class);
        System.out.println("max - " + max);

        ////////////////////////////////////////
        // 5 task
        //5 random. Создайте бин типа int, который при каждом его запросе возвращает новое случайное значение в диапазоне от 0 до 99.  При этом необходимо обеспечить, чтобы:
        //1.     Минимальное и максимальное значения задавались бинами из задачи 4
        //2.     Возвращаемые им числа не повторялись до тех пор, пока не использованы все значения в диапазоне от минимального до максимального.
        Integer Shuffle = context.getBean("random",Integer.class);
        System.out.println("Shuffle_1pass - " + Shuffle);

        Shuffle = context.getBean("random",Integer.class);
        System.out.println("Shuffle_2pass - " + Shuffle);

        Shuffle = context.getBean("random",Integer.class);
        System.out.println("Shuffle_3pass - " + Shuffle);

        Shuffle = context.getBean("random",Integer.class);
        System.out.println("Shuffle_4pass - " + Shuffle);

        Shuffle = context.getBean("random",Integer.class);
        System.out.println("Shuffle_5pass - " + Shuffle);
        ////////////////////////////////////////
        // 6 task
        /*
        6 Отзывы. Создайте класс «Отзыв», состоящий из текста отзыва в виде строки и целочисленной оценки.
        Далее создайте три бина типа «Отзыв» со следующими значениями:
        1.     Текст: «Очень хорошо». Оценка: 4
        2.     Текст: «Сойдёт». Оценка:3
        3.     Текст: «Сложно сказать». Оценка устанавливается бином random задачи 5
        */
        Otzuv otzuv = context.getBean("bean1_Task6",Otzuv.class);
        System.out.println("bean1_Task6 - " + otzuv);

        otzuv = context.getBean("bean2_Task6",Otzuv.class);
        System.out.println("bean2_Task6 - " + otzuv);

        otzuv = context.getBean("bean3_Task6",Otzuv.class);
        System.out.println("bean3_Task6 - " + otzuv);

        otzuv = context.getBean("bean3_Task6",Otzuv.class);
        System.out.println("bean3_Task6 - " + otzuv);

        otzuv = context.getBean("bean3_Task6",Otzuv.class);
        System.out.println("bean3_Task6 - " + otzuv);

        otzuv = context.getBean("bean3_Task6",Otzuv.class);
        System.out.println("bean3_Task6 - " + otzuv);
        ////////////////////////////////////////
        // 7 task
        // 7 Лучший отзыв. Создайте бин типа «Отзыв», который будет возвращать тот из созданных в задаче 6 бинов, который имеет самую высокую оценку на момент запроса бина.
        System.out.println("7 task");
        Otzuv otzuv7Task = context.getBean("bean_Task7",Otzuv.class);
        System.out.println("bean_Task7 - " + otzuv7Task);

        Integer otzuv7TaskCnt = context.getBean("bean_Task7_cnt",Integer.class);
        System.out.println("bean_Task7_cnt - " + otzuv7TaskCnt);



//        System.out.println(Arrays.toString(context.getBeanNamesForType(Otzuv.class)));
//        for (BeansInst : context.getBean(Otzuv.class))
//            {}
        ////////////////////////////////////////
        // 8 task
//        8 Светофор.
//
//                Разработайте сущность Светофор, которая может использоваться для управления пешеходами и машинами на дороге. При вызове метода next, на экран выводится текст обозначающего текущий цвет, например, «красный» или «зелёный».
//
//        Реализуйте Светофор таким образом, чтобы появление или исчезновение дополнительных секций или требований не приводило бы к изменению кода самого светофора. Например: с 12 ночи до 5 утра следующим цветом всегда является “желтый”. Подсказка: в базовом решении не должны использоваться инструкции for, while, if и switch.
//
//        Далее необходимо разработать и настроить группу бинов, позволяющих реализовать функционал Светофора. На основе этих бинов реализуйте трехцветный светофор (красный, желтый, зеленый цвета)
//
//        https://davtb-teachbase.api.eric.s3storage.ru/material_images/0c33b08b2c61a1e43c76dc7f37c24ea2a912fc69.png
//        Рисунок 1. Пример для задачи 8
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
    }
}