package com.nealdennis.wodtracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class wodAPI {
    String wodName;

   public wodAPI() {
       setWodName("Annie");
       connectToDB();
   }

   public void setWodName(String inName) {
       wodName = inName;
   }

    public String getWOD() {
        return wodName;
    }

    private void connectToDB() {
//       try {
//           registerDriver();
//       }

        //Getting the connection
//        String mysqlUrl = "jdbc:mysql://localhost/mydatabase";
//        Connection con = DriverManager.getConnection(mysqlUrl, "root", "password");
//        System.out.println("Connection established: "+con);
    }
}
