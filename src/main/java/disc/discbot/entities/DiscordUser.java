package disc.discbot.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DiscordUser {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
	private Integer userID;
	    
    @Column(name="user_name")
    private String userName;

    
    public int getUserId() {
		return userID;
	}
	public void setUserId(int userId) {
		this.userID = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
