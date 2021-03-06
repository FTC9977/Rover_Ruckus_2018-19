/**
 * Basic auto class to test the turn() function(s) in the drivetrain class which use gyro
 */

package org.firstinspires.ftc.teamcode.TestOpmodes.AutoTesting;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.Robot1_Hardware;

// @Autonomous(name="Robot 1 Turning with Gyro", group=AutonomousData.TEST_GROUP)
public class Robot1_Turning extends LinearOpMode {
    private Robot1_Hardware hardware;

    public void runOpMode() {
        hardware = new Robot1_Hardware(hardwareMap, gamepad1, true);
        hardware.initHardware();

        waitForStart();

        telemetry.addLine("Turning right 90deg");
        telemetry.update();
        hardware.drivetrain.turn(90, true);

        telemetry.addLine("Turning left 90deg");
        telemetry.update();
        hardware.drivetrain.turn(90, false);
    }
}
