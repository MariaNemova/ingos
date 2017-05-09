package ru.ingos.digitalmedicine.mvp.models;

public class RegistryModel {

    private String timeRegistry;
    private String nameService;
    private String addressClinic;

    public RegistryModel(String timeRegistry, String nameService, String addressClinic) {
        this.timeRegistry = timeRegistry;
        this.nameService = nameService;
        this.addressClinic = addressClinic;
    }

    public String getTimeRegistry() {
        return timeRegistry;
    }

    public void setTimeRegistry(String timeRegistry) {
        this.timeRegistry = timeRegistry;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAddressClinic() {
        return addressClinic;
    }

    public void setAddressClinic(String addressClinic) {
        this.addressClinic = addressClinic;
    }
}
