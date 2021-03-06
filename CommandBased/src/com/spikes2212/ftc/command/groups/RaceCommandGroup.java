package com.spikes2212.ftc.command.groups;

import com.spikes2212.ftc.command.Command;

import java.util.*;

/**
 * A command group that runs all commands in parallel until one of them is done, then interrupts all of the others.
 */
public class RaceCommandGroup extends CommandGroup {

    public RaceCommandGroup(Command... commands) {
        super(new ArrayList<>(new HashSet<>(Arrays.asList(commands))));
    }

    @Override
    public void init() {
        for (Command command : commands) {
            command.init();
        }
    }

    @Override
    public void exec() {
        for (Command command : commands) {
            command.exec();
        }
    }

    @Override
    public boolean isDone() {
        for (Command command : commands) {
            if (command.isDone()) return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * <p>If this function was called as a result of {@link #isDone} returning {@code true}, it will call the
     * {@link Command#isDone} function again for each command in this group individually, to determine whether it should
     * be interrupted.</p>
     */
    @Override
    public void end(boolean done) {
        for (Command command : commands) {
            command.end(command.isDone());
        }
    }
}
