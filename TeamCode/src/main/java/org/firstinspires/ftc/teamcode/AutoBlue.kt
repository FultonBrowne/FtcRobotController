package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.*
import org.firstinspires.ftc.teamcode.framework.*
const val PEG_LENGTH = 5000
const val INIT_LENGTH = -55000
const val BUFFER = 19000
const val SIDE_WIDE = -32000 // to change
const val SIDE_CLOSE= -6000 // to change
const val LENGTH_CLOSE = -35000
const val LENGTH_FAR = -70000
const val LENGTH_MIDDLE = -50900
const val GOAL_LEFT_WIDE = 10000 //to change
const val GOAL_LEFT_MORE_WIDE = 24000 //to change
const val GOAL_LEFT_CLOSE= 15000 // to change
const val GOAL_LENGTH_CLOSE = 60000
const val GOAL_LENGTH_FAR = 97500
const val GOAL_LENGTH_MIDDLE = 85500
const val GOAL_RETURN_CLOSE = -62000
const val GOAL_RETURN_MIDDLE = -82500
const val GOAL_RETURN_FAR = -104500
const val ROTATE = -750
const val INIT_RIGHT = -20000
const val BUFFER_LEFT = 8500
const val INCH = 6000

@Autonomous( name = "Auto Mode 2021")
class AutoBlue : LinearOpMode() {
   var motor0:DcMotor? = null 
   var motor1:DcMotor? = null 
   var motor2:DcMotor? = null 
   var motor3:DcMotor? = null
   var motor4:DcMotor? = null 
   var motor5:DcMotor? = null
   var motor7:DcMotor? = null
   var servo0:Servo? = null
   var arm:Servo? = null
   var claw:Servo? = null
   var crservo1:CRServo? = null
   var servo12:Servo? = null
   var servo10:Servo? = null
   var autotools:AutoFramework? = null
   fun drop(){
     arm!!.setPosition(1.0)
     Thread.sleep(1000)
     claw!!.setPosition(1.0)
   }
   fun lift(){
     claw!!.setPosition(0.0)
     Thread.sleep(1000)
     arm!!.setPosition(0.0)
   }
   override fun runOpMode(){

/*
Auto mode redo:

First scan rings

pull forward go right and then shoot

go to the needed sqare (for the middle go left first

drop, go back, left, back, right, pickup
left, forward, right, forward, drop
*/
        motor0 = hardwareMap.dcMotor["motor0"]
        motor1 = hardwareMap.dcMotor["motor1"]
        motor2 = hardwareMap.dcMotor["motor2"]
        motor3 = hardwareMap.dcMotor["motor3"]
        motor4 = hardwareMap.dcMotor["motor4"]
        motor5 = hardwareMap.dcMotor["motor5"]
        servo0 = hardwareMap.servo["servo0"]
        servo12 = hardwareMap.servo["servo12"]
        servo10 = hardwareMap.servo["servo10"]
        motor7 = hardwareMap.dcMotor["motor7"]
        arm = hardwareMap.servo["servo3"]
        claw = hardwareMap.servo["servo4"]
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
        claw!!.setPosition(0.0)
        servo10!!.setPosition(0.1)
        waitForStart()
       val height = move!!.getHeight(this)
       motor4!!.setPower(-1.0)
       motor5!!.setPower(-1.0)
       motor7!!.setPower(-1.0)
       autotools!!.forward()
       while(motor1!!.getCurrentPosition() > INIT_LENGTH){ sleep(10) }
       autotools!!.stop()
       sleep(1000)
       autotools!!.right()
       while(motor0!!.getCurrentPosition() > INIT_RIGHT){sleep(10)}
       autotools!!.stop()
       autotools!!.spin()
       while(motor0!!.getCurrentPosition() < ROTATE){sleep(10)}
       autotools!!.stop()
       crservo1!!.setPower(-1.0)
       sleep(3000)
       crservo1!!.setPower(0.0)
       motor4!!.setPower(0.0)
       motor5!!.setPower(0.0)
       motor7!!.setPower(0.0)
       autotools!!.forward()
       while(motor1!!.getCurrentPosition() > BUFFER){ sleep(10) }
      autotools!!.stop()
      sleep(500)
      if (height == 4){
         autotools!!.forward()
         while(motor1!!.getCurrentPosition() > LENGTH_CLOSE){ sleep(10) }
         autotools!!.stop()
         drop()
         sleep(3000)
         autotools!!.left()
         while(motor0!!.getCurrentPosition() <  GOAL_LEFT_WIDE){ sleep(10) }
         autotools!!.back()
         while(motor1!!.getCurrentPosition() < /* negative number */ GOAL_LENGTH_FAR){ sleep(10) }
         autotools!!.stop()
         sleep(700)
         autotools!!.right()
         while(motor0!!.getCurrentPosition() > -0.25 * GOAL_LEFT_WIDE){ sleep(10) }     
         autotools!!.stop()
         lift()
         sleep(1000)
         autotools!!.left()
         while(motor0!!.getCurrentPosition() > 0.25 * GOAL_LEFT_WIDE){ sleep(10) }
         autotools!!.forward()
         while(motor1!!.getCurrentPosition() > GOAL_RETURN_FAR){ sleep(10) }
         autotools!!.stop()
         drop()
      }

      else if (height == 1){
         autotools!!.forward()
         while(motor1!!.getCurrentPosition() > LENGTH_CLOSE){ sleep(10) }
         autotools!!.stop()
         drop()
         sleep(3000)
         autotools!!.left()
         while(motor0!!.getCurrentPosition() <  GOAL_LEFT_WIDE){ sleep(10) }
         autotools!!.back()
         while(motor1!!.getCurrentPosition() < /* negative number */ GOAL_LENGTH_MIDDLE){ sleep(10) }
         autotools!!.stop()
         sleep(700)
         autotools!!.right()
         while(motor0!!.getCurrentPosition() > -0.50 * GOAL_LEFT_WIDE){ sleep(10) }     
         autotools!!.stop()
         lift()
         sleep(1000)
         autotools!!.left()
         while(motor0!!.getCurrentPosition() > 0.25 * GOAL_LEFT_WIDE){ sleep(10) }
         autotools!!.forward()
         while(motor1!!.getCurrentPosition() > GOAL_RETURN_MIDDLE){ sleep(10) }
         autotools!!.stop()
         drop()
      }

      else {
         autotools!!.forward()
         while(motor1!!.getCurrentPosition() > LENGTH_CLOSE){ sleep(10) }
         autotools!!.stop()
         drop()
         sleep(3000)
         autotools!!.left()
         while(motor0!!.getCurrentPosition() <  GOAL_LEFT_WIDE){ sleep(10) }
         autotools!!.back()
         while(motor1!!.getCurrentPosition() < /* negative number */ GOAL_LENGTH_CLOSE){ sleep(10) }
         autotools!!.stop()
         sleep(700)
         autotools!!.right()
         while(motor0!!.getCurrentPosition() >  -10500){ sleep(10) }     
         autotools!!.stop()
         lift()
         sleep(1000)
         autotools!!.right()
         while(motor0!!.getCurrentPosition() > -5100){ sleep(10) }
         autotools!!.forward()
         while(motor1!!.getCurrentPosition() > GOAL_RETURN_CLOSE){ sleep(10) }
         autotools!!.stop()
         drop()
      }
      // move to center line from the place with the other goal
      servo12!!.setPosition(1.0)

   }
}
