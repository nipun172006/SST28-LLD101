public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        InputDevice pjInput = reg.getFirstOfType(InputDevice.class);
        if (pjInput instanceof PowerControl) {
            ((PowerControl) pjInput).powerOn();
        }
        pjInput.connectInput("HDMI-1");

        BrightnessControl lights = reg.getFirstOfType(BrightnessControl.class);
        lights.setBrightness(60);

        TemperatureControl ac = reg.getFirstOfType(TemperatureControl.class);
        ac.setTemperatureC(24);

        Scanner scan = reg.getFirstOfType(Scanner.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        for (PowerControl p : reg.getAllOfType(PowerControl.class)) {
            p.powerOff();
        }
    }
}
