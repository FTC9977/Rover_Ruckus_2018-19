package org.firstinspires.ftc.teamcode.HardwareTesting;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Hardware.Robot1_Hardware;

public class Robot1_HangSlideTest extends OpMode {
    private Robot1_Hardware hardware;
    private double vexPow = 0, neverestPow = 0;

    public void init() {
        hardware = new Robot1_Hardware(hardwareMap, gamepad1, false);
        hardware.initHardware();
    }

    public void loop() {

        vexPow = -gamepad2.left_stick_y;
        neverestPow = -gamepad2.right_stick_y;

        hardware.hangVex.setPower(vexPow);
        hardware.hangNvst.setPower(neverestPow);

        telemetry.addLine("Left joystick y = vex");
        telemetry.addLine("Right joystick y = nvst");
        telemetry.addData("Hang Vex Power (Bring slide up)", hardware.hangVex.getPower());
        telemetry.addData("Hang Neverest Power (Bring slide down)", hardware.hangNvst.getPower());
        telemetry.update();
    }
}
