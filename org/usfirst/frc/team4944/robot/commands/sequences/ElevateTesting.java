package org.usfirst.frc.team4944.robot.commands.sequences;

import org.usfirst.frc.team4944.robot.commands.Elevate;
import org.usfirst.frc.team4944.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

public final class ElevateTesting extends CommandGroup {

	public ElevateTesting() {
		addSequential(new Elevate(20));
		addSequential(new Wait(5));
		addSequential(new Elevate(10));
	}
}