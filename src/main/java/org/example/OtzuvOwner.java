package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Arrays;
import java.util.List;

@Configuration
@DependsOn({"bean1_Task6","bean2_Task6","bean3_Task6"})
public class OtzuvOwner {
    @Autowired
    List<Otzuv> lst;

    @Autowired
    ApplicationContext context;


    @Bean("bean_Task7_cnt")
    @DependsOn({"bean1_Task6","bean2_Task6","bean3_Task6"})
    Integer lstCnt(){

        System.out.println(" lst.toArray().toString() = " + Arrays.toString(lst.toArray()));

        return new Integer(lst.size());
    };

    @Bean("bean_Task7")
    @DependsOn({"bean1_Task6","bean2_Task6","bean3_Task6"})
    Otzuv Otzuv2(){

        Otzuv maxOtzuv = null;
        for (Otzuv objLst : lst)
        {
            if (maxOtzuv == null)
                maxOtzuv = objLst;

            if (maxOtzuv == null)
                continue;

            if (objLst != null)
                if (objLst.rate != null)
                    if (objLst.rate == null)
                        continue;
                    else if (maxOtzuv.rate == null)
                        maxOtzuv = objLst;
                    else if (maxOtzuv.rate < objLst.rate)
                        maxOtzuv = objLst;

                    System.out.println("maxOtzuv.rate " + maxOtzuv.rate + " objLst.rate " + objLst.rate);
 //                   if (maxOtzuv.rate < objLst.rate)
 //                       maxOtzuv = objLst;

            System.out.println(objLst);
        }
//        return new Otzuv("Сойдёт",3);
//        return context.getBean("bean2_Task6",Otzuv.class);
        return maxOtzuv;
    };
}
