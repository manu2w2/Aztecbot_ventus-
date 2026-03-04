package org.firstinspires.ftc.teamcode.code

import android.view.InputDevice
import dev.nextftc.control.builder.controlSystem
import dev.nextftc.core.subsystems.Subsystem
import dev.nextftc.hardware.impl.MotorEx

object flywheel : Subsystem {
    private val flywheelmotor = MotorEx("flywheelmotor")
    private val controller = controlSystem {
        velPid(0,0,0,)


    }



}

