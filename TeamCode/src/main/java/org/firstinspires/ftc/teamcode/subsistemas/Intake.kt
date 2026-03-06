package org.firstinspires.ftc.teamcode.subsistemas

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.DcMotor
import dev.nextftc.core.commands.utility.InstantCommand
import dev.nextftc.core.subsystems.Subsystem
import dev.nextftc.hardware.impl.MotorEx

@Configurable

object Intake : Subsystem{
    private val motor = MotorEx("intake")


    override fun initialize() {
        motor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        // initialization logic (runs on init)
    }
    val recoger = InstantCommand{motor.power = 0.85}.requires(this)
    val expulsar = InstantCommand{motor.power = -0.85}.requires(this)
    val recogerlento = InstantCommand{motor.power = 0.4}.requires(this)
    val expulsarlento = InstantCommand{motor.power = -0.4}.requires(this)
    val stop = InstantCommand{motor.power = 0}.requires(this)


    override fun periodic() {

    }
}



