package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoTurn extends CommandBase {
    Timer epicTimer = new Timer();
    private DriveTrain drive;
    private double speed;
    private double time;
    private final double secondsPerDegree = (1.0/39.0);

    public AutoTurn(DriveTrain dt,double degrees,double speed){
        addRequirements(dt);
        drive = dt;
        this.speed = speed;
        this.time = secondsPerDegree * degrees;
        //this.time = degrees;

    }
    @Override
    public void initialize(){
        System.out.println("initializing auto turn");
        epicTimer.start();

    }
    public void execute(){
        drive.ArcadeDrive(speed, 0);
        System.out.println("line ");
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
