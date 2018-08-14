package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public final class IntakeEnd extends Command {

	private static final double IDLE_IN_POW = -.3;
	private static final IntakeSystem INTAKE = Robot.intake;
	private final Timer timer = new Timer();

	@Override
	protected final void initialize() {
		timer.reset();
		timer.start();
		INTAKE.setIntakeGrab(true);
	}

	@Override
	protected final boolean isFinished() {
		return timer.get() >= .5;
	}

	@Override
	protected final void end() {
		INTAKE.setIntakeSpeed(IDLE_IN_POW);
	}
}
