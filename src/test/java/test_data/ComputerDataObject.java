package test_data;

public class ComputerDataObject {
    private String processorType;
    private String ramType;
    private String os;
    private String hdd;
    private String softWare;

    public ComputerDataObject(String processorType, String ramType, String os, String hdd, String softWare) {
        this.processorType = processorType;
        this.ramType = ramType;
        this.os = os;
        this.hdd = hdd;
        this.softWare = softWare;
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
    public String getSoftWare() {
        return softWare;
    }

    public void setSoftWare(String softWare) {
        this.softWare = softWare;
    }


}
