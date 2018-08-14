package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.commands.Straight;
import org.usfirst.frc.team4944.robot.commands.Turn;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public final class CenterSingleCubeAttackDrive extends CommandGroup {

	public CenterSingleCubeAttackDrive() {
		
		//final Command c = new Elevate(0);
		//final Command o = new Elevate(25,0.75);
		final char side = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		if(side == 'R') {
			addSequential(new CenterSingleCube());
			addSequential(new Straight(36));
			addSequential(new Turn(90));
			addSequential(new Straight(48));
			addSequential(new Turn(-90));
			addSequential(new Straight(60));
			
		}
		else if(side == 'L') {
			addSequential(new CenterSingleCube());
			addSequential(new Straight(36));
			addSequential(new Turn(-90));
			addSequential(new Straight(48));
			addSequential(new Turn(90));
			addSequential(new Straight(60));
			
		}
		
	} 
}