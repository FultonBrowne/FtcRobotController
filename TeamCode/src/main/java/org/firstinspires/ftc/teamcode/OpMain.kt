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
   var servo1:Servo? = null
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
        servo1 = hardwareMap.servo["servo0"]
        arm = hardwareMap.servo["servo3"]
        claw = hardwareMap.servo["servo4"]
        motor0!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor0!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor0!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor1!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor2!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor3!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor4!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor5!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor6!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
   }


   override fun loop(){
        
		/* get a bool of yellow true or false */
        telemetry.addData(Integer.toString(motor0!!.getCurrentPosition()), "current position of motor0")
        telemetry.addData(Integer.toString(motor1!!.getCurrentPosition()), "current position of motor1")
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


      if(gamepad1.a){
         //move the belt and raise the *thing*
          motor4!!.setPower(-1.0)
          motor5!!.setPower(-1.0)
          servo1!!.setPosition(0.0) //Set the auto fire here
      } else { 
          motor4!!.setPower(0.0)
          motor5!!.setPower(0.0)
          servo1!!.setPosition(1.0)
      }

      if(gamepad1.b){
          motor6!!.setPower(-1.0) // add some auto thing?
      } else {
          motor6!!.setPower(0.0)
      }

      if(gamepad1.b){
           claw!!.setPosition(0.0)
           Thread.sleep(1000)
           arm!!.setPosition(0.0)
           
      }

      else if (gamepad1.x){
         arm!!.setPosition(1.0)
         Thread.sleep(1000)
         claw!!.setPosition(1.0)


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
