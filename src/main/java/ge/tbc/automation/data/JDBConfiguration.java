package ge.tbc.automation.data;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBConfiguration {
    public static final Properties properties = new Properties();

    static {
        try (InputStream inputStream= JDBConfiguration.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(inputStream);
        }catch (IOException e) {
                throw new RuntimeException(e);
        }
    }
    public static String getURL(){
        return properties.getProperty("db.url");
    }
    public static String getPassword(){
        return properties.getProperty("db.password");
    }
    public static String getUsername(){
        return properties.getProperty("db.username");
    }
}
