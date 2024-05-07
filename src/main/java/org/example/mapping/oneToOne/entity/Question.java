package org.example.mapping.oneToOne.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question_info")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "question_name")
    private String questionName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "answer_id",name = "answer_id")
    private Answer answer;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionName='" + questionName + '\'' +
                ", answer=" + answer +
                '}';
    }


}
