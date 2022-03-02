package com.nealdennis.wodtracker;

import java.sql.*;
import java.util.Random;

public class wodAPI {
    String wodName;
    Connection con = null;
    Statement stmt = null;

   public wodAPI() {
       connectToDB();
   }

   public void setWodName(String inName) {
       wodName = inName;
   }

   public String getWOD() {
        return wodName;
    }

    private void connectToDB() {
       try {
           String psqlUrl = "jdbc:postgresql://localhost:5432/wodtracker";
           con = DriverManager.getConnection(psqlUrl, "postgres", "toolkit");

           stmt = con.createStatement();

           ResultSet maxSet = stmt.executeQuery( "select MAX(wod_id) from public.\"wod\";" );
           maxSet.next();
           int max = maxSet.getInt("max");
           Random r = new Random();
           int randomInt = r.nextInt(max) + 1;

           ResultSet rs = stmt.executeQuery( "select * from public.\"wod\" where wod_id = " + randomInt + ";" );

           while (rs.next()) {

               String name = rs.getString("name");
               String description = rs.getString("description");

               if (name != null) {
                   System.out.println(name);
                   System.out.print(description);
                   System.out.println();
               }
           }

           rs.close();
           stmt.close();
           con.close();

       } catch (SQLException e) {
           e.printStackTrace();
       }

    }
}
