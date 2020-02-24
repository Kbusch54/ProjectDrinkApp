package org.perscholas.springdrinkApp.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the likes database table.
 * 
 */
@Entity
@Table(name = "likes")
public class Like implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="alcohol_Id")
	private Long alcoholId;
	
	@Column(name="user_Id")
	private Long userId;

	@Column(name="comment_Id")
	private Long commentId;


	// bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name = "user_Id", referencedColumnName="id", insertable=false, updatable=false)
	private Account account;

	// bi-directional many-to-one association to Alcohol
	@ManyToOne
	@JoinColumn(name="alcohol_Id",referencedColumnName="id", insertable=false, updatable=false)
	private Alcohol alcohol;

	// bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="comment_Id",referencedColumnName="id", insertable=false, updatable=false)
	private Comment comment;

	public Like() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAlcoholId() {
		return this.alcoholId;
	}

	public void setAlcoholId(Long alcoholId) {
		this.alcoholId = alcoholId;
	}

	public Long getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
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

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", alcoholId=" + alcoholId + ", userId=" + userId + ", commentId=" + commentId;
	}

}