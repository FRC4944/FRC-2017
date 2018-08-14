package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.commands.Straight;
import org.usfirst.frc.team4944.robot.commands.Turn;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public final class CenterSingleCubeDrive extends CommandGroup {

	public CenterSingleCubeDrive() {
		final int deg = DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L' ? -45 : 45;
		final int diagonalDist = DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L' ? 74 : 46;
		final int StraightDist = DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L' ? 14 : 36;
		addSequential(new Turn(deg));
		addSequential(new Straight(diagonalDist, false, .5));
		addSequential(new Turn(-deg));
		addSequential(new Straight(StraightDist, false, 0.5));
	}
}