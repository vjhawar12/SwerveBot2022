package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final AutoDrive autoDrive = new AutoDrive(drivetrain);
  private final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT); 
  private final TeleopDrive teleopDrive = new TeleopDrive(drivetrain, joystick); 

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
