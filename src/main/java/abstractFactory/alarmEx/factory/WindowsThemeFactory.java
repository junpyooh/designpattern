package abstractFactory.alarmEx.factory;

import abstractFactory.alarmEx.alarm.Alarm;
import abstractFactory.alarmEx.alarm.WindowsAlarm;
import abstractFactory.alarmEx.button.Button;
import abstractFactory.alarmEx.button.WindowsButton;

public class WindowsThemeFactory implements ThemeFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Alarm createAlarm() {
        return new WindowsAlarm();
    }
}