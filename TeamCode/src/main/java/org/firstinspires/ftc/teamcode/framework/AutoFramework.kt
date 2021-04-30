package org.firstinspires.ftc.teamcode.framework
import com.qualcomm.robotcore.hardware.*
/**
* Shared code for auto modes
* GPL 3.0 licensed
**/
class AutoFramework(
   val motor0:DcMotor,
   val motor1:DcMotor,
   val motor2:DcMotor,
   val motor3:DcMotor,
   val servo0:Servo
){
   val move = Move()
   fun forward(){
      move.forward(
         motor0,
         motor1,
         motor2,
         motor3,
         -0.8.toFloat()
      )
   }

   fun left(){
      move.left(
         motor0,
         motor1,
         motor2,
         motor3,
          -0.5.toFloat()
      )

   }

   fun right(){
      move.right(
         motor0,
         motor1,
         motor2,
         motor3,
         -0.5.toFloat()
      )

   }

   fun back(){
      move.back(
         motor0,
         motor1,
         motor2,
         motor3,
          -0.8.toFloat()
      )

   }

   fun stop(){
      move.stop(
         motor0,
         motor1,
         motor2,
         motor3
      )
      motor1!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      motor1!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      motor0!!.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      motor0!!.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

   }

   fun shoot(){
       move.spin(
         motor0,
         motor1,
         motor2,
         motor3
      )
   }

   fun spin(){
       move.spinOtherWay(
         motor0,
         motor1,
         motor2,
         motor3
      )
   }

   fun spinBack(){
      move.spin(
         motor0,
         motor1,
         motor2,
         motor3
      )
   }

   fun initMove(){
      //TODO get everthing
      forward()
      Thread.sleep(3500)
      stop()
   }

   fun spinDropSpin(){

   }

   fun drop(){

   }


   


}
