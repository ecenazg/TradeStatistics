package io.smartpulse.internship.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton definition of Connection
 * Bill Pugh singleton implementation
 * startDate and endDate are read from config.properties file
 */
public class Connection {

    // Private constructor
    private Connection() {}

    // Helper class of Bill Pugh approach
    private static class ConnectionHelper {

        private static String startDate;
        private static String endDate;
        private static final HttpURLConnection conn;

        private static Logger logger = Logger.getLogger(ConnectionHelper.class.getName());
        private static final String apiUrl = "https://seffaflik.epias.com.tr/transparency/service/market/intra-day-trade-history";

        static {
            loadProperties();
            try {
                URL url = new URL(createURLString(startDate, endDate));
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    logger.log(Level.SEVERE, "Connection failed with response code: " + conn.getResponseCode());
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }
            } catch (ProtocolException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            logger.log(Level.INFO, "Successfully connected");
        }

        private static String createURLString(String startDate, String endDate) {
            return apiUrl + "?endDate=" + endDate + "&startDate=" + startDate;
        }

        // Read properties file
        private static void loadProperties() {
            try (InputStream input = Connection.class.getClassLoader().getResourceAsStream("config.properties")) {

                Properties prop = new Properties();

                if (input == null) {
                    System.out.println("Sorry, unable to find config.properties");
                    return;
                }
                //load a properties file from class path, inside static method
                prop.load(input);

                //get the property value and set startDate and endDate
                startDate = prop.getProperty("startDate");
                endDate = prop.getProperty("endDate");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public static HttpURLConnection getConnection() {
            return conn;
        }

        public static void closeConnection() {
            conn.disconnect();
        }
    }

    // The method reachable from outside
    public static HttpURLConnection getConnection() {
        return ConnectionHelper.getConnection();
    }

    // The method reachable from outside
    public static void closeConnection() {
        ConnectionHelper.closeConnection();
    }

}
