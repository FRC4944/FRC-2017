package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public final class Turn extends Command {

	public static final double DEFAULT_MAX_POW = .5;
	// Set this.
	private final Timer time = new Timer();
	private final double inputAngle;
	private double goalAngle, timeout = -1;
	// True = Right False = Left
	private boolean direction;
	private double maxPow = DEFAULT_MAX_POW;

	private final double drivep = 0.055;

	public Turn(final double angle) {
		inputAngle = angle;
	}

	public Turn(final double angle, final double maxPower) {
		this(angle);
		maxPow = maxPower;
	}

	public Turn(double angle, double maxPow, double setTimeout) {
		this(angle, maxPow);
		timeout = setTimeout;
	}

	@Override
	protected final void initialize() {
		time.reset();
		time.start();
		goalAngle = inputAngle + Robot.drive.getAngle();
		if (inputAngle < 0) {
			direction = false;
			//System.out.println("Started Turning Left");
		} else if (inputAngle > 0) {
			direction = true;
			//System.out.println("Started Turning Right");
		}
	}

	@Override
	protected final void execute() {

		double angleError = goalAngle - Robot.drive.getAngle();
		double drivePow = Math.abs(angleError * drivep);
		double correctionDrivePow = -drivePow;
		double currentAngle = Robot.drive.getAngle();

		if (drivePow > maxPow) {
			drivePow = maxPow;
		}
		if (correctionDrivePow < -maxPow) {
			correctionDrivePow = -maxPow;
		}

		if (direction && currentAngle < goalAngle) {
			Robot.drive.drive(drivePow, -0.1);
		} else if (direction && currentAngle > goalAngle) {
			Robot.drive.drive(correctionDrivePow, -0.1);
		} else if (!direction && currentAngle > goalAngle) {
			Robot.drive.drive(-0.1, drivePow);
		} else if (!direction && currentAngle < goalAngle) {
			Robot.drive.drive(-0.1, correctionDrivePow);
		}
		//System.out.println(goalAngle + ", " + currentAngle);
	}

	@Override
	protected final boolean isFinished() {
		if (timeout > 0 && time.get() >= timeout)
			return true;
		return Math.abs(goalAngle - Robot.drive.getAngle()) <= 3/* && Robot.drive.getDoneTurning() */;
	}

	@Override
	protected final void end() {
		//System.out.println("Done Turning!");
		Robot.drive.drive(0, 0);
	}
}