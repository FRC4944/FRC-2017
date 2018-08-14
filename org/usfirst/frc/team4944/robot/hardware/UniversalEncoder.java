package org.usfirst.frc.team4944.robot.hardware;

public interface UniversalEncoder {

	public void setInverted(final boolean invert);

	public int getCount();

	public void reset();
}