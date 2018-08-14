package org.usfirst.frc.team4944.robot.hardware;

import edu.wpi.first.wpilibj.Encoder;

public final class EncoderWPI implements UniversalEncoder {

	private final Encoder encoder;

	public EncoderWPI(final byte portA, final byte portB) {
		encoder = new Encoder(portA, portB);
	}

	@Override
	public final void setInverted(final boolean b) {
		encoder.setReverseDirection(true);
	}

	@Override
	public int getCount() {
		return encoder.get();
	}

	@Override
	public void reset() {
		encoder.reset();
	}
}