package Frontend;

public class payments {
	int meterId;
	double amount;
	
	
	public int getMeterId() {
		return meterId;
	}

	public void setMeterId(int meterId) {
		this.meterId = meterId;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public payments(int meterId, double d) {
		super();
		this.meterId = meterId;
		this.amount = d;
	
	}

}