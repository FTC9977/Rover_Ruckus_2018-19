package ftc.vision;

import android.graphics.Camera;
import android.view.SurfaceView;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;

public class OpencvVision implements CameraBridgeViewBase.CvCameraViewListener2 {
    public OpencvVision(CameraBridgeViewBase c) {
        c.setVisibility(SurfaceView.VISIBLE);
        c.setCvCameraViewListener(this);
    }

    @Override
    public void onCameraViewStarted(int width, int height) {

    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        return inputFrame.rgba();
    }
}
