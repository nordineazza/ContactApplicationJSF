package entities;

public class ContactGroup {
	
	private int groupId;
	private String groupName;
	
	
	public ContactGroup() {
		super();

	}


	public ContactGroup(int groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}


	public int getGroupId() {
		return groupId;
	}


	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	@Override
	public String toString() {
		return "ContactGroup [groupId=" + groupId + ", groupName=" + groupName
				+ "]";
	}

}
