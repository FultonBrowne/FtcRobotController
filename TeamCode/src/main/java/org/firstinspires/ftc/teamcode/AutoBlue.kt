package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.*
import org.firstinspires.ftc.teamcode.framework.*
const val PEG_LENGTH = 5000
@Autonomous( name = "Auto Mode 2021")
class AutoBlue : LinearOpMode() {
   var motor0:DcMotor? = null 
   var motor1:DcMotor? = null 
   var motor2:DcMotor? = null 
   var motor3:DcMotor? = null
   var motor4:DcMotor? = null 
   var motor5:DcMotor? = null
   var servo0:Servo? = null
   var servo1:Servo? = null
   var autotools:AutoFramework? = null
   override fun runOpMode(){
        motor0 = hardwareMap.dcMotor["motor0"]
        motor1 = hardwareMap.dcMotor["motor1"]
        motor2 = hardwareMap.dcMotor["motor2"]
        motor3 = hardwareMap.dcMotor["motor3"]
        motor4 = hardwareMap.dcMotor["motor4"]
        motor5 = hardwareMap.dcMotor["motor5"]
        servo0 = hardwareMap.servo["servo0"]
        servo0 = hardwareMap.servo["servo1"]
        motor0!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor1!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor2!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor3!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor0!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor0!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        var move = Move()
        autotools = AutoFramework(
           motor0!!,
           motor1!!,
           motor2!!,
           motor3!!,
           servo0!!
        )
        waitForStart()

       motor4!!.setPower(-1.0)
       motor5!!.setPower(-1.0)
       autotools!!.forward()
       sleep(2000)
       autotools!!.stop()
       autotools!!.shoot()
      autotools!!.right()
      while(motor0!!.getCurrentPosition() < PEG_LENGTH) Thread.sleep(10);
      autotools!!.stop()
      autotools!!.shoot()
       motor0!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor0!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      autotools!!.right()
      while(motor0!!.getCurrentPosition() < PEG_LENGTH - 1500) Thread.sleep(10);
      autotools!!.stop()
      autotools!!.shoot()
      autotools!!.right()
      sleep(4000)
      servo1!!.setPosition(1.0)
      val height = move.getHeight(this)
      autotools!!.stop()

/*
      //TODO Move the stack, flip the servo, move forward, read the height - 17	 inches to the stack from final launch - move forward 1 inch
      // Find the height 

      val height = move!!.height()
      if (height == 4.toShort()){
         autotools!!.forward()
         Thread.sleep(15000)
         autotools!!.stop()
         autotools!!.drop()
         // autotools!!.roll() - gahhhhhhh I'm funny
         // autotools.spinDropSpin()
      }

      else if (height == 1.toShort()){
         autotools!!.forward()
         Thread.sleep(7500)
         autotools!!.right()
         Thread.sleep(2000)
         autotools!!.stop()
         autotools!!.drop()
         // autotools!!.roll() - gahhhhhhh I'm funny
         // autotools.spinDropSpin()
         // then pick up the other goal
      }

      else {
         autotools!!.forward()
         Thread.sleep(3000)
         autotools!!.stop()
         autotools!!.drop()
         // autotools!!.roll() - gahhhhhhh I'm funny
         // autotools.spinDropSpin()

      }
       move to center line from the place with the other goal
      */

   }
}
