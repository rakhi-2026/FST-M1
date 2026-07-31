package activities;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.AppiumDriver;

public class ActionBase {
	
	private static PointerInput finger = new PointerInput(Kind.TOUCH,"finger");
	
	public static void doSwipe(AppiumDriver driver,int duration,Point start,Point end) {
		
		//create a sequence of actions
		Sequence swipe  = new Sequence(finger,1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(0));//0 = Left Click
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(duration), Origin.viewport(), end.getX(), end.getY()));
		swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg())); //0 = can be used for left clcik
		
		
		//Perform the sequence of actions
		
		driver.perform(Arrays.asList(swipe));
	}
}
