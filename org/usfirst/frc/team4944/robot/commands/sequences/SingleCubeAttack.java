package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.commands.Elevate;
import org.usfirst.frc.team4944.robot.commands.Straight;
import org.usfirst.frc.team4944.robot.commands.Turn;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SingleCubeAttack extends CommandGroup {

	public SingleCubeAttack() {
		if (!Robot.side.equals("leftLeft") && !Robot.side.equals("rightRight")) {
			addSequential(new CenterSingleCube());
			addParallel(new Elevate(0));
			addSequential(new Straight(-24));
			final String field = DriverStation.getInstance().getGameSpecificMessage();
			final char switchSide = field.charAt(0), scaleSide = field.charAt(1);
			if (switchSide == scaleSide) {
				final int turn = switchSide == 'L' ? -90 : 90;
				addSequential(new Turn(turn));
				addSequential(new Straight(24, false));
				addSequential(new Turn(Math.signum(turn)*-81));
				addSequential(new Straight(50, false));
			} else {
				final int turn = switchSide == 'L' ? -45 : 45;
				final int dist = switchSide == 'L' ? -80 : -46;
				addSequential(new Turn(turn));
				addSequential(new Straight(dist, false));
				final float turn2 = Math.signum(turn) * -65;
				addSequential(new Turn(-turn + turn2));
				addSequential(new Straight(100, false));
				addSequential(new Turn(Math.signum(turn2) * -60));
				addSequential(new Straight(100, false));
			}
			if (Robot.getInstance().isGoingToNull())
				addSequential(new Straight(84, .6));
		}
	}
}