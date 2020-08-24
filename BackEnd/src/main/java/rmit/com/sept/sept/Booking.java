package rmit.com.sept.sept;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

//import com.webencyclop.demo.model.Role;
//import com.sun.istack.NotNull;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int booking_id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;

	@NotNull(message="Service name is compulsory")
	@Column(name = "servicename")
	private String serviceName;

	@Column(name = "workerName")
	private String workerName;

	@Column(name = "status")
	private String status;

	@Column(name = "date")
	private Date date;

	@Column(name = "time")
	private Time time;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
//	private Set<Role> roles;

	public int getBookingId() {
		return booking_id;
	}

	public void setBookingId(int id) {
		this.booking_id = id;
	}

	public int getUserBookingId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String name) {
		this.serviceName = name;
	}


	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String name) {
		this.workerName = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDate(Date currentDate){
		this.date = currentDate;

	}

	public Date getDate(){
		return this.date;

	}

	public void setTime(Time time){
		this.time = time;
	}

	public Time getTime(){
		return this.time;

	}
}