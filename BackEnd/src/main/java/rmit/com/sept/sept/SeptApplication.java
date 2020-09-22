package rmit.com.sept.sept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


@EnableAutoConfiguration
@SpringBootApplication
public class SeptApplication {
	
	public static String sqlPassword = "Susstain098.";
	
	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String encodedPassword = passwordEncoder.encode("password");
		
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/sept?useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true";
			Connection conn = DriverManager.getConnection(url, "root", sqlPassword);
			Statement st = conn.createStatement();
			st.executeUpdate(
					"INSERT IGNORE INTO user(user_id,email,lastname,firstname, password, status)VALUES(6,'admin2@admin2.com','admin2','admin2','"
							+ encodedPassword + "','VERIFIED')");
			st.executeUpdate("INSERT IGNORE INTO role(role_id,role_desc,role_name)VALUES(1,'ADMIN_USER','ADMIN_USER')");
			st.executeUpdate("INSERT IGNORE INTO role(role_id,role_desc,role_name)VALUES(2,'SITE_USER','SITE_USER')");
			st.executeUpdate("INSERT IGNORE INTO auth_user_role(auth_user_id,auth_role_id) VALUES (6,1)");
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		SpringApplication.run(SeptApplication.class, args);
	}

}
