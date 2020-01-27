package aula12ex1;

public class AdBlocker implements IPlugin{
	
	private int adsBlocked;
	private int knownUsers;
	private double timeSaved;
	private static int i = 0;
	
	public AdBlocker() {
		this.adsBlocked = 0;
		i++;
		this.knownUsers = i;
		this.timeSaved = 0;
	}

	@Override
	public void fazQualQuerCoisa() {
		System.out.println("Ad Blocked!");
		this.adsBlocked++;
		this.timeSaved+=0.3;
	}

	public int getAdsBlocked() {
		return adsBlocked;
	}

	public void setAdsBlocked(int adsBlocked) {
		this.adsBlocked = adsBlocked;
	}

	public int getKnownUsers() {
		return knownUsers;
	}

	public void setKnownUsers(int knownUsers) {
		this.knownUsers = knownUsers;
	}

	public double getTimeSaved() {
		return timeSaved;
	}

	public void setTimeSaved(double timeSaved) {
		this.timeSaved = timeSaved;
	}
	
	public String toString() {
		return "Outstanding Ad Blocker, 10/10";
	}

}
