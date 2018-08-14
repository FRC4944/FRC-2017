package org.usfirst.frc.team4944.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public final class TestBasicTurn extends Command {

	private final Timer t = new Timer();
	private final double goalAngle;

	public TestBasicTurn(final double angle) {
		goalAngle = angle;
	}

	@Override
	protected final void initialize() {
		t.reset();
		t.start();
		//System.out.println("Starting Basic turn to:" + goalAngle + "degree angle");
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
		//System.out.println("Done Turning!");
	}
}