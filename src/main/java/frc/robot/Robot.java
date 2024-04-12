// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  WPI_TalonSRX LeftFront = new WPI_TalonSRX(1);
  WPI_TalonSRX LeftRear = new WPI_TalonSRX(2);
  WPI_TalonSRX RightFront = new WPI_TalonSRX(8);
  WPI_TalonSRX RightRear = new WPI_TalonSRX(7);
  public final Joystick joystick = new Joystick(0);
  DifferentialDrive robotDrive = new DifferentialDrive(
      (double output) -> {
        LeftFront.set(output);
        LeftRear.set(output);
      },
      (double output) -> {
        RightFront.set(output);
        RightRear.set(output);
      });
  public Robot() {
    
  }
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.

  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
   
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
  robotDrive.arcadeDrive(joystick.getRawAxis(0), joystick.getRawAxis(2));
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
