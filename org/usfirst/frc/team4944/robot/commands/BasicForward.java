package org.usfirst.frc.team4944.robot.commands;

import org.usfirst.frc.team4944.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public final class BasicForward extends Command {

	private static final double RIGHT_COMP_VAL = Robot.config.basicForwardRightTweak;
	private static final double BASE_VAL = .3;
	private final Timer t = new Timer();
	private final double finTime;

	public BasicForward(final double time) {
		finTime = time;
	}

	@Override
	protected final void initialize() {
		t.reset();
		t.start();
	}

	@Override
	protected final void execute() {
		Robot.drive.drive(BASE_VAL, BASE_VAL + RIGHT_COMP_VAL * Math.signum(BASE_VAL));
	}

	@Override
	protected final boolean isFinished() {
		return t.get() >= finTime;
	}

	@Override
	protected final void end() {
		Robot.drive.drive(0, 0);
	}
}