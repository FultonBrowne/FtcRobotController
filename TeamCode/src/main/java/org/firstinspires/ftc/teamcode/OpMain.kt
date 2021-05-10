package org.firstinspires.ftc.teamcode;
import  kotlin.concurrent.*
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import org.firstinspires.ftc.teamcode.framework.*
import com.qualcomm.robotcore.hardware.*
const val FORWARD = 1
@TeleOp( name = "TeleOp 2020" )

class OpMain : OpMode() {
   var motor0:DcMotor? = null 
   var motor1:DcMotor? = null 
   var motor2:DcMotor? = null 
   var motor3:DcMotor? = null 
   var motor4:DcMotor? = null
   var motor5:DcMotor? = null
   var motor6:DcMotor? = null
   var motor7:DcMotor? = null
   var boom = false
   var servo1:Servo? = null
   var servo01:Servo? = null 
   var servo00:Servo? = null

   var servo02:Servo? = null
   var crservo1:CRServo? = null
   var color0:ColorSensor? = null
   var color1:ColorSensor? = null
   var arm:Servo? = null
   var claw:Servo? = null
   val move = Move()
   override fun init(){
   
        motor0 = hardwareMap.dcMotor["motor0"]
        motor1 = hardwareMap.dcMotor["motor1"]
        motor2 = hardwareMap.dcMotor["motor2"]
        motor3 = hardwareMap.dcMotor["motor3"]
        motor4 = hardwareMap.dcMotor["motor4"]
        motor5 = hardwareMap.dcMotor["motor5"]
        motor6 = hardwareMap.dcMotor["motor6"]
        motor7 = hardwareMap.dcMotor["motor7"]
        servo1 = hardwareMap.servo["servo0"]
        crservo1 = hardwareMap.crservo["crservo1"]
        arm = hardwareMap.servo["servo3"]
        color0 = hardwareMap.colorSensor["color0"];
        color1 = hardwareMap.colorSensor["color1"];
        claw = hardwareMap.servo["servo4"]
        servo00 = hardwareMap.servo["servo10"]
        servo01 = hardwareMap.servo["servo11"]
        servo02 = hardwareMap.servo["servo12"]
        motor0!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor0!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor1!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor0!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor1!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor2!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor2!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor3!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor4!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor3!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor5!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor6!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        servo01!!.setPosition(0.0)
        servo00!!.setPosition(0.1)
   }

   fun doWaitStop(dcmotor:DcMotor?, l:Int){
      if (l > 0) thread{ while(dcmotor!!.getCurrentPosition() < l){Thread.sleep(10)}}
      else thread(start = true){ while(dcmotor!!.getCurrentPosition() > l){Thread.sleep(10)}}
      dcmotor!!.setPower(0.0)
      dcmotor!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
   }


   fun forward(){
      move.forward(
         motor0!!,
         motor1!!,
         motor2!!,
         motor3!!,
         -0.8.toFloat()
      )
      doWaitStop(motor0, FORWARD)
      doWaitStop(motor1, FORWARD)
      doWaitStop(motor2, FORWARD)
      doWaitStop(motor3, FORWARD)
   }


   fun back(){
      move.back(
         motor0!!,
         motor1!!,
         motor2!!,
         motor3!!,
         -0.8.toFloat()
      )
      doWaitStop(motor0, FORWARD)
      doWaitStop(motor1, FORWARD)
      doWaitStop(motor2, FORWARD)
      doWaitStop(motor3, FORWARD)
   }
 fun isYellow(color:ColorSensor?, num:Int):Boolean{
      var toReturn = false;
        telemetry.addData(Integer.toString(color!!.argb()), "all");
       telemetry.addData(Integer.toString(color!!.red()), "red");
        telemetry.addData(Integer.toString(color!!.green()), "green");
       telemetry.addData(Integer.toString(color!!.blue()), "blue");
        telemetry.addData(Integer.toString(color!!.alpha()), "alpha");
        if (color!!.alpha() > num) toReturn = true;
        color!!.enableLed(true);
       // if (colorSensor)
        return toReturn;
   }


   override fun loop(){
        
		/* get a bool of yellow true or false */
        telemetry.addData(Integer.toString(motor0!!.getCurrentPosition()), "current position of motor0")
        telemetry.addData(Integer.toString(motor1!!.getCurrentPosition()), "current position of motor1")
        telemetry.addData(Integer.toString(motor2!!.getCurrentPosition()), "current position of motor2")
        telemetry.addData(Integer.toString(motor3!!.getCurrentPosition()), "current position of motor3")

      motor7!!.setPower(-1.0)
      
      motor6!!.setPower(-1.0)

      val isYellow = isYellow(color0, 2000)
                if (isYellow){
                   //Turn on firing motors
           motor4!!.setPower(-1.0)
           motor5!!.setPower(-1.0)
                }else{
            motor4!!.setPower(0.0)
            motor5!!.setPower(0.0)
                }

      if(gamepad1.left_stick_y > 0.1 || gamepad1.left_stick_y < -0.1){
         move.forward(
            motor0, 
            motor1,
            motor2,
            motor3,
            gamepad1.left_stick_y
         )


      }

      else if(gamepad1.left_stick_x > 0.1 || gamepad1.left_stick_x < -0.1){
         move.left(
            motor0, 
            motor1,
            motor2,
            motor3,
            gamepad1.left_stick_x
         )

      }

      else if(gamepad1.right_stick_x > 0.1 || gamepad1.right_stick_x < -0.1){
         move.spin(
            motor0,
            motor1,
            motor2,
            motor3,
            -gamepad1.right_stick_x * 0.4.toFloat()
         )
      }
      else{
         move.stop(
            motor0, 
            motor1,
            motor2,
            motor3
         )
      }



   if(gamepad1.a){
      //move the belt and raise the *thing*
      crservo1!!.setPower(-1.0)
    } else { 
       crservo1!!.setPower(0.0)
    }

      if(gamepad1.b){
           claw!!.setPosition(0.0)
           Thread.sleep(1000)
           arm!!.setPosition(0.0)
      }

      else if (gamepad1.x){
         claw!!.setPosition(1.0)
         Thread.sleep(1000)
         arm!!.setPosition(1.0)
      }

      if (gamepad1.y){
         motor6!!.setPower(-1.0)
      } else motor6!!.setPower(0.0)

      if(gamepad1.right_bumper){
          forward()
      }
      if(gamepad1.left_bumper){
          back()
      }

   }


}
