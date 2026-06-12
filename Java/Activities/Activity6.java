package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {

		Plane plane = new Plane(10);
		plane.onboard("Rakhi");
		plane.onboard("Rashmi");
		plane.onboard("saheli");
		System.out.println("Take off time : "+plane.takeOff());
		System.out.println("List of passengers : "+plane.getPassesngers());
		Thread.sleep(5000);
		plane.land();
		

	}

}


class Plane {
	
    private  List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    
    Plane(int maxPassengers){
    	
    	this.passengers = new ArrayList<String>(0);
    	this.maxPassengers = maxPassengers;
    }
    
    public void onboard(String name) {
    	if(this.passengers.size() <= this.maxPassengers) 
    		this.passengers.add(name);
    	else
    		System.out.println("Plane is full");
    	
    }
    
    public Date takeOff() {
    	this.lastTimeTookOf = new Date();
    	return this.lastTimeTookOf;
    }
    
    public void land() {
    	this.lastTimeLanded = new Date();
    	this.passengers.clear();
    	System.out.println("the time of landing : "+this.lastTimeLanded);
    }
    
    public Date getLastTimeLanded() {
    	return this.lastTimeLanded;
    }
    
    public List<String> getPassesngers(){
    	return this.passengers;
    }
}