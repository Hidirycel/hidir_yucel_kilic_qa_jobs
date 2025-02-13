package utils;

public class SleeperUtils {
    public static void wait(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
}
