package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.commands.Elevate;
import org.usfirst.frc.team4944.robot.commands.IntakeBegin;
import org.usfirst.frc.team4944.robot.commands.IntakeEnd;
import org.usfirst.frc.team4944.robot.commands.OuttakeBegin;
import org.usfirst.frc.team4944.robot.commands.OuttakeEnd;
import org.usfirst.frc.team4944.robot.commands.Straight;
import org.usfirst.frc.team4944.robot.commands.Turn;
import org.usfirst.frc.team4944.robot.commands.Wait;
import org.usfirst.frc.team4944.robot.commands.WaitFor;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OuterTwoCubeFromCenter extends CommandGroup {

	public OuterTwoCubeFromCenter() {
		
			
		final Command c = new Elevate(0);
		final Command o = new Elevate(25,0.9);
		final char side = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		if(side == 'R') {
			addSequential(new FarOneCubeCenter());
			addSequential(new Straight(-24));
			addSequential(new Turn(-80));
			addParallel(c);
			addSequential(new Straight(-96));
			addSequential(new Turn(40));
			addSequential(new WaitFor(c));
			addSequential(new IntakeBegin());
			addSequential(new Wait(0.25));
			addSequential(new Straight(36));
			addSequential(new IntakeEnd());
			addParallel(o);
			addSequential(new Straight(-12));
			addSequential(new WaitFor(o));
			addSequential(new Straight(8));
			addSequential(new Turn(-30));
			addSequential(new OuttakeBegin(1.0));
			addSequential(new Wait(0.5));
			addSequential(new OuttakeEnd());
			
		}
		else if(side == 'L') {
			addSequential(new FarOneCubeCenter());
			addSequential(new Straight(-24));
			addSequential(new Turn(80));
			addParallel(c);
			addSequential(new Straight(-84));
			addSequential(new Turn(-40));
			addSequential(new WaitFor(c));
			addSequential(new IntakeBegin());
			addSequential(new Wait(0.25));
			addSequential(new Straight(36));
			addSequential(new IntakeEnd());
			addParallel(o);
			addSequential(new Straight(-12));
			addSequential(new WaitFor(o));
			addSequential(new Straight(12));
			addSequential(new Turn(30));
			addSequential(new OuttakeBegin(1.0));
			addSequential(new Wait(0.5));
			addSequential(new OuttakeEnd());
			
		}
	}
	
	
	
	
	
	
	
	
}
