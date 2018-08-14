package org.usfirst.frc.team4944.robot.hardware;

import edu.wpi.first.wpilibj.Talon;

public final class MotorTalon extends Motor {

	private final Talon talon;

	public MotorTalon(final byte port) {
		talon = new Talon(port);
	}

	@Override
	public void setInverted(final boolean inverted) {
		talon.setInverted(inverted);
	}

	@Override
	public void setPower(double power) {
		talon.set(power);
	}
}