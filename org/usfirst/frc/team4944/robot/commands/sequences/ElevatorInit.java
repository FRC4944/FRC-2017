package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.commands.BasicElevate;
import org.usfirst.frc.team4944.robot.commands.ResetElevator;
import edu.wpi.first.wpilibj.command.CommandGroup;

@SuppressWarnings("deprecation")
public final class ElevatorInit extends CommandGroup {

	public ElevatorInit() {
		addSequential(new BasicElevate(0.5, -0.6));
		addSequential(new ResetElevator());
	}
}