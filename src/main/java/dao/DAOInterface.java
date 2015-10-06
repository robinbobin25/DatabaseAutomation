package dao;

import entities.Station;

import java.util.ArrayList;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public interface DAOInterface {
    Station findAllAndReturnEntity();
    ArrayList<Station> findAllAndReturnList();
}
