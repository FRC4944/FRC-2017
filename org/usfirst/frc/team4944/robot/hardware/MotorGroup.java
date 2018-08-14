package org.usfirst.frc.team4944.robot.hardware;

public final class MotorGroup extends Motor {

	private final Motor[] motors;

	public MotorGroup(final Motor... motor) {
		motors = motor;
	}

	@Override
	public void setInverted(boolean inverted) {
		for (Motor m : motors)
			m.setInverted(true);
	}

	@Override
	public void setPower(double power) {
		for (Motor m : motors)
			m.setPower(power);
	}
}