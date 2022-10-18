package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoTurn extends CommandBase {
    Timer epicTimer = new Timer();
    private DriveTrain drive;
    private double speed;
    private double time;
    private final double secondsPerDegree = (1.0/38.0);

    public AutoTurn(DriveTrain dt,double degrees,double speed){
        addRequirements(dt);
        drive = dt;
        this.speed = speed;
        this.time = secondsPerDegree * speed * degrees;
        //this.time = degrees;
        if (degrees < 0){
            speed *= -1;
        } else if (degrees > 180) {
            
            degrees = 180 - (degrees-180) 
            speed *= -1;
        }
        

    }
    @Override
    public void initialize(){
        System.out.println("initializing auto turn");
        epicTimer.start();

    }
    public void execute(){
        drive.ArcadeDrive(speed, 0);
        
    }
    @Override
    public void end(boolean interrupted) {
        drive.ArcadeDrive(0,0);
        epicTimer.reset();
        epicTimer.stop();
      }
      @Override
      public boolean isFinished(){
          return (epicTimer.get() > time);
  
      }



    
}
