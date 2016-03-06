package com.kholodkov.ido.db;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnectionTest {

    @Test
    public void dbConnectionOk() throws SQLException {
        String connectMessage = null;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection("jdbc:h2:~/ido", "ido", "123");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT tc.ConnectionMessage FROM TestDBConnections tc WHERE tc.ConnectionID = 1;");
            while (rs.next()) {
                connectMessage = rs.getNString("ConnectionMessage");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ignore) {}
        }


        Assert.assertEquals(connectMessage, "Test DB Connection Success");
    }
}
