package org.perscholas.springdrinkApp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the alcohol database table.
 * 
 */
@Entity
@Table(name="Alcohol")
public class Alcohol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(columnDefinition="bit default 0")
	private boolean approved = false;
	

	@Column(name="Category_Id")
	private Long catId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdded;

	private String description;

	private String name;

	private String pic;

	private String type;
	
	@Column(name="user_Id")
	private Long userId;

	// bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name = "user_Id",referencedColumnName="id", insertable=false, updatable=false)
	private Account account;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="Category_Id",referencedColumnName="id", insertable=false, updatable=false)
	private Category category;

	// bi-directional many-to-one association to Comment
	@OneToMany(mappedBy = "alcohol")
	private List<Comment> comments;

	// bi-directional many-to-one association to Like
	@OneToMany(mappedBy = "alcohol")
	private List<Like> likes;

	// bi-directional many-to-one association to Star
	@OneToMany(mappedBy = "alcohol")
	private List<Star> stars;

	// bi-directional many-to-many association to Tag
	@ManyToMany(mappedBy = "alcohols")
	private List<Tag> tags;
	
	public Alcohol() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getApproved() {
		return this.approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Long getCatId() {
		return this.catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setAlcohol(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setAlcohol(null);

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
		like.setAlcohol(this);

		return like;
	}

	public Like removeLike(Like like) {
		getLikes().remove(like);
		like.setAlcohol(null);

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
		star.setAlcohol(this);

		return star;
	}

	public Star removeStar(Star star) {
		getStars().remove(star);
		star.setAlcohol(null);

		return star;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public double getRating(Long id) {
		double x = 0.0;
		double i=0.0;
		for (Star s : stars) {
			if(s.getAlcoholId()==id) {
				x+=s.getNumber();
				i++;
			}
		}
		if(x>0&&i>0) {
		return x/i;
		}
		return 0;
	}
	public int getLikes(Long id) {
		int i=0;
		for (Like like : likes) {
			if(like.getAlcoholId()==id) {
				i++;
			}
		}
		return i;
	}
	public String getUserName(Long id) {
		Account acc = new Account();
		String r ="";
		r=acc.getUserNameById(id);
		return r;
	}
	@Override
	public String toString() {
		return "Alcohol [id=" + id + ", approved=" + approved + ", catId=" + catId + ", dateAdded=" + dateAdded
				+ ", description=" + description + ", name=" + name + ", pic=" + pic + ", type=" + type + ", userId="
				+ userId +  getUserName(userId)+ comments.toString()+"stars"+ stars+ getRating(id)+"Likes"+ getLikes(id);
	}
}