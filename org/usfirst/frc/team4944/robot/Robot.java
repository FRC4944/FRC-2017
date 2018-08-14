package org.usfirst.frc.team4944.robot;

import org.usfirst.frc.team4944.robot.commands.BasicForward;
import org.usfirst.frc.team4944.robot.commands.CompoundCommand;
import org.usfirst.frc.team4944.robot.commands.Elevate;
import org.usfirst.frc.team4944.robot.commands.Straight;
import org.usfirst.frc.team4944.robot.commands.Wait;
import org.usfirst.frc.team4944.robot.commands.sequences.ElevatorInit;
import org.usfirst.frc.team4944.robot.commands.sequences.SingleCubeAttack;
import org.usfirst.frc.team4944.robot.commands.sequences.SingleCubeAuto;
import org.usfirst.frc.team4944.robot.commands.sequences.FarSideDrive;
import org.usfirst.frc.team4944.robot.commands.sequences.TwoCubeCenter;
import org.usfirst.frc.team4944.robot.configurations.BotType;
import org.usfirst.frc.team4944.robot.subsystems.ClimberSystem;
import org.usfirst.frc.team4944.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4944.robot.subsystems.ElevatorSystem;
import org.usfirst.frc.team4944.robot.subsystems.GeneralSystem;
import org.usfirst.frc.team4944.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	boolean runningCommandX = false;
	boolean runningCommandB = false;
	boolean runningCommandY = false;
	public static final BotType BOT_TYPE = BotType.COMPETITION;
	public static ClimberSystem climber;
	public static ElevatorSystem elevator;
	public static IntakeSystem intake;
	public static DriveSystem drive;
	public static ClimberSystem climbSystem;
	public static ConfigurationLoader config;
	public static Robot instance;
	public static String side = "leftLeft";
	public static boolean tele = false;
	GeneralSystem general;
	private final Server server = new Server(this);
	private Command autoCommand;
	private OI oi;
	private String auto = "autoLine";
	private byte delay;
	private boolean gotoNull = false;

	@Override
	public final void robotInit() {
		instance = this;
		new Thread(server).start();
		HardwareHandler hardwareHandler = null;
		try {
			hardwareHandler = new HardwareHandler(BOT_TYPE);
			config = new ConfigurationLoader(BOT_TYPE);
		} catch (InvalidBotTypeException e) {
			e.printStackTrace();
			System.exit(1);
		}
		drive = new DriveSystem(hardwareHandler);
		general = new GeneralSystem();
		elevator = new ElevatorSystem(hardwareHandler);
		intake = new IntakeSystem(hardwareHandler);
		climbSystem = new ClimberSystem(hardwareHandler);
		general.init();
		CameraServer.getInstance().startAutomaticCapture();
		elevator.resetElevatorEncoder();
	}

	@Override
	public final void autonomousInit() {
		Scheduler.getInstance().removeAll();
		if (autoCommand != null)
			if (!autoCommand.isCompleted())
				autoCommand.cancel();
		tele = false;
		switch (auto) {
		case "autoLine": {
			autoCommand = new Straight(120);
			break;
		}
		case "initialCube": {
			autoCommand = new SingleCubeAuto();
			break;
		}
		case "autoTest": {
			autoCommand = new BasicForward(2.25);
			break;
		}
		case "twoCubeFront": {
			//System.out.println("Starting Two Cube");
			autoCommand = new TwoCubeCenter();
			break;
		}
		case "singleAttack": {
			autoCommand = new SingleCubeAttack();
			break;
		}
		default: {
			autoCommand = new ElevatorInit();
		}
		}
		autoCommand = new CompoundCommand(new Wait(delay), autoCommand);
		if (autoCommand != null)
			autoCommand.start();
	}

	@Override
	public final void autonomousPeriodic() {
		Scheduler.getInstance().run();
		drive.updateSensors();
		//System.out.println(Robot.drive.getAngle());
	}

	@Override
	public final void teleopInit() {
		tele = true;
		if (autoCommand != null)
			if (!autoCommand.isCompleted())
				autoCommand.cancel();
		oi = new OI(this);
	}

	@Override
	public final void teleopPeriodic() {
		
		Scheduler.getInstance().run();
		
		final Joystick driveCon = oi.driveController, opCon = oi.opController;
		
		final double x = driveCon.getRawAxis(ControllerMap.AXIS_RIGHT_X),
				y = -driveCon.getRawAxis(ControllerMap.AXIS_LEFT_Y);
		
		drive.drive(y + x, y - x);
		
		intake.rightTriggerGrab(driveCon.getRawAxis(ControllerMap.AXIS_RIGHT_TRIGGER));
		
		//System.out.println(driveCon.getRawAxis(ControllerMap.AXIS_RIGHT_TRIGGER));
		
		climbSystem.setClimberMotor(opCon.getRawAxis(ControllerMap.AXIS_RIGHT_Y));
		
		if (opCon.getPOV() == 0)
			climbSystem.setSolenoid(true);
		else if (opCon.getPOV() == 180)
			climbSystem.setSolenoid(false);
		
		if (!Elevate.running)
			elevator.setPower(opCon.getRawAxis(ControllerMap.AXIS_RIGHT_TRIGGER)
					- opCon.getRawAxis(ControllerMap.AXIS_LEFT_TRIGGER));
		
		// }
		//System.out.println(
			//	opCon.getRawAxis(ControllerMap.AXIS_RIGHT_TRIGGER) - opCon.getRawAxis(ControllerMap.AXIS_LEFT_TRIGGER));
		/*
		 * if(Scheduler.getInstance() == null) { elevator.setPower(
		 * driveCon.getRawAxis(ControllerMap.AXIS_RIGHT_TRIGGER) -
		 * driveCon.getRawAxis(ControllerMap.AXIS_LEFT_TRIGGER)); }
		 */
		// elevator.setPower(
		// driveCon.getRawAxis(ControllerMap.AXIS_RIGHT_TRIGGER) -
		// driveCon.getRawAxis(ControllerMap.AXIS_LEFT_TRIGGER));
		drive.updateSensors();
		// int elevatorCounts = Robot.elevator.getElevatorEncoder();
		// System.out.println(elevatorCounts);

		// climber.setClimberMotor(opCon.getRawAxis(ControllerMap.AXIS_RIGHT_Y));
		// climber.toggleClimberSolenoid_OFF(opCon.getRawButton(ControllerMap.BUTTON_B));
		// climber.toggleClimberSolenoid_ON(opCon.getRawButton(ControllerMap.BUTTON_A));
	}

	public final void setAuto(final String string) {
		auto = string;
		//System.out.println("Set Auto: " + auto);
	}

	public final void setSide(final String string) {
		side = string;
	}

	public static final Robot getInstance() {
		return instance;
	}

	public final String getSide() {
		return side;
	}

	public final void setDelay(final byte setDelay) {
		delay = setDelay;
	}

	public final boolean isGoingToNull() {
		return gotoNull;
	}

	public final void setGotoNull(final boolean doNull) {
		gotoNull = doNull;
	}
}