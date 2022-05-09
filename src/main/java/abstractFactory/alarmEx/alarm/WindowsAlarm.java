package abstractFactory.alarmEx.alarm;

public class WindowsAlarm implements Alarm {
    @Override
    public String print() {
        return "윈도우 알람";
    }
}
