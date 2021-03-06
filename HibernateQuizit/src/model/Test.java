package model;

// Generated 26-feb-2015 17:12:36 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Test generated by hbm2java
 */
public class Test implements java.io.Serializable {

    private int id;
    private String name;
    private String date;
    private Integer score;
    private Integer numberQuestions;
    private Set users = new HashSet(0);
    private Set questions = new HashSet(0);

    public Test() {
    }

    public Test(int id) {
	this.id = id;
    }

    public Test(int id, String name, String date, Integer score,
	    Integer numberQuestions, Set users, Set questions) {
	this.id = id;
	this.name = name;
	this.date = date;
	this.score = score;
	this.numberQuestions = numberQuestions;
	this.users = users;
	this.questions = questions;
    }

    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDate() {
	return this.date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public Integer getScore() {
	return this.score;
    }

    public void setScore(Integer score) {
	this.score = score;
    }

    public Integer getNumberQuestions() {
	return this.numberQuestions;
    }

    public void setNumberQuestions(Integer numberQuestions) {
	this.numberQuestions = numberQuestions;
    }

    public Set getUsers() {
	return this.users;
    }

    public void setUsers(Set users) {
	this.users = users;
    }

    public Set getQuestions() {
	return this.questions;
    }

    public void setQuestions(Set questions) {
	this.questions = questions;
    }

}
