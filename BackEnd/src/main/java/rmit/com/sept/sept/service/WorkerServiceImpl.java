package rmit.com.sept.sept.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rmit.com.sept.sept.Company;
import rmit.com.sept.sept.Worker;

import rmit.com.sept.sept.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	WorkerRepository workerRepository;
	
	
	
	@Override
	public void saveWorker(Worker worker) {
		workerRepository.save(worker);
		
	}
	
	@Override
	public List<Company> list() throws SQLException {
        List<Company> listCategory = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/sept?useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true"; 
        String user = "root";
        String password = "ronaldo7!!";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT company_name FROM company";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                
                String name = result.getString("company_name");
                Company company = new Company(name);
                     
                listCategory.add(company);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return listCategory;
    }

}
