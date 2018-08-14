package org.usfirst.frc.team4944.robot;

import org.usfirst.frc.team4944.robot.hardware.Motor;
import org.usfirst.frc.team4944.robot.hardware.MotorGroup;
import org.usfirst.frc.team4944.robot.hardware.MotorTalon;
import org.usfirst.frc.team4944.robot.hardware.MotorTalonSRX;
import org.usfirst.frc.team4944.robot.hardware.EncoderWPI;
import org.usfirst.frc.team4944.robot.configurations.BotType;
import org.usfirst.frc.team4944.robot.hardware.EncoderTalonSRX;
import org.usfirst.frc.team4944.robot.hardware.UniversalEncoder;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public final class HardwareHandler {

	final Motor driveLeft, driveRight, elevatorMotor, intakeLeft, intakeRight, climber;
	final UniversalEncoder driveEncLeft, driveEncRight, elevatorEncoder;

	HardwareHandler(final BotType mode) throws InvalidBotTypeException {
		if (mode == BotType.PRACTICE) {
			final TalonSRX elevEncSRX = new TalonSRX(RobotMap.PRACT_ELEV_A);
			driveLeft = new MotorGroup(new MotorTalon(RobotMap.PRACT_DRIVE_LEFT_A),
					/* new MotorTalon(RobotMap.PRACT_DRIVE_LEFT_B), */new MotorTalon(RobotMap.PRACT_DRIVE_LEFT_C));
			driveRight = new MotorGroup(new MotorTalon(RobotMap.PRACT_DRIVE_RIGHT_A),
					/* new MotorTalon(RobotMap.PRACT_DRIVE_RIGHT_B), */new MotorTalon(RobotMap.PRACT_DRIVE_RIGHT_C));
			driveEncLeft = new EncoderWPI(RobotMap.PRACT_DRIVE_LEFT_ENC_A, RobotMap.PRACT_DRIVE_LEFT_ENC_B);
			driveEncRight = new EncoderWPI(RobotMap.PRACT_DRIVE_RIGHT_ENC_A, RobotMap.PRACT_DRIVE_RIGHT_ENC_B);
			elevatorMotor = new MotorGroup(new MotorTalonSRX(elevEncSRX), new MotorTalonSRX(RobotMap.PRACT_ELEV_B));
			elevatorEncoder = new EncoderTalonSRX(elevEncSRX);
			intakeLeft = null;// new MotorTalon(RobotMap.PRACT_INTAKE_LEFT);
			intakeRight = null; // new MotorTalon(RobotMap.PRACT_INTAKE_RIGHT);
			climber = new MotorTalon(RobotMap.PRACT_CLIMBER_MOTOR);
		} else if (mode == BotType.COMPETITION) {
			final TalonSRX elevEncSRX = new TalonSRX(RobotMap.COMP_ELEV_A);
			final TalonSRX leftEncSRX = new TalonSRX(RobotMap.COMP_DRIVE_LEFT_A);
			final TalonSRX rightEncSRX = new TalonSRX(RobotMap.COMP_DRIVE_RIGHT_A);
			driveLeft = new MotorGroup(new MotorTalonSRX(leftEncSRX), new MotorTalonSRX(RobotMap.COMP_DRIVE_LEFT_B),
					new MotorTalonSRX(RobotMap.COMP_DRIVE_LEFT_C));
			driveRight = new MotorGroup(new MotorTalonSRX(rightEncSRX), new MotorTalonSRX(RobotMap.COMP_DRIVE_RIGHT_B),
					new MotorTalonSRX(RobotMap.COMP_DRIVE_RIGHT_C));
			driveEncLeft = new EncoderTalonSRX(leftEncSRX);
			driveEncRight = new EncoderTalonSRX(rightEncSRX);
			driveEncLeft.setInverted(true);
			driveEncRight.setInverted(true);
			final TalonSRX elevB = new TalonSRX(RobotMap.COMP_ELEV_B);
			// elevEncSRX.setInverted(true);
			elevB.setInverted(true);
			elevatorMotor = new MotorGroup(new MotorTalonSRX(elevEncSRX), new MotorTalonSRX(elevB));
			elevatorEncoder = new EncoderTalonSRX(elevEncSRX);
			intakeLeft = new MotorTalonSRX(RobotMap.COMP_INTAKE_LEFT);
			intakeRight = new MotorTalonSRX(RobotMap.COMP_INTAKE_RIGHT);
			climber = new MotorTalon(RobotMap.COMP_CLIMBER_MOTOR);
		} else
			throw new InvalidBotTypeException(this.getClass().getName());
	}

	public final Motor getDriveLeft() {
		return driveLeft;
	}

	public final Motor getDriveRight() {
		return driveRight;
	}

	public final UniversalEncoder getDriveEncoderLeft() {
		return driveEncLeft;
	}

	public final UniversalEncoder getDriveEncoderRight() {
		return driveEncRight;
	}

	public final Motor getElevatorMotor() {
		return elevatorMotor;
	}

	public final UniversalEncoder getElevatorEncoder() {
		return elevatorEncoder;
	}

	public final Motor getLeftIntake() {
		return intakeLeft;
	}

	public final Motor getRightIntake() {
		return intakeRight;
	}

	public final Motor getClimbMotor() {
		return climber;
	}
}