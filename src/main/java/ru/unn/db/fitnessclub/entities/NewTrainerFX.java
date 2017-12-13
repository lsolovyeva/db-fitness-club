package ru.unn.db.fitnessclub.entities;

public class NewTrainerFX extends TrainerFX {
    private boolean isNameSet, isMobileSet, isSportKindSet;
    public NewTrainerFX() {
        super(new Trainer("<Name>", "<Mobile>", "<Sport kind>"));
        isNameSet = isMobileSet = isSportKindSet = false;
    }
    private boolean isAllSet() {
        return isNameSet && isSportKindSet && isMobileSet;
    }
    @Override
    public void setName(String name) {
        isNameSet = true;
        if (isAllSet()) super.setName(name);
        else trainer.setName(name);
    }
    @Override
    public void setMobile(String mobile) {
        isMobileSet = true;
        if (isAllSet()) super.setMobile(mobile);
        else trainer.setMobile(mobile);
    }
    @Override
    public void setSportKind(String sportKind) {
        isSportKindSet = true;
        if (isAllSet()) super.setSportKind(sportKind);
        else trainer.setSportKind(sportKind);
    }
}
