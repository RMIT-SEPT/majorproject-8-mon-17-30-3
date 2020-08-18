package rmit.com.sept.sept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAutoConfiguration
@SpringBootApplication
public class SeptApplication {

	public static void main(String[] args) {
		try { 
			String url = "jdbc:mysql://localhost:3306/sept?useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true"; 
	        Connection conn = DriverManager.getConnection(url,"root","ronaldo7!!"); 
	        Statement st = conn.createStatement(); 
	        st.executeUpdate("INSERT INTO role(role_id,role_desc,role_name)VALUES(2,'SITE_USER','SITE_USER')");
	        st.executeUpdate("INSERT INTO role(role_id,role_desc,role_name)VALUES(1,'ADMIN_USER','ADMIN_USER')");
	        
	        conn.close();
		} catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        }
		SpringApplication.run(SeptApplication.class, args);
	}

}
