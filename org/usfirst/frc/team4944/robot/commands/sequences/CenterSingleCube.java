package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.commands.Elevate;
import org.usfirst.frc.team4944.robot.commands.OuttakeBegin;
import org.usfirst.frc.team4944.robot.commands.OuttakeEnd;
import org.usfirst.frc.team4944.robot.commands.Wait;
import org.usfirst.frc.team4944.robot.commands.WaitFor;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public final class CenterSingleCube extends CommandGroup {

	public CenterSingleCube() {
		final Command c = new CenterSingleCubeDrive();
		addParallel(c);
		addSequential(new ElevatorInit());
		addSequential(new Wait(1));
		addSequential(new Elevate(25,0.75,2));
		addSequential(new WaitFor(c));
		addSequential(new OuttakeBegin(.4));
		addSequential(new Wait(0.5));
		addSequential(new OuttakeEnd());
	}
}