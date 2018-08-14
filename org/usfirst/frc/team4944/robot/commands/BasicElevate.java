package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public final class BasicElevate extends Command {

	private final Timer t = new Timer();
	private final double time, pow;

	public BasicElevate(final double seconds, final double power) {
		time = seconds;
		pow = power;
	}

	@Override
	protected final void initialize() {
		t.reset();
		t.start();
		Robot.elevator.setPower(pow);
	}

	@Override
	protected final boolean isFinished() {
		return t.get() >= time;
	}

	@Override
	protected final void end() {
		Robot.elevator.setPower(0);
	}
}