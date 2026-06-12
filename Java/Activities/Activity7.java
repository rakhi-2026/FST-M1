package activities;

	public class Activity7 {
	
		public static void main(String[] args) {
			MountainBike mb = new MountainBike(3, 0, 25);
		    System.out.println(mb.bicycleDesc());
		    mb.speedUp(20);
		    mb.applyBrake(5);
	
		}
	
	}

	interface BicycleParts{
		
		public int tyres = 2;
		public int maxSpeed = 25;
		
	}
	
	interface BicycleOperations{
		
		public void applyBrake(int decrement);
		public void speedUp(int increment);
	}
	
	class Bicycle implements BicycleParts,BicycleOperations{
		
		protected int gears;
		private int currentSpeed;
		
		Bicycle(int gears,int currentSpeed){
			
			this.gears = gears;
			this.currentSpeed = currentSpeed;
		
		}
		
		public void applyBrake(int decrement) {
			
			this.currentSpeed =  this.currentSpeed-decrement;
			System.out.println("Current speed: " + this.currentSpeed);
			
		}
		
		public void speedUp(int increment) {
			
			this.currentSpeed =  this.currentSpeed+increment;
			System.out.println("Current speed: " + this.currentSpeed);
			
		}
		
		public String bicycleDesc() {
		    return("No of gears are "+ gears + "\nSpeed of bicycle is " + maxSpeed);
		}
		
	}
	
	class MountainBike extends Bicycle{
		
		private int seatHeight;
		
		MountainBike(int gears, int currentSpeed,int seatHeight) {
			super(gears, currentSpeed);
			this.seatHeight = seatHeight;
		}
		
		public void setHeight(int newValue) {
		    this.seatHeight = newValue;
		}
		
		@Override
		public String bicycleDesc() {
		    return("No of gears are "+ super.gears + "\nSpeed of bicycle is " + super.maxSpeed + "\nSeat Height of bicycle is " + this.seatHeight);
		}
		
	}
