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

public class TwoCubeCenter extends CommandGroup {

	public TwoCubeCenter() {
		final Command c = new Elevate(0, Elevate.DEFAULT_MAX_POW, 1.5);
		final Command o = new Elevate(25, 0.9);
		final char side = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		if (side == 'R') {
			addSequential(new CenterSingleCube());
			addParallel(c);
			addSequential(new Straight(-30,false, 0.6, 2));
			addSequential(new Turn(40));
			addSequential(new Straight(-78, false, Straight.DEFAULT_MAX_POW, 2.5));
			addSequential(new Turn(-50, Turn.DEFAULT_MAX_POW, 1.5));
			addSequential(new IntakeBegin());
			addSequential(new WaitFor(c));
			addSequential(new Straight(36, false, 0.7, 2));
			addSequential(new IntakeEnd());
			addSequential(new Straight(-35,false, 0.7));
			addSequential(new Turn(50));
			addParallel(o);
			addSequential(new Straight(40, Straight.DEFAULT_MAX_POW, 2));
			
			addSequential(new Turn(-25));
			addSequential(new WaitFor(o));
			addSequential(new Straight(5, .5, 1));
			addSequential(new OuttakeBegin(.6));
			addSequential(new Wait(.5));
			addSequential(new OuttakeEnd());
		} else if (side == 'L') {
			addSequential(new CenterSingleCube());
			addParallel(c);
			addSequential(new Straight(-27, false, 0.6));
			addSequential(new Turn(-25));
			//addSequential(new Wait(.2));
			addSequential(new Straight(-65, false, 2));
			addSequential(new Turn(30));
			addSequential(new WaitFor(c));
			addSequential(new IntakeBegin());
			addSequential(new Wait(.2));
			addSequential(new Straight(37, 0.7, 2));
			addSequential(new IntakeEnd());
			addSequential(new Straight(-30,false, 0.7));
			addParallel(o);
			addSequential(new Turn(-45));
			addSequential(new Straight(65,false, .5));
			addSequential(new WaitFor(o));
			addSequential(new Turn(35));
			addSequential(new Straight(7,false, .7, 1));
			addSequential(new OuttakeBegin(.5));
			addSequential(new Wait(.5));
			addSequential(new OuttakeEnd());
		}
	}

}
