package com.epam.mykhailenko.task5;

import com.epam.mykhailenko.task5.methods.MethodsWithPoolConnection;
import com.epam.mykhailenko.task5.methods.MethodsWithSimpleConnection;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public class Demo {
    public static void main(String[] args) {
        MethodsWithSimpleConnection db = new MethodsWithSimpleConnection();
        db.findAllAndReturnList();

        MethodsWithPoolConnection db2 = new MethodsWithPoolConnection();
        db2.findAllAndReturnList();


    }
}
