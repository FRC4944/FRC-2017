package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public final class ResetElevator extends InstantCommand {

	@Override
	protected final void initialize() {
		Robot.elevator.resetElevatorEncoder();
		Robot.elevator.setPower(0);
	}
}