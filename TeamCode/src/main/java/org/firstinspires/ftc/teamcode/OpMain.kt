package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import org.firstinspires.ftc.teamcode.framework.*
import com.qualcomm.robotcore.hardware.*
@TeleOp( name = "TeleOp 2020")
class OpMain : OpMode() {
   var motor0:DcMotor? = null 
   var motor1:DcMotor? = null 
   var motor2:DcMotor? = null 
   var motor3:DcMotor? = null 
   var motor4:DcMotor? = null
   var motor5:DcMotor? = null
   var motor6:DcMotor? = null
   var crserv0:CRServo? = null
   var crserv1:CRServo? = null
   var color0:ColorSensor? = null
   val move = Move()
   override fun init(){
        motor0 = hardwareMap.dcMotor["motor0"]
        motor1 = hardwareMap.dcMotor["motor1"]
        motor2 = hardwareMap.dcMotor["motor2"]
        motor3 = hardwareMap.dcMotor["motor3"]
        motor4 = hardwareMap.dcMotor["motor4"]
        motor5 = hardwareMap.dcMotor["motor5"]
        motor6 = hardwareMap.dcMotor["motor6"]
        crserv0 = hardwareMap.crservo["servo0"]
        crserv1 = hardwareMap.crservo["servo1"]
        color0 = hardwareMap.colorSensor["color0"];
        motor0!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor1!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor2!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor3!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor4!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor5!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor6!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
   }

   fun isYellow():Boolean{
      var toReturn = false;
        telemetry.addData(Integer.toString(color0!!.argb()), "all");
       telemetry.addData(Integer.toString(color0!!.red()), "red");
        telemetry.addData(Integer.toString(color0!!.green()), "green");
       telemetry.addData(Integer.toString(color0!!.blue()), "blue");
        telemetry.addData(Integer.toString(color0!!.alpha()), "alpha");
        if (color0!!.alpha() < 30) toReturn = true;
        color0!!.enableLed(true);
       // if (colorSensor)
        return toReturn;
   }

   override fun loop(){
		/* get a bool of yellow true or false */
		val isYellow = isYellow()
		if (isYellow){
		   //Turn on firing motors
           move.crStop(crserv0)
           move.crON(crserv1, -1.0)
           motor6!!.setPower(1.0)
		}else{
			//Run loader
            motor6!!.setPower(0.0)
            move.crStop(crserv1)
            move.crON(crserv0, -1.0) // Maybe flip this
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
            gamepad1.right_stick_x
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

      if(gamepad1.right_trigger > 0.1){
         motor4!!.setPower(gamepad1.right_trigger.toDouble())
         motor5!!.setPower(gamepad1.right_trigger.toDouble())
      }else{
         motor4!!.setPower(0.0)
         motor5!!.setPower(0.0)
      }

      if(gamepad1.y){
         //TODO load
      }

      if(gamepad1.a){
          motor4!!.setPower(1.0)
          motor5!!.setPower(1.0)
      } else {
          motor4!!.setPower(0.0)
          motor5!!.setPower(0.0)
      }

      if(gamepad1.b){
         //TODO pick up goal
      }

      else if (gamepad1.x){
         //TODO unload goal
      }


      if(gamepad1.left_bumper){
         move.stop(
            motor0, 
            motor1,
            motor2,
            motor3
         )
      }

   }


}
