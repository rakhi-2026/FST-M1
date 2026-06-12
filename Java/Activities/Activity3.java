package activities;

public class Activity3 {

	public static void main(String[] args) {
		
		Activity3 obj = new Activity3();
		System.out.println(obj.adjustDevice(null,20));
		System.out.println(obj.adjustDevice("THERMOSTAT", 50));
		System.out.println(obj.adjustDevice("THERMOSTAT", 30));
		System.out.println(obj.adjustDevice("LIGHT", 60));
		System.out.println(obj.adjustDevice("Unknown", 60));
		

	}
	
	public String adjustDevice(String device, int value) {
		
		String status ;
		
		status = switch (device) {
	    case null -> "Error: No device detected.";

	    case String d when d.equals("THERMOSTAT") && value >= 40 ->
	            "[Thermostat] Warning: Temperature high.";

	    case String d when d.equals("THERMOSTAT") && value < 40 ->
	            "[Thermostat] Temperature is set to " + value;

	    case String d when d.equals("LIGHT") ->
	            "[Light] Adjusting brightness to " + value + "%.";

	    default -> "Unknown device given";
		};
		
		return status;
		
	}

}
