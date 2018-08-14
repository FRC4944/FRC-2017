package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.commands.Elevate;
import org.usfirst.frc.team4944.robot.commands.OuttakeBegin;
import org.usfirst.frc.team4944.robot.commands.OuttakeEnd;
import org.usfirst.frc.team4944.robot.commands.Straight;
import org.usfirst.frc.team4944.robot.commands.Turn;
import org.usfirst.frc.team4944.robot.commands.Wait;
import org.usfirst.frc.team4944.robot.commands.WaitFor;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class FarOneCubeCenter extends CommandGroup {

	public FarOneCubeCenter() {
		
			
		//final Command c = new Elevate(0);
		final Command o = new Elevate(25,0.75);
		final char side = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		if(side == 'R') {
			addSequential(new Turn(45));
			addSequential(new Straight(108));
			addParallel(o);
			addSequential(new Turn(-45));
			addSequential(new Straight(32));
			addSequential(new Turn(-90));
			addSequential(new WaitFor(o));
			addSequential(new Straight(12));
			addSequential(new OuttakeBegin(1.0));
			addSequential(new Wait(0.5));
			addSequential(new OuttakeEnd());
		}
		else if(side == 'L') {
			addSequential(new Turn(-55));
			addSequential(new Straight(126));
			addParallel(o);
			addSequential(new Turn(45));
			addSequential(new Straight(32));
			addSequential(new Turn(90));
			addSequential(new WaitFor(o));
			addSequential(new OuttakeBegin(1.0));
			addSequential(new Wait(0.5));
			addSequential(new OuttakeEnd());
		}
	}
	
	
	
	
	
	
	
	
}
