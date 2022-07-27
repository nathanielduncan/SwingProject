package Data;

import java.sql.*;

public class dataAccess {
    //This class is the SQL level of the data access framework.

    public static ResultSet getAllRaces() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:./src/Data/ogl.db");

            Statement stmt = conn.createStatement();
            return stmt.executeQuery("SELECT * FROM races;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getAllClasses() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:./src/Data/ogl.db");

            Statement stmt = conn.createStatement();
            return stmt.executeQuery("SELECT * FROM classes;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getAllBackgrounds() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:./src/Data/ogl.db");

            Statement stmt = conn.createStatement();
            return stmt.executeQuery("SELECT * FROM backgrounds;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSetMetaData getClassColumns() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:./src/Data/ogl.db");
            Statement stmt = conn.createStatement();

            ResultSet results = stmt.executeQuery("SELECT * FROM classes");
            return results.getMetaData();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSetMetaData getRaceColumns() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:./src/Data/ogl.db");
            Statement stmt = conn.createStatement();

            ResultSet results = stmt.executeQuery("SELECT * FROM races");
            return results.getMetaData();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSetMetaData getBackGColumns() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:./src/Data/ogl.db");
            Statement stmt = conn.createStatement();

            ResultSet results = stmt.executeQuery("SELECT * FROM backgrounds");
            return results.getMetaData();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void putNewCharacter(PlayerCharacter pc) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:./src/Data/PCCharacters.db");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO characters VALUES ('" + pc.getClas() + "', '" + pc.getRace() + "', '" + pc.getBackground() + "', '" +
            pc.getStrength() + "', '" + pc.getDexterity() + "', '" + pc.getConstitution() + "', '" + pc.getIntelligence() + "', '" + pc.getWisdom() + "', '" + pc.getCharisma() + "')";

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
