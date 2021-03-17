package org.firstinspires.ftc.teamcode.framework;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import java.util.List;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;


/**
 * Base framework for movement
 * Note I use per method motor params for flexibility reasons
 * */
public class Move {
   private static final String VUFORIA_KEY =
            " -- YOUR NEW VUFORIA KEY GOES HERE  --- ";

    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Quad";
    private static final String LABEL_SECOND_ELEMENT = "Single";

    private VuforiaLocalizer vuforia;

    /**
     * {@link #tfod} is the variable we will use to store our instance of the TensorFlow Object
     * Detection engine.
     */
    private TFObjectDetector tfod;

    public void stop(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
      ){
        motor0.setPower(0.0);
        motor1.setPower(0.0);
        motor2.setPower(0.0);
        motor3.setPower(0.0);
    }
    public void forward(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
      ){
        motor0.setPower(1.0);
        motor1.setPower(1.0);
        motor2.setPower(-1.0);
        motor3.setPower(-1.0);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void spin(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
   ){
        motor0.setPower(1.0);
        motor1.setPower(1.0);
        motor2.setPower(1.0);
        motor3.setPower(1.0);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void spinOtherWay(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
   ){
        motor0.setPower(-1.0);
        motor1.setPower(-1.0);
        motor2.setPower(-1.0);
        motor3.setPower(-1.0);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void back(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
   ){
        motor0.setPower(-1.0);
        motor1.setPower(-1.0);
        motor2.setPower(1.0);
        motor3.setPower(1.0);
        //motor1.setPower(1.0);
        //motor3.setPower(-1.0);
    }
    public void right(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
   ){

        motor0.setPower(1.0);
        motor1.setPower(-1.0);
        motor2.setPower(-1.0);
        motor3.setPower(1.0);
        //motor0.setPower(1.0);
        //motor2.setPower(-1.0);
    }
    public void left(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
   ){
        motor0.setPower(-1.0);
        motor1.setPower(1.0);
        motor2.setPower(1.0);
        motor3.setPower(-1.0);
        //motor0.setPower(-1.0);
        //motor2.setPower(1.0);
    }


    public void forward(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed
      ){
        motor0.setPower(speed);
        motor1.setPower(speed);
        motor2.setPower(-speed);
        motor3.setPower(-speed);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void spin(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed

   ){
        motor0.setPower(speed);
        motor1.setPower(speed);
        motor2.setPower(speed);
        motor3.setPower(speed);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void spinOtherWay(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed

   ){
        motor0.setPower(-speed);
        motor1.setPower(-speed);
        motor2.setPower(-speed);
        motor3.setPower(-speed);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void back(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed

   ){
        motor0.setPower(-speed);
        motor1.setPower(-speed);
        motor2.setPower(speed);
        motor3.setPower(speed);
        //motor1.setPower(1.0);
        //motor3.setPower(-1.0);
    }
    public void right(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed

   ){

        motor0.setPower(speed);
        motor1.setPower(-speed);
        motor2.setPower(-speed);
        motor3.setPower(speed);
        //motor0.setPower(1.0);
        //motor2.setPower(-1.0);
    }
    public void left(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed

   ){
        motor0.setPower(-speed);
        motor1.setPower(speed);
        motor2.setPower(speed);
        motor3.setPower(-speed);
        //motor0.setPower(-1.0);
        //motor2.setPower(1.0);
    }

    public void crON(CRServo crServo, double power){
        crServo.setPower(power);
    }

    public void crStop(CRServo crServo){
        crServo.setPower(0.0);
    }

    public void openClaw(CRServo servo0){
        servo0.setPower(-1.0);
    }
    public void closeClaw(CRServo servo0){
        servo0.setPower(1.0);
    }
    public void arm(double pos, Servo servo){
        servo.setPosition(pos);
    }
    public void elevator(DcMotor motor0,
      DcMotor motor1,
      Double speed
      ){
        motor0.setPower(speed);
        motor1.setPower(speed);
    }
    public void moveAutoStop(DcMotor motor, TouchSensor sensor, float speed){
      motor.setPower(speed);
       while(!sensor.isPressed()){}
       motor.setPower(0.0);
    }
   public void spiner(DcMotor motor0, ModernRoboticsI2cRangeSensor range0){
      while (range0.rawUltrasonic() < 40){
         motor0.setPower(1.0);
      }
      if(range0.rawUltrasonic() < 40){
         spiner(motor0, range0);
      }

   }
   public void threeTouchSensor(TouchSensor sen1, TouchSensor sen2, TouchSensor sen3, TouchSensor sen4, DcMotor motor0){
      //if(sen1){
      //   motor0.setPower(1.0);
      //}
      //if(sen3 || sen4) {
      // Grab roller is off
      // If grab roller is off, check distance sensor 1
      //}
      // move this
/**
      If distance sensor 1 is greater than 12”, check distance sensor 2
      If distance sensor 2 is greater than 12”, move arm to up position.
      If touch sensor 2 is pushed, arm hold position for 3 seconds
         Reverse intake grab motors to expel the disk
         Arm returns to down position
      When touch sensor 1 is pushed
         Roller arm Motor holds position
      If Color Sensor sees orange
            Turn on shooter motors
   **/


   }
   
   public void fire(){}
    /**
     * Initialize the Vuforia localization engine.
     */
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CameraDirection.BACK;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

/**
     * Initialize the TensorFlow Object Detection engine.
     */
    private void initTfod(OpMode opmode) {
        int tfodMonitorViewId = opmode.hardwareMap.appContext.getResources().getIdentifier(
            "tfodMonitorViewId", "id", opmode.hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.8f;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }
   public int getHeight(Telemetry telemetry, OpMode opmode){
		int toReturn = 0;
        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        // first.
        initVuforia();
        initTfod(opmode);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
       if (tfod != null) {
            tfod.activate();

            // The TensorFlow software will scale the input images from the camera to a lower resolution.
            // This can result in lower detection accuracy at longer distances (> 55cm or 22").
            // If your target is at distance greater than 50 cm (20") you can adjust the magnification value
            // to artificially zoom in to the center of image.  For best results, the "aspectRatio" argument
            // should be set to the value of the images used to create the TensorFlow Object Detection model
            // (typically 16/9).
            tfod.setZoom(2.5, 16.0/9.0);
        }

   if (tfod != null) {
      // getUpdatedRecognitions() will return null if no new information is available since
      // the last time that call was made.
      List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
      if (updatedRecognitions != null) {
         telemetry.addData("# Object Detected", updatedRecognitions.size());
         if (updatedRecognitions.size() == 0 ) {
            // empty list.  no objects recognized.
            telemetry.addData("TFOD", "No items detected.");
            telemetry.addData("Target Zone", "A");
         } else {
            // list is not empty.
            // step through the list of recognitions and display boundary info.
            int i = 0;
            for (Recognition recognition : updatedRecognitions) {
               telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
               telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                   recognition.getLeft(), recognition.getTop());
               telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                   recognition.getRight(), recognition.getBottom());
                // check label to see which target zone to go after.
                if (recognition.getLabel().equals("Single")) {
                   telemetry.addData("Target Zone", "B");
                    toReturn = 1;
                } else if (recognition.getLabel().equals("Quad")) {
                   telemetry.addData("Target Zone", "C");
                   toReturn = 4;
                } else {
                   telemetry.addData("Target Zone", "UNKNOWN");
                }
             }
          }
       }}

       telemetry.update();

       if (tfod != null) {
          tfod.shutdown();
       }
 	   return toReturn;
   }
}
