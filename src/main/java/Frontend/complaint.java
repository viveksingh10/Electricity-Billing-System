package Frontend;

public class complaint {
	int meterID;
	String type, remark, status;
	
	public void setAccno(int meterID) {
		this.meterID = meterID;
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

	public int getmeterID() {
		return meterID;
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

	public complaint(int meterID, String type, String remark, String status) {
		super();
		this.meterID = meterID;
		this.type = type;
		this.remark = remark;
		this.status = status;
	}

}

