package org.usfirst.frc.team4944.robot.hardware;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public final class MotorTalonSRX extends Motor {

	private final TalonSRX talon;

	public MotorTalonSRX(final byte id) {
		talon = new TalonSRX(id);
		talon.setNeutralMode(NeutralMode.Coast);
	}

	public MotorTalonSRX(final TalonSRX talonSRX) {
		talon = talonSRX;
	}

	@Override
	public void setInverted(final boolean inverted) {
		talon.setInverted(inverted);
	}

	@Override
	public void setPower(double power) {
		talon.set(ControlMode.PercentOutput, power);
	}
	
	@Override
	public double getCurrent() {
		return talon.getOutputCurrent();
	}
	
}