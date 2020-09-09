package com.val.riazanski;

public class ExtendStringBuilder {
    //fields
    StringBuilder stringBuilder;
    //constructors
    public ExtendStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;

    }
    //methods
    public ExtendStringBuilder delete(UnDeleteCommand command, int start, int end) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        command.setStartDeleted(start,deleted);
        Application.history.push(command);
        return this;
    }
    public ExtendStringBuilder append(UnAppend command, String str) {
        stringBuilder.append(str);
        command.setStringLength(str.length());
        Application.history.push(command);
        return this;

    }
    public ExtendStringBuilder reverse(UnReverse command) {
        this.stringBuilder.reverse();
        Application.history.push(command);
        return this;
    }

    public ExtendStringBuilder insert(UnInsert command, int start, String str) {
        this.stringBuilder.insert(start,str);
        Application.history.push(command);
        command.setStartEnd(start, str);
        return this;
    }

    public ExtendStringBuilder replace(UnReplace command, int start, int end, String str) {
        String replaced = stringBuilder.substring(start,end);
        this.stringBuilder.replace(start, end, str);
        Application.history.push(command);
        command.setStartEndStr(start, start + str.length(), replaced);
        return this;
    }
    @Override
    public String toString() {
        return this.stringBuilder.toString();
    }
    public ExtendStringBuilder delete(int start, int end) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        return this;
    }
    public ExtendStringBuilder reverse() {
        stringBuilder.reverse();
        return this;
    }
    public StringBuilder insert(int start, String str) {
        return this.stringBuilder.insert(start, str);
    }
    public int length() {
        return this.stringBuilder.length();
    }
    public  ExtendStringBuilder replace(int start, int end, String str) {
        this.stringBuilder.replace(start, end, str);
        return this;
    }
}
