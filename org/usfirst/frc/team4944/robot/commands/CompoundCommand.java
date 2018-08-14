package org.usfirst.frc.team4944.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public final class CompoundCommand extends CommandGroup {

	public CompoundCommand(final Command... commands) {
		for (Command c : commands) {
			addSequential(c);
		}
	}
}