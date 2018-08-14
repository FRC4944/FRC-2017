package org.usfirst.frc.team4944.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public final class TestBasicElevate extends Command {

	private final Timer t = new Timer();
	public final double targetHeight;
	
	public TestBasicElevate(final double height) {
		targetHeight = height;
	}

	@Override
	protected final void initialize() {
		t.reset();
		t.start();
		//System.out.println("Starting Basic elevate to: " + targetHeight);
	}

	@Override
	protected final boolean isFinished() {
		return t.get() >= 5;
	}

	@Override
	protected final void end() {
		t.stop();
		//System.out.println("Done doing Basic elevate!");
	}
}