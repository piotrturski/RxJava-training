package net.piotrturski.rx;

import org.apache.commons.lang3.StringUtils;

public class Helper {

    private static long startTime = System.currentTimeMillis();

    public static void log(Object... params) {

        System.out.println(
                StringUtils.leftPad(""+(System.currentTimeMillis() - startTime), 4) +
                " [" +Thread.currentThread().getName() +"] " +
                StringUtils.join(params, ' '));
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }
}
