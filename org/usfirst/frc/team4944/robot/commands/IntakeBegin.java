package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

public final class IntakeBegin extends InstantCommand {

	private static final IntakeSystem INTAKE = Robot.intake;

	@Override
	public final void initialize() {
		INTAKE.setIntakeGrab(false);
		INTAKE.setIntakeSpeed(-1);
	}
}