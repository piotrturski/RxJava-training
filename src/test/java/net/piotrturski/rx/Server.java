package net.piotrturski.rx;

import org.apache.commons.lang3.RandomUtils;

import static net.piotrturski.rx.Helper.log;
import static net.piotrturski.rx.Helper.sleep;

public class Server {

    private final int nr;

    public Server(int nr) {
        this.nr = nr;
    }

    public String blockingRequest(String input) {
        log("blocking command started", nr, input);
        sleep(
                RandomUtils.nextInt(0, 6) > 3 ? RandomUtils.nextInt(200, 300) : RandomUtils.nextInt(900, 1300)
        );
        log("blocking command finished", nr, input);
        return input + " from " + this;
    }

    @Override
    public String toString() {
        return "Server{nr=" + nr + '}';
    }
}
