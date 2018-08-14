package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.commands.Elevate;
import org.usfirst.frc.team4944.robot.commands.OuttakeBegin;
import org.usfirst.frc.team4944.robot.commands.OuttakeEnd;
import org.usfirst.frc.team4944.robot.commands.Wait;
import org.usfirst.frc.team4944.robot.commands.WaitFor;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class FarSide extends CommandGroup {

	public FarSide() {
		final Command c = new FarSideDrive();
		final char side = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		final String pos = Robot.getInstance().getSide();
		final char position;
		if (pos.equals("leftLeft")) {
			position = 'L';
		} else if (pos.equals("rightRight")) {
			position = 'R';
		} else {
			position = 'E';
		}

		addParallel(c);
		addSequential(new ElevatorInit());
		if (side == position) {
			addSequential(new Elevate(25));
			addSequential(new WaitFor(c));
			addSequential(new OuttakeBegin(.5));
			addSequential(new Wait(1));
			addSequential(new OuttakeEnd());
		}

	}

}
