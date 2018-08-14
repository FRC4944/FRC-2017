package org.usfirst.frc.team4944.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public final class WaitFor extends Command {

	private final Command c;

	public WaitFor(final Command command) {
		c = command;
	}

	@Override
	protected final boolean isFinished() {
		return c.isCompleted();
	}
	@Override
	protected final void end() {
		//System.out.println("Done Waiting for command!");
	}
}