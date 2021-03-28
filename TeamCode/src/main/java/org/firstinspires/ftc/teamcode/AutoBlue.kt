package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.*
import org.firstinspires.ftc.teamcode.framework.*
const val PEG_LENGTH = 5000
const val INIT_LENGTH = 44000
const val SIDE_WIDE = -40000
const val SIDE_CLOSE= -15000
const val LENGTH_CLOSE = 38000
const val LENGTH_FAR = 84500
const val LENGTH_MIDDLE = 62500
const val BUFFER_LENGTH = 0
@Autonomous( name = "Auto Mode 2021")
class AutoBlue : LinearOpMode() {
   var motor0:DcMotor? = null 
   var motor1:DcMotor? = null 
   var motor2:DcMotor? = null 
   var motor3:DcMotor? = null
   var motor4:DcMotor? = null 
   var motor5:DcMotor? = null
   var servo0:Servo? = null
   var crservo1:CRServo? = null
   var autotools:AutoFramework? = null
   override fun runOpMode(){
        motor0 = hardwareMap.dcMotor["motor0"]
        motor1 = hardwareMap.dcMotor["motor1"]
        motor2 = hardwareMap.dcMotor["motor2"]
        motor3 = hardwareMap.dcMotor["motor3"]
        motor4 = hardwareMap.dcMotor["motor4"]
        motor5 = hardwareMap.dcMotor["motor5"]
        servo0 = hardwareMap.servo["servo0"]
        crservo1 = hardwareMap.crservo["crservo1"]
        motor0!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor1!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor2!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor3!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor0!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor0!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor1!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
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
       crservo1!!.setPower(-1.0)
       autotools!!.forward()
       sleep(2000)
       autotools!!.stop()
       autotools!!.shoot()
       autotools!!.right()
       while(motor0!!.getCurrentPosition() < BUFFER_LENGTH){ sleep(10) }
       autotools!!.stop()
       /*
      autotools!!.right()
      while(motor0!!.getCurrentPosition() < PEG_LENGTH) Thread.sleep(10);
      autotools!!.stop()
      autotools!!.shoot()
      autotools!!.right()
      while(motor0!!.getCurrentPosition() < PEG_LENGTH - 1500) Thread.sleep(10);
      autotools!!.stop()
      autotools!!.shoot()
      autotools!!.right()
      motor4!!.setPower(-1.0)
      motor5!!.setPower(-1.0)
      crservo1!!.setPower(-1.0)
      sleep(4000)
      servo1!!.setPosition(1.0)
      */
      autotools!!.stop()
      // Find the height 
      val height = move!!.getHeight(this)
      if (height == 4){
         autotools!!.forward()
         while(motor1!!.getCurrentPosition() < LENGTH_FAR){ sleep(10) }
         autotools!!.right()
         while(motor0!!.getCurrentPosition() > /* negative number */ SIDE_WIDE){ sleep(10) }
         autotools!!.stop()
         autotools!!.drop()
      }

      else if (height == 1){
         autotools!!.forward()
         while(motor1!!.getCurrentPosition() < LENGTH_MIDDLE){ sleep(10) }
         autotools!!.right()
         while(motor0!!.getCurrentPosition() > /* negative number */ SIDE_CLOSE){ sleep(10) }
         autotools!!.stop()
         autotools!!.drop()
      }

      else {
         autotools!!.forward()
         while(motor1!!.getCurrentPosition() < LENGTH_CLOSE){ sleep(10) }
         autotools!!.right()
         while(motor0!!.getCurrentPosition() > /* negative number */ SIDE_WIDE){ sleep(10) }
         autotools!!.stop()
         autotools!!.drop()

      }
      // move to center line from the place with the other goal

   }
}
