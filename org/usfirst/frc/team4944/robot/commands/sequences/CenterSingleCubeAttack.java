package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.commands.Elevate;
import org.usfirst.frc.team4944.robot.commands.OuttakeBegin;
import org.usfirst.frc.team4944.robot.commands.OuttakeEnd;
import org.usfirst.frc.team4944.robot.commands.Wait;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public final class CenterSingleCubeAttack extends CommandGroup {

	public CenterSingleCubeAttack() {
		//final Command o = new Elevate(0);
		final Command c = new CenterSingleCubeDrive();
		addParallel(c);
		addSequential(new ElevatorInit());
		addSequential(new Elevate(25,0.75));
		addSequential(new Wait(0.6));
		addSequential(new OuttakeBegin(1.0));
		addSequential(new Wait(0.5));
		addSequential(new OuttakeEnd());
	}
}