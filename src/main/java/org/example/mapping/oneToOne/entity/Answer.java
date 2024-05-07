package org.example.mapping.oneToOne.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "answer_info")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "answer_id")
    private int answerId;
    @Column(name = "answer_name")
    private String answerName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "question_id",name = "question_id")
    private Question question;


    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answerName='" + answerName + '\'' +
                ", question=" + question +
                '}';
    }

}
