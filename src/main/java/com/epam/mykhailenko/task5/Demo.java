package com.epam.mykhailenko.task5;

import com.epam.mykhailenko.task5.methods.MethodsForEmbeddedDB;
import com.epam.mykhailenko.task5.methods.MethodsWithPoolConnection;
import com.epam.mykhailenko.task5.methods.MethodsWithSimpleConnection;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public class Demo {
    public static void main(String[] args) {
        // part 2
        MethodsWithSimpleConnection db = new MethodsWithSimpleConnection();
        db.findAllAndReturnList();

        // part 3
        MethodsWithPoolConnection db2 = new MethodsWithPoolConnection();
        db2.findAllAndReturnList();

        // part 5
        try {
            db2.findAllAndReturnListWithThreadPool();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // part 4
        MethodsForEmbeddedDB db3 = new MethodsForEmbeddedDB();
        db3.createTable();
        db3.addDataToTable();
        db3.findAllAndReturnList();


    }
}
