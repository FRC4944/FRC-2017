package org.usfirst.frc.team4944.robot.subsystems;

import org.usfirst.frc.team4944.robot.HardwareHandler;
import org.usfirst.frc.team4944.robot.RobotMap;
import org.usfirst.frc.team4944.robot.hardware.Motor;

import edu.wpi.first.wpilibj.Solenoid;

public class ClimberSystem {

	private final Solenoid climberSolenoid = new Solenoid(RobotMap.CLIMBER_SOLENOID);
	private final Motor climbMotor;

	// Methods

	public ClimberSystem(final HardwareHandler hardwareHandler) {
		climbMotor = hardwareHandler.getClimbMotor();
	}

	public final void setSolenoid(final boolean set) {
		climberSolenoid.set(set);
	}

	public final void setClimberMotor(final double power) {
		if (power <= 0)
			climbMotor.setPower(power);
		else
			climbMotor.setPower(0);
	}
}