package manager;

import java.security.Timestamp;

public class Post {

	private Integer postId;
	private String text;
	private int totalUpVote;
	private int totalDownVote;
	private Integer userId;
	private Timestamp creationPostTime;

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTotalUpVote() {
		return totalUpVote;
	}

	public void setTotalUpVote(int totalUpVote) {
		this.totalUpVote = totalUpVote;
	}

	public int getTotalDownVote() {
		return totalDownVote;
	}

	public void setTotalDownVote(int totalDownVote) {
		this.totalDownVote = totalDownVote;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getCreationPostTime() {
		return creationPostTime;
	}

	public void setCreationPostTime(Timestamp creationPostTime) {
		this.creationPostTime = creationPostTime;
	}

}
