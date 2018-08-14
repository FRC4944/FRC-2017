package org.usfirst.frc.team4944.robot.configurations;

public class RobotMap {

	// 0 - Practice
	// 0.0 - Drive
	// 0.0.0 - Left
	public static final byte PRACT_DRIVE_LEFT_A = 7;
	public static final byte PRACT_DRIVE_LEFT_B = 8;
	public static final byte PRACT_DRIVE_LEFT_C = 9;
	public static final byte PRACT_DRIVE_LEFT_ENC_A = 0;
	public static final byte PRACT_DRIVE_LEFT_ENC_B = 1;

	// 0.0.1 - Right
	public static final byte PRACT_DRIVE_RIGHT_A = 4;
	public static final byte PRACT_DRIVE_RIGHT_B = 5;
	public static final byte PRACT_DRIVE_RIGHT_C = 6;
	public static final byte PRACT_DRIVE_RIGHT_ENC_A = 2;
	public static final byte PRACT_DRIVE_RIGHT_ENC_B = 3;

	// 0.1 - Elevator
	public static final byte PRACT_ELEV_A = 0;
	public static final byte PRACT_ELEV_B = 1;

	// 0.2 - Intake
	public static final byte PRACT_INTAKE_LEFT = 0;
	public static final byte PRACT_INTAKE_RIGHT = 1;

	// 1 - Competition
	// 1.0 - Drive
	// 1.0.0 - Left
	public static final byte COMP_DRIVE_LEFT_A = 0;
	public static final byte COMP_DRIVE_LEFT_B = 1;
	public static final byte COMP_DRIVE_LEFT_C = 2;

	// 1.0.1 - Right
	public static final byte COMP_DRIVE_RIGHT_A = 3;
	public static final byte COMP_DRIVE_RIGHT_B = 4;
	public static final byte COMP_DRIVE_RIGHT_C = 5;

	// 1.1 - Elevator
	public static final byte COMP_ELEV_A = 6;
	public static final byte COMP_ELEV_B = 7;

	// 1.2 - Intake
	public static final byte COMP_INTAKE_LEFT = 8;
	public static final byte COMP_INTAKE_RIGHT = 9;

	// 2 - Universal
	// 2.1 - Elevator
	public static final byte ELEV_BRAKE = 0;

	// 2.2 - Intake
	public static final byte INTAKE_GRAB = 1;
}