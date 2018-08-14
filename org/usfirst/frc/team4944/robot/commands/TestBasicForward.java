package org.usfirst.frc.team4944.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public final class TestBasicForward extends Command {

	private final Timer t = new Timer();
	public final double targetDistance;
	
	public TestBasicForward(final double distance) {
		targetDistance = distance;
	}

	@Override
	protected final void initialize() {
		t.reset();
		t.start();
		//System.out.println("Starting Basic Straight Forward to" + targetDistance);
	}

	@Override
	protected final void execute() {
		
	}

	@Override
	protected final boolean isFinished() {
		return t.get() >= 5;
	}

	@Override
	protected final void end() {
		//System.out.println("Done Driveing!");
	}
}