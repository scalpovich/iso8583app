# Read Me First
An attempt to create an ISO8583 simulator.

**Only working function for now is the message generation of incoming transaction to FPM**

Thanks @Ratna for the initial code contribution from NAPAS project.

# Getting Started
1. Edit application.properties
    * fpm.socketserver.host -> IP address of FPM socket server
    * fpm.socketserver.port -> TCP port used by MPM socket server
    * fpm.socketserver.sync -> true if communication is synchronous otherwise, false
    * simulator.server.enabled -> currently set to false since simulator is not yet completed
    * simulator.socketserver.host -> IP address of simulator socket server (ignored for now)
    * simulator.socketserver.port -> TCP port used by simulator socket server (ignored for now)
    * simulator.socketserver.sync -> true if communication is synchronous otherwise, false (ignored for now)
1. Run bootRun
