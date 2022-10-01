package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorOne {
    private MotorController motorOne;
    public MotorOne(){
        motorOne = new VictorSP(Constants.DriveTrain.MOTOR_ONE);

    }
    public void setMotor(double speed){
        motorOne.set(speed);

    }
}
