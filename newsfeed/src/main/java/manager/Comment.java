package manager;

public class Comment {

	private Integer commentId;
	private String text;
	private int totalUpVote;
	private int totalDownVote;
	private User user;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
