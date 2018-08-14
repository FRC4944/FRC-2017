package org.usfirst.frc.team4944.robot.hardware;

public abstract class Motor {

	public abstract void setInverted(final boolean inverted);

	public abstract void setPower(final double left);
	
	protected double getCurrent() {
		return -1;
	}

}