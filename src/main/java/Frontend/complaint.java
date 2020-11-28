package Frontend;

public class complaint {
	int meterId;
	String type, remark, status;
	
	
	public int getMeterId() {
		return meterId;
	}

	public void setMeterId(int meterId) {
		this.meterId = meterId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public String getRemark() {
		return remark;
	}

	public String getStatus() {
		return status;
	}

	public complaint(int meterId, String type, String remark, String status) {
		super();
		this.meterId = meterId;
		this.type = type;
		this.remark = remark;
		this.status = status;
	}

}