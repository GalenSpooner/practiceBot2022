package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.MotorOne;

public class Auto extends SequentialCommandGroup{
    public Auto(DriveTrain drive, MotorOne motorOne){
        //addCommands(new AutoMotor(motorOne,1,2),new AutoMove(drive,0.6,0.2));
       addCommands(new AutoTurn(drive,90, 0.6));
    }
 
    
}
