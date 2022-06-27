package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.ControlMode; 
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.Constants;

public class AutoDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"}) 
  private final Drivetrain driveTrain;
  protected final WPI_VictorSPX leftFront; 
  protected final WPI_VictorSPX rightFront; 
  protected final WPI_VictorSPX rightFollower; 
  protected final WPI_VictorSPX leftFollower; 
  protected final DifferentialDrive drive; 
  protected double forwardTorque, lateralTorque;


  public AutoDrive(Drivetrain subsystem, WPI_VictorSPX one, WPI_VictorSPX two, WPI_VictorSPX three, WPI_VictorSPX four) {
    driveTrain = subsystem;
    addRequirements(subsystem);
    leftFront = one; 
    rightFront = two; 
    leftFollower = three; 
    rightFollower = four; 
    drive  = new DifferentialDrive(leftFront, rightFront);
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
