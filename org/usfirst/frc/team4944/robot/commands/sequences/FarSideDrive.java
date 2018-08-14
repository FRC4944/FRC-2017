package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.commands.OuttakeBegin;
import org.usfirst.frc.team4944.robot.commands.OuttakeEnd;
import org.usfirst.frc.team4944.robot.commands.Straight;
import org.usfirst.frc.team4944.robot.commands.Turn;
import org.usfirst.frc.team4944.robot.commands.Wait;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class FarSideDrive extends CommandGroup{
	
	public FarSideDrive() {
		final String position = Robot.getInstance().getSide();
		char pos;
		final char side = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		//final Command e = new Elevate(25);
		
		if(position.equals("rightRight")) {
			pos = 'R';
			//System.out.println("Side is rightRigth!");
		}
		else if(position.equals("leftLeft")) {
			pos = 'L';
			//System.out.println("Side is leftLeft!");
		}else {
			pos = 'E';
			//System.out.println("Side is not specified!");
		}
		
		if(pos=='L' && side=='L') {
			//addSequential(new Turn(10));
			//addParallel(e);
			addSequential(new Straight(128));
			//addSequential(new WaitFor(e));
			addSequential(new Turn(90));
			addSequential(new Straight(4));
			addSequential(new OuttakeBegin(1.0));
			addSequential(new Wait(0.5));
			addSequential(new OuttakeEnd());
		}
		else if(pos=='R' && side=='R') {
			//addSequential(new Turn(-10));
			//addParallel(e);
			addSequential(new Straight(128, false));
			//addSequential(new WaitFor(e));
			addSequential(new Turn(-90));
			addSequential(new Straight(8));
			addSequential(new OuttakeBegin(1.0));
			addSequential(new Wait(0.5));
			addSequential(new OuttakeEnd());
		}
		else if(pos=='E') {
			
		}
		else {
			addSequential(new Straight(132));
		}
	}
}
