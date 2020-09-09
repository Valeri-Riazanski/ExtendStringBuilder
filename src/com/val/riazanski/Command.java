package com.val.riazanski;

abstract class Command {
    //fields
    ExtendStringBuilder stringBuilder;
    //constructors
    public Command(ExtendStringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }
    //methods
    abstract void unDo();
}

class UnDeleteCommand extends Command {
    //fields
    private final ExtendStringBuilder stringBuilder;
    String deleted;
    private int start;
    //constructors
    public UnDeleteCommand(ExtendStringBuilder stringBuilder) {
        super(stringBuilder);
        this.stringBuilder = stringBuilder;
    }

    //methods
    public void setStartDeleted(int start, String deleted) {
        this.start = start;
        this.deleted = deleted;
    }
    @Override
    public void unDo() {
        stringBuilder.insert(start, deleted);
    }
}
class UnAppend extends Command {
    private final ExtendStringBuilder stringBuilder;
    private int stringLength;
    //constructions
    public UnAppend(ExtendStringBuilder stringBuilder) {
        super(stringBuilder);
        this.stringBuilder = stringBuilder;
    }
    @Override
    public void unDo() {
        int end = stringBuilder.length();
        int start = end - stringLength;
        stringBuilder.delete(start, end);
    }
    public void setStringLength(int stringLength) {
        this.stringLength = stringLength;
    }
}
class UnReverse extends Command {
    //fields
    private final ExtendStringBuilder stringBuilder;
    //constructors
    public UnReverse(ExtendStringBuilder stringBuilder) {
        super(stringBuilder);
        this.stringBuilder = stringBuilder;
    }
    //methods
    public void unDo() {
        stringBuilder.reverse();
    }
}
class UnInsert extends Command {
    //fields
    private final ExtendStringBuilder stringBuilder;
    private int start;
    private String str;
    //constructors
    public UnInsert(ExtendStringBuilder stringBuilder) {
        super(stringBuilder);
        this.stringBuilder = stringBuilder;
    }
    @Override
    void unDo() {
        this.stringBuilder.delete(this.start, this.start + this.str.length());
    }
    //methods
    public void setStartEnd(int start, String str) {
        this.start = start;
        this.str = str;
    }
}
class UnReplace extends Command {
    //fields
    private final ExtendStringBuilder stringBuilder;
    private int start;
    private int end;
    private String str;
    //constructors
    public UnReplace(ExtendStringBuilder stringBuilder) {
        super(stringBuilder);
        this.stringBuilder = stringBuilder;
    }
    @Override
    void unDo() {
        if ((this.str != null) && (this.start != 0) && (this.end != 0)) {
            this.stringBuilder.replace(this.start, this.end, this.str);
        }
    }
    //methods
    public void setStartEndStr(int start, int end, String str) {
        this.start = start;
        this.end = end;
        this.str = str;
    }
}