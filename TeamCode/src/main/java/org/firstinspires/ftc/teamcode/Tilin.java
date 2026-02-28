package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Tilin extends OpMode {
    DcMotorEx Maubb, Manubb, ulibb;

    @Override
    public void init() {
        Maubb = hardwareMap.get(DcMotorEx.class, "Maubb");
        Manubb = hardwareMap.get(DcMotorEx.class, "Manubb");
        ulibb = hardwareMap.get(DcMotorEx.class, "ulibb");
        Maubb.setDirection(DcMotorEx.Direction.REVERSE);

    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up) {
            Maubb.setPower(1);
            Manubb.setPower(1);
            ulibb.setPower(1);
        }
        else if (gamepad1.dpad_down) {
            Maubb.setPower(-1);
            Manubb.setPower(-1);
            ulibb.setPower(-1);
        }
        else {
            Maubb.setPower(0);
            Manubb.setPower(0);
            ulibb.setPower(0);

        }
    }
}
