package test_data;

public class ComputerDataObject {
    private String processorType;
    private String ramType;
    private String os;
    private String hdd;

    public ComputerDataObject(String processorType, String ramType, String os, String hdd) {
        this.processorType = processorType;
        this.ramType = ramType;
    }
    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
}
