package rmit.com.sept.sept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
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
	        st.executeQuery("select u.email, r.role_name from user u inner join auth_user_role ur on(u.user_id=ur.auth_user_id) inner join role r on(ur.auth_role_id=r.role_id) where u.email=?");
	        conn.close();
		} catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        }
		SpringApplication.run(SeptApplication.class, args);
	}

}
