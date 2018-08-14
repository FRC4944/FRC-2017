
package org.usfirst.frc.team4944.robot.subsystems;

import org.usfirst.frc.team4944.robot.HardwareHandler;
import org.usfirst.frc.team4944.robot.Robot;
import org.usfirst.frc.team4944.robot.hardware.Motor;
import org.usfirst.frc.team4944.robot.hardware.UniversalEncoder;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort.Port;

public class DriveSystem {

	public int currentLeft = 0;
	public int lastLeft = 0;
	public int currentRight = 0;
	public int lastRight = 0;
	public double currentAngle = 0;
	public double lastAngle = 0;
	public double minSpeedThreshHold = 10;
	public static final short ENCODER_REV_COUNT = 1024;
	public static final double WHEEL_DIAM = 4.02;
	public static final double PREVIOUS_WHEEL_DIAM = 4.02;
	public static final double WHEEL_CIRC = Math.PI * WHEEL_DIAM;
	public static final double COUNTS_PER_INCH = 300;
	private static final double MAX_P_POW = .25;
	private static final double TELE_MAX_POW = .75;
	private final Motor driveLeft, driveRight;
	private final UniversalEncoder leftEnc, rightEnc;
	private final AHRS navx = new AHRS(Port.kUSB1);

	public DriveSystem(final HardwareHandler hh) {
		driveLeft = hh.getDriveLeft();
		driveRight = hh.getDriveRight();
		driveRight.setInverted(true);
		leftEnc = hh.getDriveEncoderLeft();
		rightEnc = hh.getDriveEncoderRight();
		rightEnc.setInverted(true);
	}

	public final void drive(double left, double right) {
		if (!Robot.getInstance().isAutonomous()) {
			left *= TELE_MAX_POW;
			right *= TELE_MAX_POW;
		}
		driveLeft.setPower(left);
		driveRight.setPower(right);
	}

	public final int getLeftEncoder() {
		return leftEnc.getCount();
	}

	public final int getRightEncoder() {
		return rightEnc.getCount();
	}

	public static final double pControl(final double sensorVal, final double goalVal, final double kP) {
		double pow = (goalVal - sensorVal) * kP;
		if (Math.abs(pow) > MAX_P_POW)
			pow = Math.signum(pow) * MAX_P_POW;
		return pow;
	}

	public final double getAngle() {
		return navx.getAngle();
	}

	public static final double getCounts(final double distance) {
		return distance * COUNTS_PER_INCH;
	}

	public void updateSensors() {
		lastRight = currentRight;
		lastLeft = currentLeft;
		lastAngle = currentAngle;
		currentAngle = getAngle();
		currentLeft = getLeftEncoder();
		currentRight = getRightEncoder();
		
	}

	public boolean getDoneDriving() {
		int leftDifference = lastLeft - currentLeft;
		int rightDifference = lastRight - currentRight;
		if(Math.abs(rightDifference) < minSpeedThreshHold && Math.abs(leftDifference) < minSpeedThreshHold) {
			return true;
		}else {
			return false;
		}
	}	
	public boolean getDoneTurning() {
		double angleDifference = lastAngle - currentAngle;
		if (Math.abs(angleDifference) < 0.05) {
			return true;
		}else {
			return false;
		}
	}
}