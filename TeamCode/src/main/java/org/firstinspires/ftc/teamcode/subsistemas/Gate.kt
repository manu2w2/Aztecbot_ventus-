package org.firstinspires.ftc.teamcode.subsistemas

import dev.nextftc.core.commands.delays.Delay
import dev.nextftc.core.commands.groups.SequentialGroup
import dev.nextftc.core.subsystems.Subsystem
import dev.nextftc.hardware.impl.ServoEx
import dev.nextftc.hardware.positionable.SetPosition
import kotlinx.coroutines.delay

object Gate : Subsystem {
    private val servo = ServoEx("gate")

    val abierto = SetPosition(servo, 0.0).requires(this)
    val cerrado = SetPosition(servo, 1.0).requires(this)

    override fun initialize() {
        // initialization logic (runs on init)
    }

    override fun periodic() {
        // periodic logic (runs every loop)
    }
}