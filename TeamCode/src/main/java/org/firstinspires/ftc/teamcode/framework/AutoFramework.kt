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
         -1.0.toFloat()
      )
   }

   fun left(){
      move.left(
         motor0,
         motor1,
         motor2,
         motor3
      )

   }

   fun right(){
      move.right(
         motor0,
         motor1,
         motor2,
         motor3,
         -1.0.toFloat()
      )

   }

   fun back(){
      move.back(
         motor0,
         motor1,
         motor2,
         motor3
      )

   }

   fun stop(){
      move.stop(
         motor0,
         motor1,
         motor2,
         motor3
      )

   }

   fun shoot(){
       servo0!!.setPosition(0.0)
       Thread.sleep(2000)
       servo0.setPosition(1.0)
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
