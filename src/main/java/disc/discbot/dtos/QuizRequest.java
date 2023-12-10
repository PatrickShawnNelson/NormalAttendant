package disc.discbot.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizRequest {
    private String quizName;
    private String userName;
	
	public String getQuizName() {
		return quizName;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
}
