// last edited sep 19 2018

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * AsphaltCredits Asphalt Game to earn credits
 * Simulation of the Game Play.
 *
 * @author Pramod
 * @since 15-Sept-2018.
 */

public class AsphaltCredits {
	private static Robot robot = null;  
	private static int totalRaces = 0; 

	public static void main(String[] args) {
		try {
			robot = new Robot();   
		} catch (AWTException awtExc) {         
	 		awtExc.printStackTrace();
		}

		Timer nitro = new Timer(); 
		Timer replay = new Timer(); 

		TimerTask replayTask = new TimerTask() {
			@Override
			public void run() {
 				totalRaces++;
				generateClick();
			}
		};
		// Thread.sleep(100000);
		TimerTask nitroTask = new TimerTask() {
			@Override
			public void run() {
				generateNitro();
			}
		};
 		// replay.schedule(replayTask, 144000, 144000);
		// support for S6 Fr. Guiana rev. (hommage)
		replay.schedule(replayTask, 212000, 212000);
 		// nitro.schedule(nitroTask, 8000, 8000);
		nitro.schedule(nitroTask, 1400, 1400);
	}

	public static void generateClick() {
		// for max window
		// robot.mouseMove(1150, 660);
   		robot.mouseMove(700, 620);
 		// click next
		robot.delay(1500);
		robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		// System.out.println("Race finished");

		// click next (event details)
		robot.delay(1500);
 		robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		// System.out.println("Position");

		// move coursor to replay button
		// for max window
   		// robot.mouseMove(200, 660);
 		robot.mouseMove(100, 620);
		robot.delay(1500);
		robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		// System.out.println("replay");

		// confirm click
		// for max window
		// robot.mouseMove(800, 540);
		robot.mouseMove(500, 490);
		robot.delay(1500);
		robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		// System.out.println("yes");

		// next to start race
		// robot.mouseMove(1150, 660);
		robot.mouseMove(700, 620);
		robot.delay(1000);
		robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		// System.out.println("Start race");
		System.out.println("Total races:"+totalRaces);
	}

	public static void generateNitro() {
		robot.keyPress(KeyEvent.VK_SPACE);
 		robot.delay(50);
		robot.keyRelease(KeyEvent.VK_SPACE);
		// System.out.println("nitro1");
	}
 }