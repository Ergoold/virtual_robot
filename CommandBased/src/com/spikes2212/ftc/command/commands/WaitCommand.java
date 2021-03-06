package com.spikes2212.ftc.command.commands;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.spikes2212.ftc.command.Command;

/**
 * A command that does nothing but take a specified amount of time to finish.
 */
public class WaitCommand extends Command {

    /**
     * The ElapsedTime object used to check how much time has passed.
     */
    private final ElapsedTime elapsedTime;

    /**
     * The amount of time after which this command ends, in seconds.
     */
    private final double seconds;

    public WaitCommand(double seconds) {
        this.seconds = seconds;
        this.elapsedTime = new ElapsedTime();
    }

    @Override
    public void init() {
        elapsedTime.reset();
    }

    @Override
    public boolean isDone() {
        return elapsedTime.seconds() >= seconds;
    }
}
