package com.example.demo.model;

import java.time.LocalDate;

public class ListStudent {

	private int id;
	private int no;
	private String code;
	private String name;
	private LocalDate birthday;
	private String address;
	private double score;

	public ListStudent() {}

	public ListStudent(int id, int no, String code, String name, LocalDate birthday, String address, double score) {
		super();
		this.id = id;
		this.no = no;
		this.code = code;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.score = score;
	}
	
	public ListStudent(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ListStudent [code= " + code + "name= " + name + " birthday= " + birthday + "address=" + address+ "score="+ score +"]";
	}

}
