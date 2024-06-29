package kata5.software.ulpgc.es;

import db.kata5.software.ulpgc.es.*;
import http.kata5.software.ulpgc.es.*;
import model.kata5.software.ulpgc.es.CSVFileLoader;
import model.kata5.software.ulpgc.es.F1DriverRegister;
import spark.Spark;

import java.io.File;
import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<F1DriverRegister> registers = CSVFileLoader
                .with(new File("drivers_updated.csv"))
                .load();

        Connection connection = DatabaseConnector.connect();
        if(connection != null){
            TableManagerF1Championship.createTable(connection);
            new DataInserter().insertDriverRegisters(registers, connection);
        }


    }

}