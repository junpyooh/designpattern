package abstractFactory.alarmEx;

import abstractFactory.alarmEx.factory.MacOSThemeFactory;

public class OSClient {
    public static void main(String args[]) {
        MacOSThemeFactory factory = new MacOSThemeFactory();

        System.out.println(factory.createAlarm());
        System.out.println(factory.createButton());
    }
}
