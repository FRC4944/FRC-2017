package org.usfirst.frc.team4944.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public final class Wait extends Command {

	private final Timer t = new Timer();
	private final double time;

	public Wait(final double seconds) {
		time = seconds;
	}

	@Override
	protected final void initialize() {
		t.reset();
		t.start();
	}

	@Override
	protected final boolean isFinished() {
		return t.get() >= time;
	}
}