import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * AsphaltGameBot - A lightweight automation bot for Asphalt 8
 * Simulates race replays and nitro boosts to earn credits hands-free.
 *
 * Developed by: Pramod M
 * Date: Sept 15, 2018
 */

public class AsphaltGameBot {

    private static Robot robot;
    private static int raceCount = 0;

    public static void main(String[] args) {
        try {
            robot = new Robot();
            robot.setAutoDelay(200);
        } catch (AWTException e) {
            System.err.println("Robot initialization failed.");
            e.printStackTrace();
            return;
        }

        Timer nitroTimer = new Timer();
        Timer replayTimer = new Timer();

        // Schedule nitro boost every 1.4 seconds
        nitroTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                triggerNitroBoost();
            }
        }, 1400, 1400);

        // Schedule race replay every 212 seconds
        replayTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                raceCount++;
                replayRace();
                System.out.println("Total races completed: " + raceCount);
            }
        }, 212_000, 212_000);
    }

    private static void triggerNitroBoost() {
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_SPACE);
    }

    private static void clickAt(int x, int y) {
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    private static void replayRace() {
        // Click to finish race
        clickAt(700, 620);
        robot.delay(1500);

        // Click through result screens
        clickAt(700, 620);
        robot.delay(1500);

        // Click replay button
        clickAt(100, 620);
        robot.delay(1500);

        // Confirm replay
        clickAt(500, 490);
        robot.delay(1500);

        // Start next race
        clickAt(700, 620);
        robot.delay(1000);
    }
}
