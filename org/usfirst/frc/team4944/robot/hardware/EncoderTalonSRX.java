package org.usfirst.frc.team4944.robot.hardware;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public final class EncoderTalonSRX implements UniversalEncoder {

	private static final byte TIMEOUT_MS = 10;
	private final TalonSRX talon;

	public EncoderTalonSRX(final TalonSRX encSRX) {
		talon = encSRX;
	}

	@Override
	public final int getCount() {
		return talon.getSelectedSensorPosition(0);
	}

	@Override
	public final void reset() {
		talon.setSelectedSensorPosition(0, 0, TIMEOUT_MS);
	}

	@Override
	public final void setInverted(boolean invert) {
		talon.setSensorPhase(true);
	}
}