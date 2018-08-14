package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.commands.Straight;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public final class SingleCubeAuto extends CommandGroup {

	public SingleCubeAuto() {
		Command c;
		switch (Robot.getInstance().getSide()) {
		case "middleRight": {
			c = new SingleCubeHalfSides();
			break;
		}
		case "vaultRight": {
			c = new CenterSingleCube();
			break;
		}
		case "leftLeft":
		case "rightRight": {
			c = new FarSide();
			break;
		}
		default: {
			c = new Straight(126, true);
		}
		}
		addSequential(c);
	}
}