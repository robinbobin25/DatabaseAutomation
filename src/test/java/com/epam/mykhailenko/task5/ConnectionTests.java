package com.epam.mykhailenko.task5;

import com.epam.mykhailenko.task5.methods.MethodsForEmbeddedDB;
import com.epam.mykhailenko.task5.methods.MethodsWithPoolConnection;
import com.epam.mykhailenko.task5.methods.MethodsWithSimpleConnection;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by antonina_mykhailenko on 08.10.2015.
 */
public class ConnectionTests {
    List testList = null;

    @Test
    public void testsFindAllWithSimpleConnectionIsNotEmpty(){
        MethodsWithSimpleConnection db = new MethodsWithSimpleConnection();
        testList = db.findAllAndReturnList();
        assertFalse(testList.isEmpty());
    }

    @Test
    public void testsFindAllWithPoolConnectionIsNotEmpty(){
        MethodsWithPoolConnection db2 = new MethodsWithPoolConnection();
        testList = db2.findAllAndReturnList();
        assertFalse(testList.isEmpty());
    }

    @Test
    public void testsThatEmbeddedTableIsNotEmpty(){
        MethodsForEmbeddedDB db3 = new MethodsForEmbeddedDB();
        db3.createTable();
        db3.addDataToTable();
        testList = db3.findAllAndReturnList();
        assertFalse(testList.isEmpty());
    }
}
