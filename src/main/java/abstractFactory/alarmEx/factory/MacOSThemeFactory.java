package abstractFactory.alarmEx.factory;

import abstractFactory.alarmEx.alarm.Alarm;
import abstractFactory.alarmEx.alarm.MacOSAlarm;
import abstractFactory.alarmEx.button.Button;
import abstractFactory.alarmEx.button.MacOSButton;

public class MacOSThemeFactory implements ThemeFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Alarm createAlarm() {
        return new MacOSAlarm();
    }
}