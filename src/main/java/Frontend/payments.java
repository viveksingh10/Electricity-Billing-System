package Frontend;

public class payments {
	int meterID,amount;
	
	public void setAccno(int meterID) {
		this.meterID = meterID;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getmeterID() {
		return meterID;
	}

	public int getAmount() {
		return amount;
	}

	public payments(int meterID, int amount) {
		super();
		this.meterID = meterID;
		this.amount = amount;
		
	}

}

