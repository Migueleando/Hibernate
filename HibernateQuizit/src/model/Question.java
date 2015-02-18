package model;

// Generated 18-feb-2015 18:33:03 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Question generated by hbm2java
 */
public class Question implements java.io.Serializable {

    private int idQuestion;
    private String text;
    private String category;
    private Set answers = new HashSet(0);
    private Set tests = new HashSet(0);

    public Question() {
    }

    public Question(int idQuestion, String category) {
	this.idQuestion = idQuestion;
	this.category = category;
    }

    public Question(int idQuestion, String text, String category, Set answers,
	    Set tests) {
	this.idQuestion = idQuestion;
	this.text = text;
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

    public String getText() {
	return this.text;
    }

    public void setText(String text) {
	this.text = text;
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
