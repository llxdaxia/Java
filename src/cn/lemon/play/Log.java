package cn.alien95.play;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by linlongxin on 2016/7/25.
 */
public class Log {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Play");
        logger.setLevel(Level.INFO);
        logger.info("test");
    }
}
