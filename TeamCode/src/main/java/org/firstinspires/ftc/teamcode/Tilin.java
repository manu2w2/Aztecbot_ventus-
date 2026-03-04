package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Tilin extends OpMode {
    DcMotorEx Maubb, Manubb, ulibb, motorflywheel;
    int state = 0;

    @Override
    public void init() {
        Maubb = hardwareMap.get(DcMotorEx.class, "Maubb");
        Manubb = hardwareMap.get(DcMotorEx.class, "Manubb");
        ulibb = hardwareMap.get(DcMotorEx.class, "ulibb");
        Maubb.setDirection(DcMotorEx.Direction.REVERSE);
        motorflywheel = hardwareMap.get(DcMotorEx.class, "motorflywheel");
    }

    @Override
    public void loop() {

        if (state == 0) {
            Maubb.setPower(1);
            Manubb.setPower(1);
            ulibb.setPower(1);
        }

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
