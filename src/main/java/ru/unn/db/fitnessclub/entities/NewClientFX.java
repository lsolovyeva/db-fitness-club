package ru.unn.db.fitnessclub.entities;

public class NewClientFX extends ClientFX {
    private boolean isNameSet, isMobileSet, isAgeSet;
    public NewClientFX() {
        super(new Client("<Name>", "<Mobile>", (byte)0));
        isNameSet = isMobileSet = isAgeSet = false;
    }
    private boolean isAllSet() {
        return isNameSet && isAgeSet && isMobileSet;
    }
    @Override
    public void setName(String name) {
        isNameSet = true;
        if (isAllSet()) super.setName(name);
        else client.setName(name);
    }
    @Override
    public void setMobile(String mobile) {
        isMobileSet = true;
        if (isAllSet()) super.setMobile(mobile);
        else client.setMobile(mobile);
    }
    @Override
    public void setAge(String age) {
        isAgeSet = true;
        if (isAllSet()) super.setAge(age);
        else client.setAge(Byte.valueOf(age));
    }
}
