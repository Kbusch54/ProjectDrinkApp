package org.perscholas.springdrinkApp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@Table(name="Account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;


	@Column(length=255)
	private String bio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_Added")
	private Date dateAdded;

	private String email;

	@Column(name="first_Name")
	private String fName;

	@Column(name="is_Admin",columnDefinition="bit default 0")
	private boolean isAdmin = false;


	@Column(name="last_Name")
	private String lName;


	@Column(nullable=false, length=255)
	private String password;

	@Column(length=255)
	private String picture;

	@Column(nullable=false, name="user_Name")
	private String userName;


	//bi-directional many-to-one association to Alcohol
	@OneToMany(mappedBy="account")
	private List<Alcohol> alcohols;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="account")
	private List<Comment> comments;

	//bi-directional many-to-one association to Like
	@OneToMany(mappedBy="account")
	private List<Like> likes;

	//bi-directional many-to-one association to Star
	@OneToMany(mappedBy="account")
	private List<Star> stars;

	public Account() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBio() {
		return this.bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}



	public Date getDate_Added() {
		return this.dateAdded;
	}

	public void setDate_Added(Date date_Added) {
		this.dateAdded = date_Added;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirst_Name() {
		return this.fName;
	}

	public void setFirst_Name(String first_Name) {
		this.fName = first_Name;
	}


	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIs_Admin(boolean is_Admin) {
		this.isAdmin = is_Admin;
	}

	public String getLName() {
		return this.lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getUser_Name() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Alcohol> getAlcohols() {
		return this.alcohols;
	}

	public void setAlcohols(List<Alcohol> alcohols) {
		this.alcohols = alcohols;
	}

	public Alcohol addAlcohol(Alcohol alcohol) {
		getAlcohols().add(alcohol);
		alcohol.setAccount(this);

		return alcohol;
	}

	public Alcohol removeAlcohol(Alcohol alcohol) {
		getAlcohols().remove(alcohol);
		alcohol.setAccount(null);

		return alcohol;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setAccount(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setAccount(null);

		return comment;
	}

	public List<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public Like addLike(Like like) {
		getLikes().add(like);
		like.setAccount(this);

		return like;
	}

	public Like removeLike(Like like) {
		getLikes().remove(like);
		like.setAccount(null);

		return like;
	}

	public List<Star> getStars() {
		return this.stars;
	}

	public void setStars(List<Star> stars) {
		this.stars = stars;
	}

	public Star addStar(Star star) {
		getStars().add(star);
		star.setAccount(this);

		return star;
	}

	public Star removeStar(Star star) {
		getStars().remove(star);
		star.setAccount(null);

		return star;
	}
	public String getUserNameById(Long Userid) {
		String r = "";
		if(Userid!=null) {
		if(id==Userid) {
			 r =getUser_Name();
		}
		}
		return r;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", bio=" + bio + ", dateAdded=" + dateAdded + ", email=" + email + ", fName="
				+ fName + ", isAdmin=" + isAdmin + ", lName=" + lName + ", password=" + password + ", picture="
				+ picture + ", userName=" + userName + ", alcohols=" + alcohols + ", comments=" + comments.toString() + ", likes="
				+ likes.toString() + ", stars=" + stars + "]";
	}

}