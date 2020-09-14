package rmit.com.sept.sept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableAutoConfiguration
@SpringBootApplication
public class SeptApplication {
	private static WebMvcConfig web;
	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
		String encodedPassword = passwordEncoder.encode("password");
//		System.out.print(encodedPassword);
		try { 
			String url = "jdbc:mysql://127.0.0.1:3306/sept?useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true"; 
	        Connection conn = DriverManager.getConnection(url,"root","ronaldo7!!"); 
	        Statement st = conn.createStatement(); 
	        st.executeUpdate("INSERT IGNORE INTO user(user_id,email,lastname,firstname, password, status)VALUES(6,'admin2@admin2.com','admin2','admin2','"+ encodedPassword +"','VERIFIED')");
	        st.executeUpdate("INSERT IGNORE INTO role(role_id,role_desc,role_name)VALUES(1,'ADMIN_USER','ADMIN_USER')");
	        st.executeUpdate("INSERT IGNORE INTO role(role_id,role_desc,role_name)VALUES(2,'SITE_USER','SITE_USER')");
	        st.executeUpdate("INSERT IGNORE INTO auth_user_role(auth_user_id,auth_role_id) VALUES (6,1)");
	    
//	        st.executeQuery("select u.email, r.role_name from user u inner join auth_user_role ur on(u.user_id=ur.auth_user_id) inner join role r on(ur.auth_role_id=r.role_id)");

	        conn.close();
		} catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        }
		SpringApplication.run(SeptApplication.class, args);
	}

}
