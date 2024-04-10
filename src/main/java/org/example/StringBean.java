package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Configuration;
//        if (F1 == null) F1 = new java.util.Date();
@Configuration
public class StringBean {

    //@Autowired
    Integer Min_order = 2;

    //@Autowired
    Integer Max_order = 5;

    ArrayList<Integer> iList = new ArrayList<Integer>();

    public StringBean() {
        //Integer iMin_order = least();
        //Integer iMax_order = least();
    }

    @Bean("GetStrBean")
    String GetStrBean(){return new String("Hello world!");};

    @Bean("GetDateBean")
    Date GetDateBean(){return new java.util.Date();};

    @Bean("max")
    Integer GetIntMax(){
        //return new Integer(5);
        return new Integer(this.Max_order);
    };

    @Bean("min")
    Integer GetIntMin()
    {
        //return new Integer(2);
        return new Integer(this.Min_order);
    };

/*    @Bean("GetPredicateInteger")
    Predicate<Integer> GetPredicateInteger(){
        return new PredicateExample();
    };*/

    @Bean("GetPredicateInteger2")
    Predicate<Integer> GetPredicateInteger2(){
        Predicate<Integer> predicateExample = i -> (i <= 5 && i >= 2);
        return predicateExample;
    };


    @Bean("random")
    @DependsOn({"max","min"})
    @Scope("prototype")
    Integer RandomIntWithConditions(Integer max, Integer min)
    {

        int minValue = (min > 0) ? min : 0;     //  Integer.compare(min,0);
        int maxValue = (max < 99) ? max : 99;   //Integer.compare(max,99);
        if (!(iList.size() >= 1))
            for (int i = minValue; i<= maxValue; i++)
                iList.add(i);

        System.out.println(" iList.toArray().toString() = " + Arrays.toString(iList.toArray()));// listIterator() .toString());
        //System.out.println("  = " + iList.listIterator(). listIterator() .toString());

        //return new Integer(minValue + (int) (Math.random() * (maxValue - minValue + 1)));

        if (iList.size() >= 1) {
            Integer RandomShuffledIntegerIndex = 0 + (int) (Math.random() * (iList.size() - 1 - 0 + 1));
            //System.out.println("RandomShuffledIntegerIndex == " + RandomShuffledIntegerIndex);
            //return new Integer(iList.remove(RandomShuffledInteger));
            Integer RandomShuffledInteger = iList.get(RandomShuffledIntegerIndex);
            //System.out.println("RandomShuffledInteger == " + RandomShuffledInteger);
            //System.out.println("before iList.size() == " + iList.size());
            iList.remove(RandomShuffledInteger);
            //System.out.println("after iList.size() == " + iList.size());
            iList = new ArrayList<Integer>(iList);
            return new Integer(RandomShuffledInteger);
        }
        else
            return new Integer(null);


    };


}
