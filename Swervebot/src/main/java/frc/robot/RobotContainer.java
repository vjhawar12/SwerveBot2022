package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.TeleopDrive;
import com.ctre.phoenix.motorcontrol.ControlMode; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT); 
  protected final WPI_VictorSPX leftFront  = new WPI_VictorSPX(Constants.LEFT_FRONT); 
  protected final WPI_VictorSPX rightFront = new WPI_VictorSPX(Constants.RIGHT_FRONT);   
  protected final WPI_VictorSPX rightFollower = new WPI_VictorSPX(Constants.RIGHT_FOLLOWER); 
  protected final WPI_VictorSPX leftFollower = new WPI_VictorSPX(Constants.LEFT_FOLLOWER); 
  protected final DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);
  private final TeleopDrive teleopDrive = new TeleopDrive(drivetrain, joystick, leftFront, rightFront, leftFollower, rightFollower); 
  private final AutoDrive autoDrive = new AutoDrive(drivetrain, leftFront, rightFront, leftFollower, rightFollower); 

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {}

  public Command getAutonomousCommand() {
    return autoDrive;
  }

  public Command getTeleopCommand() {
    return teleopDrive; 
  }
}
