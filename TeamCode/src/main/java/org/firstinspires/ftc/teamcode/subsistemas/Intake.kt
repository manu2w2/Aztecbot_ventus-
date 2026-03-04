package org.firstinspires.ftc.teamcode.subsistemas

import com.bylazar.configurables.annotations.Configurable
import dev.nextftc.core.subsystems.Subsystem
import dev.nextftc.hardware.impl.MotorEx

@Configurable

object Intake : Subsystem

    private val motor = MotorEx("intake")

