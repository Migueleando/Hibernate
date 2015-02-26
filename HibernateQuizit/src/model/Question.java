package model;

// Generated 26-feb-2015 17:12:36 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Question generated by hbm2java
 */
public class Question implements java.io.Serializable {

    private int idQuestion;
    private String questionText;
    private String category;
    private Set answers = new HashSet(0);
    private Set tests = new HashSet(0);

    public Question() {
    }

    public Question(int idQuestion, String questionText, String category) {
	this.idQuestion = idQuestion;
	this.questionText = questionText;
	this.category = category;
    }

    public Question(int idQuestion, String questionText, String category,
	    Set answers, Set tests) {
	this.idQuestion = idQuestion;
	this.questionText = questionText;
	this.category = category;
	this.answers = answers;
	this.tests = tests;
    }

    public int getIdQuestion() {
	return this.idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
	this.idQuestion = idQuestion;
    }

    public String getQuestionText() {
	return this.questionText;
    }

    public void setQuestionText(String questionText) {
	this.questionText = questionText;
    }

    public String getCategory() {
	return this.category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public Set getAnswers() {
	return this.answers;
    }

    public void setAnswers(Set answers) {
	this.answers = answers;
    }

    public Set getTests() {
	return this.tests;
    }

    public void setTests(Set tests) {
	this.tests = tests;
    }

}
