package org.usfirst.frc.team4944.robot;

public class RobotMap {

	// 0 - Practice
	// 0.0 - Drive
	// 0.0.0 - Left
	static final byte PRACT_DRIVE_LEFT_A = 7;
	// static final byte PRACT_DRIVE_LEFT_B = 8;
	static final byte PRACT_DRIVE_LEFT_C = 9;
	static final byte PRACT_DRIVE_LEFT_ENC_A = 0;
	static final byte PRACT_DRIVE_LEFT_ENC_B = 1;

	// 0.0.1 - Right
	static final byte PRACT_DRIVE_RIGHT_A = 4;
	// static final byte PRACT_DRIVE_RIGHT_B = 5;
	static final byte PRACT_DRIVE_RIGHT_C = 6;
	static final byte PRACT_DRIVE_RIGHT_ENC_A = 2;
	static final byte PRACT_DRIVE_RIGHT_ENC_B = 3;

	// 0.1 - Elevator
	static final byte PRACT_ELEV_A = 0;
	static final byte PRACT_ELEV_B = 1;

	// 0.2 - Intake
	// static final byte PRACT_INTAKE_LEFT = 0;
	// static final byte PRACT_INTAKE_RIGHT = 1;

	// 0.3 - Climber
	public static final byte CLIMBER_SOLENOID = 2;
	public static final byte PRACT_CLIMBER_MOTOR = 8;

	// 1 - Competition
	// 1.0 - Drive
	// 1.0.0 - Left
	static final byte COMP_DRIVE_LEFT_A = 0;
	static final byte COMP_DRIVE_LEFT_B = 1;
	static final byte COMP_DRIVE_LEFT_C = 2;

	// 1.0.1 - Right
	static final byte COMP_DRIVE_RIGHT_A = 3;
	static final byte COMP_DRIVE_RIGHT_B = 4;
	static final byte COMP_DRIVE_RIGHT_C = 5;

	// 1.1 - Elevator
	static final byte COMP_ELEV_A = 6;
	static final byte COMP_ELEV_B = 7;

	// 1.2 - Intake
	static final byte COMP_INTAKE_LEFT = 8;
	static final byte COMP_INTAKE_RIGHT = 9;

	// 2 - Universal
	// 2.1 - Elevator
	public static final byte ELEV_BRAKE = 0;

	// 2.2 - Intake
	public static final byte INTAKE_GRAB = 1;

	// 2.3 - Climber
	public static final byte COMP_CLIMBER_MOTOR = 8;
}