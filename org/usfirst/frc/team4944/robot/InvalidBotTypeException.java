package org.usfirst.frc.team4944.robot;

final class InvalidBotTypeException extends Exception {

	private static final long serialVersionUID = 1L;

	InvalidBotTypeException(final String name) {
		super("Invalid BotType provided in: " + name);
	}
}