package disc.discbot.entities;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Quiz {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quiz_id")
	private Integer quizID;
	    
    @Column(name="quiz_name")
    private String quizName;
    
    @Column(name="user_id")
    private Integer userID;
    
    /*@OneToMany(mappedBy="questions", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List <QuizQuestions> questions;*/
    
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="quiz_question_junction",
			joinColumns = {@JoinColumn(name="quiz_id")},
			inverseJoinColumns = {@JoinColumn(name="question_id")}
			)
    private List <QuizQuestions> questions;
    
    public String getQuizName() {
		return quizName;
	}
    
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	
	public Integer getUserID() {
		return userID;
	}
    
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
}
