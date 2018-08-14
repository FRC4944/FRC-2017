package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public final class DropElevator extends InstantCommand {

	@Override
	protected final void initialize() {
		Robot.elevator.setElevatorBrake(false);
	}
}