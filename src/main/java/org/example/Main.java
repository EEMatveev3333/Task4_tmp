package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        ApplicationContext context =
                new AnnotationConfigApplicationContext("org.example");

        //context.registerBean(Integer.class,5);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////
        // 1 task
        String Str = context
                .getBean("GetStrBean",String.class);
                //.GetStrBean();
        System.out.println("Str - " + Str);

        ////////////////////////////////////////
        // 2 task
        Date date = context
                .getBean("GetDateBean",Date.class);
        //.GetStrBean();
        System.out.println("date - " + date);

        ////////////////////////////////////////
        // 3 task
        Predicate<Integer> PredInt = context
                .getBean("GetPredicateInteger",Predicate.class);
        //.GetStrBean();
        System.out.println("PredInt.test(1) - " + PredInt.test(1));
        System.out.println("PredInt.test(5) - " + PredInt.test(5));

        Predicate<Integer> PredInt2 = context
                .getBean("GetPredicateInteger2",Predicate.class);
        //.GetStrBean();
        System.out.println("PredInt2.test(1) - " + PredInt2.test(1));
        System.out.println("PredInt2.test(5) - " + PredInt2.test(5));

        ////////////////////////////////////////
        // 4 task
        Integer min = context
                .getBean("min",Integer.class);
        //.GetStrBean();
        System.out.println("min - " + min);

        Integer max = context
                .getBean("max",Integer.class);
        //.GetStrBean();
        System.out.println("max - " + max);

        ////////////////////////////////////////
        // 5 task
        Integer Shuffle = context
                .getBean("RandomIntWithConditions",Integer.class);
        //.GetStrBean();
        System.out.println("Shuffle_1pass - " + Shuffle);

        Shuffle = context
                .getBean("RandomIntWithConditions",Integer.class);
        //.GetStrBean();
        System.out.println("Shuffle_2pass - " + Shuffle);

        Shuffle = context
                .getBean("RandomIntWithConditions",Integer.class);
        //.GetStrBean();
        System.out.println("Shuffle_3pass - " + Shuffle);
        ////////////////////////////////////////
        // 6 task

        ////////////////////////////////////////
        // 7 task

        ////////////////////////////////////////
        // 8 task

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
    }
}