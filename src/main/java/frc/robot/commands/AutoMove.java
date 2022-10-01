package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class AutoMove extends CommandBase {
    Timer timey = new Timer();
    private DriveTrain drive;
    private double speed;
    private double time;
    public AutoMove(DriveTrain dt, double speed, double time){
        addRequirements(dt);
        drive = dt;
        this.speed = speed;
        this.time = time;

        
    }
    @Override
    public void initialize(){
        System.out.println("initializing autonomous");
        timey.start();
    }
    public void execute(){
        
        drive.ArcadeDrive(0.0, -speed);
    }
    @Override
    public void end(boolean interrupted) {
      drive.ArcadeDrive(0,0);
      timey.stop();
      timey.reset();
      
    }
    @Override
    public boolean isFinished(){
        return (timey.get() > time);

    }
    

}
