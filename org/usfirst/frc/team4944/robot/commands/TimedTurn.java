package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public final class TimedTurn extends Command {

	// Set this.
	private static final double ANGKPCONSTANT = 1 / 90;
	private final Timer t = new Timer();
	private final double finTime, goalAngle;
	private double targetAngle;

	public TimedTurn(final double time, final double angle) {
		finTime = time;
		goalAngle = angle;
	}

	@Override
	protected final void initialize() {
		targetAngle = Robot.drive.getAngle() + goalAngle;
		t.reset();
		t.start();
	}

	@Override
	protected final void execute() {
		double pow = DriveSystem.pControl(Robot.drive.getAngle(), targetAngle, ANGKPCONSTANT);
		// Flip possible.
		Robot.drive.drive(pow, -pow);
	}

	@Override
	protected final boolean isFinished() {
		return t.get() >= finTime;
	}

	@Override
	protected final void end() {
		Robot.drive.drive(0, 0);
	}
}