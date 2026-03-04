package org.firstinspires.ftc.teamcode.subsistemas

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.DcMotor
import dev.nextftc.control.KineticState
import dev.nextftc.control.builder.controlSystem
import dev.nextftc.control.feedback.PIDCoefficients
import dev.nextftc.control.feedforward.BasicFeedforwardParameters
import dev.nextftc.core.commands.delays.WaitUntil
import dev.nextftc.core.commands.groups.ParallelGroup
import dev.nextftc.core.subsystems.Subsystem
import dev.nextftc.hardware.controllable.RunToVelocity
import dev.nextftc.hardware.impl.MotorEx

@Configurable
object Flywheel : Subsystem {
    private val motor = MotorEx("flywheelmotor1")
    private val motor1 = MotorEx("flywheelmotor2").reversed()
    // aca los declaro


    var controlled = true
    const val TICKS_REV = 37.333
    // declaro varibles


    @JvmField var basicFFCoefficients = BasicFeedforwardParameters(0.0,0.0,0.0)
    @JvmField var velPIDCoefficients = PIDCoefficients(0.0,0.0,0.0)
    // declaro la variables que sirve para mi pid que puedo editar desde panels




        override fun initialize() {
            motor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
            motor1.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT

            controller.goal = KineticState()
    }
    // aqui configuro mis motores


    @JvmField
        val controller = controlSystem {
            velPid(velPIDCoefficients)
            basicFF(basicFFCoefficients)
        } // aca configuro mi controlador

        val shootervelocity
            get() = (motor.velocity + motor1.velocity)/2
        var VueltasD = 0
        val UmbralVueltas = 30
        val RevisarVueltasHastaUmbral = WaitUntil {
            if (VueltasD >= UmbralVueltas) {
                true
            } else { if(shootervelocity > (controller.goal.velocity - 10) && shootervelocity < (controller.goal.velocity + 40)){
                VueltasD++
                } else {
                VueltasD = 0
             }
                false
            }
         }

        val inicio = ParallelGroup(
            RunToVelocity(
                controller,
                (2000.0/60.0) * TICKS_REV,
                KineticState(Double.POSITIVE_INFINITY, 500.0, Double.POSITIVE_INFINITY)
                ).requires(this),
                RevisarVueltasHastaUmbral
            )
        val parar = RunToVelocity(controller, 0.0, KineticState(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)).requires(this)
        val reversa = RunToVelocity(controller, (-(1500.0/60.0) * TICKS_REV), KineticState(Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)).requires(this)




        override fun periodic() {
            if(controlled){

                val velocidad = KineticState(Double.POSITIVE_INFINITY, shootervelocity, Double.POSITIVE_INFINITY)
                val powermotors = controller.calculate(velocidad)
                motor1.power = powermotors
                motor.power = powermotors

            }

    }


}

