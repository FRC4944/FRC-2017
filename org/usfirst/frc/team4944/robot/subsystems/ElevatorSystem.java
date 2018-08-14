package org.usfirst.frc.team4944.robot.subsystems;

import org.usfirst.frc.team4944.robot.HardwareHandler;
import org.usfirst.frc.team4944.robot.configurations.RobotMap;
import org.usfirst.frc.team4944.robot.hardware.Motor;
import org.usfirst.frc.team4944.robot.hardware.UniversalEncoder;

import edu.wpi.first.wpilibj.Solenoid;

public class ElevatorSystem {
	
	private static final double DOWN_BASE = .4, MIN_DOWN_POW = -.25, MAX_UP_POW = 0.85;
	public static final short COUNTS_PER_INCH = 902;
	// private static final byte MAX_HEIGHT_INCH = 35;
	// private static final int MAX_HEIGHT_COUNT = COUNTS_PER_INCH *
	// MAX_HEIGHT_INCH;
	// private static final short MIN_HEIGHT_COUNT = COUNTS_PER_INCH / 2;
	public static final short VAULT_HEIGHT = COUNTS_PER_INCH * 2;
	private static final double MAX_P_POW = .3;

	// Talons, Solenoids, and Encoders
	private final Motor elevatorMotor;
	private final Solenoid elevatorBrake = new Solenoid(RobotMap.ELEV_BRAKE);
	private final UniversalEncoder elevatorEncoder;

	// End of Declerations and Start of Methods

	public ElevatorSystem(final HardwareHandler hh) {
		elevatorMotor = hh.getElevatorMotor();
		elevatorEncoder = hh.getElevatorEncoder();
		elevatorEncoder.setInverted(true);
	}

	// Setting the Motor power for A and B
	public final void setPower(double power) {
		//System.out.println("Pow: " + power);
		if (Math.abs(power) > .05) {
			setElevatorBrake(false);
			if (power < 0) {
				power += DOWN_BASE;
				if (power < MIN_DOWN_POW)
					power = MIN_DOWN_POW;
			} else if (power > MAX_UP_POW) {
				power = MAX_UP_POW;

			}
		} else {
			power = 0;
			setElevatorBrake(true);
		}
		elevatorMotor.setPower(power);
		/*
		 * if (Math.abs(power) > .05) { setElevatorBrake(false);
		 *
		 * if (power < 0) { if (getElevatorEncoder() > MIN_HEIGHT_COUNT) { power +=
		 * DOWN_BASE; if (power < MIN_DOWN_POW) power = MIN_DOWN_POW; } else power = 0;
		 * } else if (getElevatorEncoder() > MAX_HEIGHT_COUNT) power = 0;
		 *
		 * } if (Math.abs(power) < .01) setElevatorBrake(true); if (power > 0) power +=
		 * DOWN_BASE; elevatorMotor.setPower(-power);
		 */
	}

	// Setting the Solenoid for the Brake to true (Activated)
	public final void setElevatorBrake(final boolean engaged) {
		elevatorBrake.set(!engaged);
	}

	// Getting the Encoder value for the Elevator
	public final int getElevatorEncoder() {
		return elevatorEncoder.getCount();
	}

	// Reseting the encoder for the elevator
	public final void resetElevatorEncoder() {
		elevatorEncoder.reset();
	}

	public static final double getCounts(final double distance) {
		return distance * COUNTS_PER_INCH;
	}

	public static final double pControl(final double sensorVal, final double goalVal, final double kP) {
		double pow = (goalVal - sensorVal) * kP;
		if (Math.abs(pow) > MAX_P_POW)
			pow = Math.signum(pow) * MAX_P_POW;
		return pow;
	}
}