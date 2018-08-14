package org.usfirst.frc.team4944.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;

public final class GeneralSystem {

	private final Compressor compressor = new Compressor();

	public final void init() {
		UsbCamera camera = new UsbCamera("Camera", 0);
		CameraServer.getInstance().addCamera(camera);
		CameraServer.getInstance().startAutomaticCapture(camera);
		compressor.start();
	}
}