package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.Robot1_Hardware;

@Autonomous(name="Robot 1 Crater Side", group="Linear Opmode")
public class Robot1_CraterSide extends LinearOpMode {
    private Robot1_Hardware hardware;

    public void runOpMode() {
        hardware = new Robot1_Hardware(hardwareMap, gamepad1);
        hardware.initHardware();

        waitForStart();

        telemetry.addLine("Turning right 90 degrees");
        telemetry.update();
        hardware.drivetrain.turn(90, true);

        telemetry.addLine("Turning left 90 degrees");
        telemetry.update();
        hardware.drivetrain.turn(90, false);
    }
}
