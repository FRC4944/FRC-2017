package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

public final class OuttakeEnd extends InstantCommand {

	private static final IntakeSystem INTAKE = Robot.intake;

	@Override
	protected final void initialize() {
		// intake.setIntakeGrab(true);
		INTAKE.setIntakeSpeed(0);
		//System.out.println("Ending Outtake!");
	}
}