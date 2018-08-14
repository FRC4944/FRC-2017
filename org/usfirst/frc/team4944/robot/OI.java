package org.usfirst.frc.team4944.robot;

import org.usfirst.frc.team4944.robot.commands.Elevate;
import org.usfirst.frc.team4944.robot.commands.IntakeBegin;
import org.usfirst.frc.team4944.robot.commands.IntakeEnd;
import org.usfirst.frc.team4944.robot.commands.OuttakeBegin;
import org.usfirst.frc.team4944.robot.commands.OuttakeEnd;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class OI {

	final Joystick driveController = new Joystick(0), opController = new Joystick(1);

	OI(final Robot bot) {
		final Command outEnd = new OuttakeEnd();
		final Command c = new Elevate(25, 0.9);
		final Command o = new Elevate(4, 0.9);
		final Command m = new Elevate(22.5, 0.9);

		final JoystickButton intakeButton = new JoystickButton(driveController, ControllerMap.BUTTON_RIGHT_BUMPER);
		intakeButton.whenPressed(new IntakeBegin());

		final JoystickButton intakeEndButton = new JoystickButton(driveController, ControllerMap.BUTTON_LEFT_BUMPER);
		intakeEndButton.whenPressed(new IntakeEnd());

		final JoystickButton outtake100Button = new JoystickButton(driveController, ControllerMap.BUTTON_A);
		outtake100Button.whenPressed(new OuttakeBegin(1));
		outtake100Button.whenReleased(outEnd);

		final JoystickButton vaultLevelButton = new JoystickButton(opController, ControllerMap.BUTTON_B);
		vaultLevelButton.whenPressed(o);

		final JoystickButton switchLevelButton = new JoystickButton(opController, ControllerMap.BUTTON_X);
		switchLevelButton.whenPressed(c);

		final JoystickButton portalLevelButton = new JoystickButton(opController, ControllerMap.BUTTON_Y);
		portalLevelButton.whenPressed(m);

		final JoystickButton outtake55Button = new JoystickButton(driveController, ControllerMap.BUTTON_Y);
		outtake55Button.whenPressed(new OuttakeBegin(.55));
		outtake55Button.whenReleased(outEnd);

		final JoystickButton vaultButton = new JoystickButton(opController, ControllerMap.BUTTON_A);
		final Command down = new Elevate(0, .6, 1.5);
		vaultButton.whenPressed(down);

		final JoystickButton driveDown = new JoystickButton(driveController, ControllerMap.BUTTON_X);
		driveDown.whenPressed(down);
	}
}