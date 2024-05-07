package Java13.config;

import Java13.entity.UserDetails;
import Java13.entity.UserProfile;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class DatabaseConfig {

    public static Properties properties() {
        Properties properties = new Properties();
        properties.setProperty(Environment.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.JAKARTA_JDBC_USER, "postgres");
        properties.setProperty(Environment.JAKARTA_JDBC_PASSWORD, "postgres");
        properties.setProperty(Environment.HBM2DDL_AUTO, "create");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.FORMAT_SQL, "true");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

        return properties;
    }

    public static EntityManagerFactory entityManagerFactory() {
        Configuration configuration = new Configuration();
        configuration.addProperties(properties());

        configuration.addAnnotatedClass(UserDetails.class);
        configuration.addAnnotatedClass(UserProfile.class);

        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
