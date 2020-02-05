
public class VeggieBurger extends Burger {
	private String pattyFlavor;
	private boolean hasTomatoes;
	private String breadType;
	private boolean isHealthier;
	private boolean hasCondiments;
	
	public VeggieBurger(){
		pattyFlavor = "black bean";
		hasTomatoes = false;
		breadType = "whole wheat";
		isHealthier= true;
		hasCondiments = false;
	}
	
	public VeggieBurger(boolean param_tomatoes){
		hasTomatoes = param_tomatoes;
	}

	public String getPattyFlavor() {
		return pattyFlavor;
	}

	public void setPattyFlavor(String pattyFlavor) {
		this.pattyFlavor = pattyFlavor;
	}

	public boolean isHasTomatoes() {
		return hasTomatoes;
	}

	public void setHasTomatoes(boolean hasTomatoes) {
		this.hasTomatoes = hasTomatoes;
	}

	public String getBreadType() {
		return breadType;
	}

	public void setBreadType(String breadType) {
		this.breadType = breadType;
	}

	public boolean isHealthier() {
		return isHealthier;
	}

	public void setHealthier(boolean isHealthier) {
		this.isHealthier = isHealthier;
	}

	public boolean isHasCondiments() {
		return hasCondiments;
	}

	public void setHasCondiments(boolean hasCondiments) {
		this.hasCondiments = hasCondiments;
	}
	
	
}
