package org.firstinspires.ftc.teamcode.framework;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;

/**
 * Base framework for movement
 * Note I use per method motor params for flexibility reasons
 * */
public class Move {

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

   

}
