package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.commands.Elevate;
import org.usfirst.frc.team4944.robot.commands.Straight;
import org.usfirst.frc.team4944.robot.commands.OuttakeBegin;
import org.usfirst.frc.team4944.robot.commands.OuttakeEnd;
import org.usfirst.frc.team4944.robot.commands.Wait;
import org.usfirst.frc.team4944.robot.commands.WaitFor;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public final class SingleCubeHalfSides extends CommandGroup {

	public SingleCubeHalfSides() {
		final Command c = new Straight(107, true, .5);
		addParallel(c);
		addSequential(new ElevatorInit());
		addSequential(new Elevate(25));
		addSequential(new WaitFor(c));
		char ch;
		if (Robot.getInstance().getSide().equals("vaultLeft"))
			ch = 'L';
		else if (Robot.getInstance().getSide().equals("middleRight"))
			ch = 'R';
		else
			ch = 'E';
		if (DriverStation.getInstance().getGameSpecificMessage().charAt(0) == ch) {
			addSequential(new OuttakeBegin(1));
			addSequential(new Wait(.5));
			addSequential(new OuttakeEnd());
		}
	}
}