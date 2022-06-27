package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.ControlMode; 
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TeleopDrive extends CommandBase {
  private final Drivetrain driveTrain;
  private final GenericHID controller; 
  protected double forwardTorque, lateralTorque; 

  protected final WPI_VictorSPX leftFront  = new WPI_VictorSPX(Constants.LEFT_FRONT); 
  protected final WPI_VictorSPX rightFront = new WPI_VictorSPX(Constants.RIGHT_FRONT);   
  protected final WPI_VictorSPX rightFollower = new WPI_VictorSPX(Constants.RIGHT_FOLLOWER); 
  protected final WPI_VictorSPX leftFollower = new WPI_VictorSPX(Constants.LEFT_FOLLOWER); 
  protected final DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);

  @Override
  public void initialize() {
    forwardTorque = 0; 
    lateralTorque = 0; 
  }

  @Override
  public void execute() {
    forwardTorque = controller.getRawAxis(Constants.JOYSTICK_LEFT); 
    lateralTorque = controller.getRawAxis(Constants.JOYSTICK_RIGHT); 
    leftFollower.follow(leftFront); 
    rightFollower.follow(rightFront); 
    drive.arcadeDrive(lateralTorque, forwardTorque);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

  public TeleopDrive(Drivetrain sub, GenericHID controller) {
      driveTrain = sub; 
      this.controller = controller; 
  }
}
