/**
 * Class for testing position tracking.
 */

package org.firstinspires.ftc.teamcode.TestOpmodes.AutoTesting;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.FieldMapping.FieldElement;
import org.firstinspires.ftc.teamcode.FieldMapping.FieldMap;
import org.firstinspires.ftc.teamcode.Hardware.Robot1_Hardware;
// @Autonomous(name="Position Tracking Test", group=AutonomousData.TEST_GROUP)
public class Robot1_PositionTracking extends LinearOpMode {

    private Robot1_Hardware hardware;
    private FieldMap fieldMap = new FieldMap();

    private double startTime;

    public void runOpMode() {
        hardware = new Robot1_Hardware(hardwareMap, gamepad1, true);
        hardware.initHardware();
        hardware.navTargetDetector.setupTracker();

        waitForStart();
        startTime = System.currentTimeMillis();

        telemetry.addLine("Place the robot in front of one of the navigation targets");
        telemetry.addLine("Robot updating position");
        telemetry.update();
        updatePosition();
        //hardware.drivetrain.setRobotPos(fieldMap.HALF_SQUARE_LENGTH, -fieldMap.HALF_SQUARE_LENGTH);
        //hardware.drivetrain.setRobotAngle(315);

        telemetry.addLine("Driving to Q4 Left Mineral");
        telemetry.update();
        hardware.drivetrain.goTo(fieldMap.get(FieldElement.RED_DEPOT_LEFT_MINERAL), 0.6);

        sleep(1000);

        telemetry.addLine("Driving to Q4 Depot");
        telemetry.update();
        hardware.drivetrain.goTo(fieldMap.get(FieldElement.RED_DEPOT), 0.8);
    }

    private void updatePosition() {
        sleep(2000);
        while (!hardware.navTargetDetector.isTargetVisible() || System.currentTimeMillis() - startTime < 5){
            hardware.navTargetDetector.lookForTargets();
        }
        hardware.drivetrain.setRobotPos(hardware.navTargetDetector.getRobotPosition().getX(), hardware.navTargetDetector.getRobotPosition().getY());
        hardware.drivetrain.setRobotAngle((int) hardware.navTargetDetector.getRobotRotation());
    }
}
