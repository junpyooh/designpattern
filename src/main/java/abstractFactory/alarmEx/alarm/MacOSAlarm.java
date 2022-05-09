package abstractFactory.alarmEx.alarm;

public class MacOSAlarm implements Alarm {
    @Override
    public String print() {
        return "맥 알람";
    }
}
