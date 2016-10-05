package com.teamdev.javaclasses.aleksandrov.brainfuck.comand;

public class Memory {

    private final int[] cells;
    private int pointer = 0;

    public Memory(int memorySize) {

        cells = new int[memorySize];
    }

    public void setCurrentCellValue(final int newValue) {
        cells[pointer] = newValue;

    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public int getCellValue(int i){
        return cells[i];
    }

    public int getPointer() {
        return pointer;
    }

    public int getCurrentCellValue() {
        return cells[pointer];
    }

}
