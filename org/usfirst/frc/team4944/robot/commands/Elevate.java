package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.subsystems.ElevatorSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public final class Elevate extends Command {

	public static final double DEFAULT_MAX_POW = .6;
	// Set this.
	// true is up false if down
	public static boolean running = false;
	private boolean direction;
	// private int heightRange = 100;
	private double goalHeight;
	private double maxPow = DEFAULT_MAX_POW, timeout = -1;
	private final double drivep = 0.006;
	private final Timer time = new Timer();

	public Elevate(final double height) {
		goalHeight = ElevatorSystem.getCounts(height);
	}

	public Elevate(final double height, final double maxpow) {
		this(height);
		maxPow = maxpow;
	}

	public Elevate(int height, double maxPow, double setTimeout) {
		this(height, maxPow);
		timeout = setTimeout;
	}

	@Override
	protected final void initialize() {
		running = true;
		time.reset();
		time.start();
		if (goalHeight > Robot.elevator.getElevatorEncoder()) {
			//System.out.println("Starting Upwards Elevate");
			direction = true;
		} else if (goalHeight < Robot.elevator.getElevatorEncoder()) {
			//System.out.println("Starting Downwards Elevate");
			direction = false;
		}
	}

	@Override
	protected final void execute() {

		double goalError = goalHeight - Robot.elevator.getElevatorEncoder();
		double drivePow = goalError * drivep;
		double currentHeight = Robot.elevator.getElevatorEncoder();

		if (drivePow > maxPow) {
			drivePow = maxPow;
		}
		if (drivePow < -maxPow) {
			drivePow = -maxPow;
		}

		Robot.elevator.setPower(drivePow);

		//System.out.println(goalHeight + ", " + currentHeight + ", " + drivePow);
	}

	@Override
	protected final boolean isFinished() {
		if (timeout > 0 && time.get() >= timeout)
			return true;
		if (direction) {
			return Robot.elevator.getElevatorEncoder() >= goalHeight;
		} else if (!direction) {
			return Robot.elevator.getElevatorEncoder() <= goalHeight;
		} else {
			return true;
		}

	}

	@Override
	protected final void end() {
		//System.out.println("Done Elevating!");
		Robot.elevator.setPower(0);
		running = false;
	}
}