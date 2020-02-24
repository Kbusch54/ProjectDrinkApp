package org.perscholas.springdrinkApp.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the stars database table.
 * 
 */
@Entity
@Table(name = "stars")
public class Star implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="ALCOHOL_ID")
	private Long alcoholId;

	private int number;

	@Column(name="user_Id")
	private Long userId;

	// bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name = "user_Id",referencedColumnName="id", insertable=false, updatable=false)
	private Account account;

	// bi-directional many-to-one association to Alcohol
	@ManyToOne
	@JoinColumn(name="ALCOHOL_ID",referencedColumnName="id", insertable=false, updatable=false)
	private Alcohol alcohol;

	public Star() {
	}

	public Long getAlcoholId() {
		return this.alcoholId;
	}

	public void setAlcoholId(Long alcoholId) {
		this.alcoholId = alcoholId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Alcohol getAlcohol() {
		return this.alcohol;
	}

	public void setAlcohol(Alcohol alcohol) {
		this.alcohol = alcohol;
	}

	
	@Override
	public String toString() {
		return "Starnumber=" + number + ", userId=" + userId;
	}

}