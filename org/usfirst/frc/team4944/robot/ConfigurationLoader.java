package org.usfirst.frc.team4944.robot;

import org.usfirst.frc.team4944.robot.configurations.BotType;
import org.usfirst.frc.team4944.robot.configurations.VariableConstants;

public final class ConfigurationLoader {

	public final double basicForwardRightTweak, elevateKP;

	ConfigurationLoader(final BotType type) throws InvalidBotTypeException {
		if (type == BotType.COMPETITION) {
			basicForwardRightTweak = VariableConstants.COMP_BASIC_FORWARD_RIGHT_TWEAK;
			elevateKP = VariableConstants.COMP_ELEVATE_KP;
		} else if (type == BotType.PRACTICE) {
			basicForwardRightTweak = VariableConstants.PRACT_BASIC_FORWARD_RIGHT_TWEAK;
			elevateKP = VariableConstants.PRACT_ELEVATE_KP;
		} else
			throw new InvalidBotTypeException(this.getClass().getName());
	}
}