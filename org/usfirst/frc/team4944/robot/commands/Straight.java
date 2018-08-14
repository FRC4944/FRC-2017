package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public final class Straight extends Command {

	public static final double DEFAULT_MAX_POW = .7;
	private final Timer t = new Timer();
	private final Timer closeTimer = new Timer();
	private double maxPow = DEFAULT_MAX_POW;
	private double targetDistance, targetLeftDistance, targetRightDistance;
	private double targetAngle = 0, timeout;
	private final double driveP = 0.0004;// Previously .0005
	private final double angleP = 0.06;
	private final boolean waitForStop;

	public Straight(final double distance) {
		this(distance, true);
	}

	public Straight(final double distance, final boolean waitforstop) {
		waitForStop = waitforstop;
		targetDistance = DriveSystem.getCounts(distance);
		timeout = -1;
	}

	public Straight(final double distance, final boolean waitforStop, final double maxPower,
			final double finishTimeout) {
		this(distance, waitforStop);
		maxPow = maxPower;
		timeout = finishTimeout;
	}

	public Straight(final double distance, final double maxPower) {
		this(distance);
		maxPow = maxPower;
	}

	public Straight(int distance, boolean waitForStop, double maxPow) {
		this(distance, waitForStop, maxPow, -1);
	}

	public Straight(int distance, double maxPow, double timeout) {
		this(distance, false, maxPow, timeout);
	}

	@Override
	protected final void initialize() {
		t.reset();
		t.start();
		targetLeftDistance = Robot.drive.getLeftEncoder() + targetDistance;
		targetRightDistance = Robot.drive.getRightEncoder() + targetDistance;
		targetAngle = Robot.drive.getAngle();
		//System.out.println("Started Driving Straight!");
	}

	@Override
	protected final void execute() {
		Robot.drive.updateSensors();

		double leftPow = (targetLeftDistance - Robot.drive.getLeftEncoder()) * driveP;
		double rightPow = (targetRightDistance - Robot.drive.getRightEncoder()) * driveP;
		final double angleError = Robot.drive.getAngle() - targetAngle;
		final double angleCorrection = angleError * angleP;

		// Setting Max Power for left
		if (leftPow > maxPow) {
			leftPow = maxPow;
		} else if (leftPow < -maxPow) {
			leftPow = -maxPow;
		}

		// Setting Max Power for right
		if (rightPow > maxPow) {
			rightPow = maxPow;
		} else if (rightPow < -maxPow) {
			rightPow = -maxPow;
		}

		// Setting the power to the Drive train and compensating for angle deviation
		// times angleP

		Robot.drive.drive(leftPow - angleCorrection, rightPow + angleCorrection + .02);

		//System.out.println(String.format("%f, %f, %d, %d, %f", leftPow, rightPow, Robot.drive.getLeftEncoder(),
			//	Robot.drive.getRightEncoder(), Robot.drive.getAngle()));
	}

	@Override
	protected final boolean isFinished() {
		if(Math.abs(Robot.drive.getLeftEncoder() - targetLeftDistance) <= DriveSystem.COUNTS_PER_INCH * 12 && Math.abs(Robot.drive.getRightEncoder() - targetRightDistance) <= DriveSystem.COUNTS_PER_INCH * 12) {
			closeTimer.start();
		}
		if(closeTimer.get()>1) {
			return true;
		}
		if (timeout > 0 && t.get() >= timeout)
			return true;
		else if (waitForStop)
			return Robot.drive.getDoneDriving()
					&& Math.abs(Robot.drive.getLeftEncoder() - targetLeftDistance) < DriveSystem.COUNTS_PER_INCH * 3;
		return Math.abs(Robot.drive.getLeftEncoder() - targetLeftDistance) < DriveSystem.COUNTS_PER_INCH;
	}

	@Override
	protected final void end() {
		Robot.drive.drive(0, 0);
		//System.out.println("Done Driving Straight!");
	}
}