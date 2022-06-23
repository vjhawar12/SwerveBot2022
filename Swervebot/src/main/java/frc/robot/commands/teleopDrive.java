package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TeleopDrive extends CommandBase {
    private final Drivetrain drive; 
    @Override
    public void initialize() {}
  
    @Override
    public void execute() {}
  
    @Override
    public void end(boolean interrupted) {}
  
    @Override
    public boolean isFinished() {
      return false;
    }

    public TeleopDrive(Drivetrain sub) {
        drive = sub; 
    }
}
