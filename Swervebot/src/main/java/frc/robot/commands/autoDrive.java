package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.ControlMode; 
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class AutoDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain driveTrain;
  protected double forwardTorque, lateralTorque; 

  protected final WPI_VictorSPX leftFront  = new WPI_VictorSPX(Constants.LEFT_FRONT); 
  protected final WPI_VictorSPX rightFront = new WPI_VictorSPX(Constants.RIGHT_FRONT);   
  protected final WPI_VictorSPX rightFollower = new WPI_VictorSPX(Constants.RIGHT_FOLLOWER); 
  protected final WPI_VictorSPX leftFollower = new WPI_VictorSPX(Constants.LEFT_FOLLOWER); 
  protected final DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);

  public AutoDrive(Drivetrain subsystem) {
    driveTrain = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    drive.arcadeDrive(100, 30);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
