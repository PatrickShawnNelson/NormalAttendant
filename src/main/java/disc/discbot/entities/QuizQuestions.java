package disc.discbot.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuizQuestions {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	private Integer questionID;
	    
    @Column(name="quiz_question")
    private String question;
    
    @Column(name="quiz_id")
    private Integer quizID; 
}
