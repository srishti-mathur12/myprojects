package manager;

import java.util.HashSet;

public class User {
	private String userId;
	private String Name;

	private String contactNum;
	private String email;
	private String logOnName;
	private String password;
	private String address;

	private HashSet<Integer> following;
	private HashSet<Integer> memberFollows;
	private HashSet<Integer> posted;

	public User() {
		LRU userTimeline = new LRU(10);

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogOnName() {
		return logOnName;
	}

	public void setLogOnName(String logOnName) {
		this.logOnName = logOnName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public HashSet<Integer> getFollowing() {
		return following;
	}

	public void setFollowing(Integer integer) {
		// this.following = integer;
		following.add(integer);
	}

	public HashSet<Integer> getMemberFollows() {
		return memberFollows;
	}

	public void setMemberFollows(Integer integer) {
		// this.memberFollows = memberFollows;
		memberFollows.add(integer);
	}

	public HashSet<Integer> getPosted() {
		return posted;
	}

	public void setPosted(Integer integer) {
		posted.add(integer);
	}

}
