package com.project.dverse.entity;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String password;
	private String mailId;
	@OneToMany(mappedBy = "user")
    private Set<BookingEntity> bookings;
	public UserEntity() {
	}
		public UserEntity(long id, String userName, String password, String mailId, Set<BookingEntity> bookings) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.mailId = mailId;
		this.bookings = bookings;
	}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMailId() {
			return mailId;
		}
		public void setMailId(String mailId) {
			this.mailId = mailId;
		}
		
}

