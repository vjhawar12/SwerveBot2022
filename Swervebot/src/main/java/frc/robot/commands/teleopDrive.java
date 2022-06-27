package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController; 

public class TeleopDrive extends CommandBase {
  private final Drivetrain driveTrain;
  private final GenericHID controller; 
  protected final WPI_VictorSPX leftFront; 
  protected final WPI_VictorSPX rightFront; 
  protected final WPI_VictorSPX rightFollower; 
  protected final WPI_VictorSPX leftFollower; 
  protected final DifferentialDrive drive; 
  protected double forwardTorque, lateralTorque;

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

  public TeleopDrive(Drivetrain sub, GenericHID controller, WPI_VictorSPX one, WPI_VictorSPX two, WPI_VictorSPX three, WPI_VictorSPX four) {
      driveTrain = sub; 
      this.controller = controller; 
      leftFront = one; 
      rightFront = two; 
      leftFollower = three; 
      rightFollower = four; 
      drive = new DifferentialDrive(leftFront, rightFront);
  }
}
