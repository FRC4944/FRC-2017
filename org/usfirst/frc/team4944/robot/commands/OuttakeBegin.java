package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

public final class OuttakeBegin extends InstantCommand {

	private static final IntakeSystem INTAKE = Robot.intake;
	private final double power;

	public OuttakeBegin(final double outPower) {
		power = outPower;
	}

	@Override
	protected final void initialize() {
		INTAKE.setIntakeSpeed(power);
		//System.out.println("Starting Outtake!");
		//intake.setIntakeGrab(false);
	}
}