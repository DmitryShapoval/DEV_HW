package com.example.calculator;

public class Model {
    private double countNumber = 0;
    private double memoryNumber = 0;

    private boolean isCheck = true;
    private boolean isResult = true;
    private boolean isrResultCount = true;
    private char operationClicked = '\0';

    public void setCountNumber(double value)
    {
        countNumber = value;
    }
    public double getCountNumber()
    {
        return countNumber;
    }

    public void setMemoryNumber(double value)
    {
        memoryNumber = value;
    }
    public double getMemoryNumber()
    {
        return memoryNumber;
    }

    public void setIsCheck(boolean value)
    {
        isCheck = value;
    }
    public boolean getIsCheck()
    {
        return isCheck;
    }

    public void setIsResult(boolean value)
    {
        isResult = value;
    }
    public boolean getIsResult()
    {
        return isResult;
    }

    public void setIsResultCount(boolean value)
    {
        isrResultCount = value;
    }
    public boolean getIsResultCount()
    {
        return isrResultCount;
    }

    public void setOperationClicked(char value)
    {
        operationClicked = value;
    }
    public char getOperationClicked()
    {
        return operationClicked;
    }
}
