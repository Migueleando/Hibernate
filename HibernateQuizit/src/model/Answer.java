package model;

// Generated 18-feb-2015 18:33:03 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Answer generated by hbm2java
 */
public class Answer implements java.io.Serializable {

    private int idAnswer;
    private Question question;
    private String text;
    private Boolean isCorrect;
    private Set users = new HashSet(0);

    public Answer() {
    }

    public Answer(int idAnswer, Question question) {
	this.idAnswer = idAnswer;
	this.question = question;
    }

    public Answer(int idAnswer, Question question, String text,
	    Boolean isCorrect, Set users) {
	this.idAnswer = idAnswer;
	this.question = question;
	this.text = text;
	this.isCorrect = isCorrect;
	this.users = users;
    }

    public int getIdAnswer() {
	return this.idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
	this.idAnswer = idAnswer;
    }

    public Question getQuestion() {
	return this.question;
    }

    public void setQuestion(Question question) {
	this.question = question;
    }

    public String getText() {
	return this.text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public Boolean getIsCorrect() {
	return this.isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
	this.isCorrect = isCorrect;
    }

    public Set getUsers() {
	return this.users;
    }

    public void setUsers(Set users) {
	this.users = users;
    }

}