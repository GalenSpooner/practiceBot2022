package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.MotorOne;
public class AutoMotor extends CommandBase{
    Timer masterOfTime = new Timer();
    private MotorOne motorOne;
    private double time;
    private double speed;
    public AutoMotor(MotorOne m_one, double speed, double time){
        motorOne = m_one;
        this.speed = speed;
        this.time = time;

        

    }
    @Override
    public void initialize(){
        System.out.println("initializing auto motor");
        masterOfTime.start();

    }
    public void execute(){
       motorOne.setMotor(speed); 
    }   
    @Override
    public void end(boolean interrupted){
        motorOne.setMotor(0);
        masterOfTime.reset();
    }
    @Override
    public boolean isFinished(){
        return (masterOfTime.get() > time);
    }
}