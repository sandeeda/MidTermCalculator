package com.nseaf.mycalculator;

import android.widget.TextView;


public class Calculator{
    String numberString="0";
    String detailsString="";
    long intNumber;
    double realNumber;
    boolean isIntNumber=true;
    boolean numHasRadixPoint=false;
    long memoryInt=0;
    double memoryDouble=0.0;
    boolean isIntMemory=true;
//    long preOperand = 0;
    String operationString = "";
//    long intermediateResult = 1;

//    TextView tvNumber;
//    TextView tvDetails;
    BodmasCalc bodmasCalc;
    public Calculator() {
    }

    public void processNumber(int i) {
        if(numberString.length()<12) {  // limit of 12 digits
            intNumber = intNumber * 10 + i;
            numberString = String.valueOf(intNumber);
            if(detailsString=="")
                detailsString = "Input: "+i;
            else
                detailsString += " "+i;
        }
        else
            detailsString="The number is too long..";
    }

    public void clearClicked() {
        numberString="0";
        detailsString="";
        intNumber=0;
        realNumber=0.0;
        isIntNumber=true;
        numHasRadixPoint=false;
        operationString = "";
    }

    public void memPlusClicked() {
        if(isIntMemory){
            if(isIntNumber) {
                memoryInt += intNumber;
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntNumber=false;
                memoryDouble = memoryInt + realNumber;
            }
        }
    }

    public void multiplyOperation() {
        detailsString += " *";
        operationString += String.valueOf(intNumber)+ " " + "*";
        intNumber = 0;
        numberString = String.valueOf(intNumber);
        //detailsString = String.valueOf(intNumber);
    }
    public void addOperation() {
        detailsString += " +";

        operationString += String.valueOf(intNumber)+ " " + "+";
        intNumber = 0;
        numberString = String.valueOf(intNumber);
        //detailsString = String.valueOf(intNumber);
    }
    public void subtractOperation() {
        detailsString += " -";

        operationString += String.valueOf(intNumber)+ " " + "-";
        intNumber = 0;
        numberString = String.valueOf(intNumber);
        //detailsString = String.valueOf(intNumber);
    }
    public void divisionOperation() {
        detailsString += " /";

        operationString += String.valueOf(intNumber)+ " " + "/";
        intNumber = 0;
        numberString = String.valueOf(intNumber);
        //detailsString = String.valueOf(intNumber);
    }

    public void resultOperation() {
        //operationString.replaceFirst(".$","");
        operationString +=String.valueOf(intNumber);
        double result = BodmasCalc.solve_this(operationString);
        intNumber = (int) result;
        numberString = String.valueOf(result);
    }
}
