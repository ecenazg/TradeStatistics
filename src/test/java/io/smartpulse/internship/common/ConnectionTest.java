package io.smartpulse.internship.common;


import io.smartpulse.internship.common.Connection;
import java.io.IOException;
import java.net.HttpURLConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ConnectionTest {

    static HttpURLConnection con;

    @BeforeAll
    static void init() {
        con = Connection.getConnection();
    }

    @Test
    void statusTest() throws IOException {
        Assertions.assertEquals(con.getResponseCode(), 200);
    }

    @Test
    void urlTest() throws IOException {
        System.out.println("here");
        Assertions.assertTrue(con.getURL().toString().startsWith("https://seffaflik.epias.com.tr/transparency/service/market/intra-day-trade-history"));

    }

    @Test
    void methodTest() throws IOException {
        Assertions.assertEquals(con.getRequestMethod(),"GET");
    }
    @AfterAll
    static void tearDown() {
        Connection.closeConnection();
    }
}
