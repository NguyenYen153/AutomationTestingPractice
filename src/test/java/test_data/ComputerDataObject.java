package test_data;

public class ComputerDataObject {
    private String processorType;
    private String ramType;

    public ComputerDataObject(String processorType, String ramType) {
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
}
