package fr.coding.zip.model;

import javax.swing.*;

public class chkboxAndValues {
    JCheckBox chkb ;
    int factorInt;
    double factorDouble;

    int value;

    public chkboxAndValues (JCheckBox chkb , int factorInt,int value){
        this.chkb = chkb;
        this.factorInt = factorInt;
        this.value =value;
    }
    public chkboxAndValues (JCheckBox chkb , double factorDouble, int value){
        this.chkb = chkb;
        this.factorDouble = factorDouble;
        this.value =value;
    }

    public JCheckBox getChkb() {
        return chkb;
    }

    public void setChkb(JCheckBox chkb) {
        this.chkb = chkb;
    }

    public int getFactorInt() {
        return factorInt;
    }

    public void setFactorInt(int factorInt) {
        this.factorInt = factorInt;
    }

    public double getFactorDouble() {
        return factorDouble;
    }

    public void setFactorDouble(double factorDouble) {
        this.factorDouble = factorDouble;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
