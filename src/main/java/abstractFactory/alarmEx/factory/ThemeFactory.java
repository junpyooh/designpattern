package abstractFactory.alarmEx.factory;

import abstractFactory.alarmEx.alarm.Alarm;
import abstractFactory.alarmEx.button.Button;

public interface ThemeFactory {
    Button createButton();

    Alarm createAlarm();
}
