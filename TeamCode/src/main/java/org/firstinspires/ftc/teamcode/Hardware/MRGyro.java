package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.GyroSensor;

import java.util.ArrayList;

public class MRGyro {
    private GyroSensor gyroSensor; // Hardware Device Object
    private ArrayList<Integer> previousHeadings; // A list of the previous gyro headings each time we zero'd the gyro

    public MRGyro(GyroSensor gyro, boolean calibrate) {
        previousHeadings = new ArrayList<Integer>();

        gyroSensor = gyro;

        if (calibrate)
            calibrate();
        zero();
    }

    public void calibrate() {
        gyroSensor.calibrate();
        while (gyroSensor.isCalibrating()) {
            // WAIT - Gyro Sensor is Calibrating
        }
    }

    public void zero() {
        previousHeadings.add(getHeading());
        gyroSensor.resetZAxisIntegrator();
    }

    // Deletes all previousHeadings
    public void reset() {
        zero();
        for (Integer heading : previousHeadings) {
            previousHeadings.remove(heading);
        }
    }

    // Returns heading -- adjusted for the fact that its reading backwards values
    public int getHeading() {
        return 360 - gyroSensor.getHeading();
    }

    // Returns the angle the robot has turned from the origin, negative for anything left and positive for anything right
    public int getAngle() {
        return convertToAngleFromOrigin(getHeading());
    }

    // Returns the heading last time we zero'd the sensor
    public int getPreviousHeading() {
        return previousHeadings.get(previousHeadings.size() - 1);
    }

    // Returns the angle the robot had turned from the origin last time we zero'd the sensor
    public int getPreviousAngle() {
        return convertToAngleFromOrigin(getPreviousHeading());
    }

    // Returns the net heading since calibration
    public int headingSinceCalibration() {
        int sumHeadings = 0;
        for (Integer a : previousHeadings) {
            sumHeadings += a;
        }

        sumHeadings = sumHeadings % 360;

        return sumHeadings;
    }

    // Returns the net angle the robot has turned from the origin since calibration
    public int angleSinceCalibration() {
        return convertToAngleFromOrigin(headingSinceCalibration());
    }

    // We convert from gyro heading to angle turned from origin a lot in this class, so this helper method makes things easier to read
    private int convertToAngleFromOrigin(int heading) {
        if (heading > 180) {
            return -(360 - heading);
        } else
            return heading;
    }

    public static int convertToDegrees(double radians) {
        return (int) (radians * 180 / Math.PI);
    }
    public static double convertToRadians(int degrees) { return degrees * Math.PI / 180; }
}
