package org.usfirst.frc.team4944.robot.subsystems;

import org.usfirst.frc.team4944.robot.HardwareHandler;
import org.usfirst.frc.team4944.robot.commands.IntakeBegin;
import org.usfirst.frc.team4944.robot.commands.IntakeEnd;
import org.usfirst.frc.team4944.robot.configurations.RobotMap;
import org.usfirst.frc.team4944.robot.hardware.Motor;

import edu.wpi.first.wpilibj.Solenoid;

public final class IntakeSystem {

	private final Motor leftIntake, rightIntake;
	private final Solenoid intake = new Solenoid(RobotMap.INTAKE_GRAB);
	
	public boolean closed;
	
	public IntakeSystem(final HardwareHandler hh) {
		leftIntake = hh.getLeftIntake();
		rightIntake = hh.getRightIntake();
		//rightIntake.setInverted(true);
		closed = true;
	}

	public final void setIntakeSpeed(final double power) {
		leftIntake.setPower(power);
		rightIntake.setPower(-power);
	}

	public final void setIntakeGrab(final boolean grab) {
		intake.set(!grab);
	}
	
	public final void getIntakeCurrent() {
		
	}
	
	public final void rightTriggerGrab(double grab) {
		if(Math.abs(grab) > 0.3) {
			new IntakeBegin().start();
			closed = false;
			//System.out.println("RightTrigger used");
		}else {
			if(!closed) {
				new IntakeEnd().start();
				closed = true;
			}
		}
	}
	
}