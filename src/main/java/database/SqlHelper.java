package database;

import database.model.Status;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlHelper {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PASSWORD;

    static {
        Properties properties = new Properties();
        try {
            InputStream in = new FileInputStream("application.properties");
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DB_URL = properties.getProperty("spring.datasource.url");
        DB_USER = properties.getProperty("spring.datasource.username");
        DB_PASSWORD = properties.getProperty("spring.datasource.password");
    }


    public static void clearAllData() {
        var runner = new QueryRunner();
        try (var conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            runner.update(conn, "DELETE FROM credit_request_entity;");
            runner.update(conn, "DELETE FROM payment_entity;");
            runner.update(conn, "DELETE FROM order_entity;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void checkPaymentStatus(Status status) {
        var runner = new QueryRunner();
        try (var conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            var paymentDataSQL = "SELECT status FROM payment_entity;";
            var paymentStatus = runner.query(conn, paymentDataSQL, new ScalarHandler<String>());
            assertEquals(status.name(), paymentStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void checkCreditStatus(Status status) {
        var runner = new QueryRunner();
        try (var conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            var creditDataSQL = "SELECT status FROM credit_request_entity;";
            var creditStatus = runner.query(conn, creditDataSQL, new ScalarHandler<String>());
            assertEquals(status.name(), creditStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}