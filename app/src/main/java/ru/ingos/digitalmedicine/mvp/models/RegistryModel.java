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
    public String getNameService() {
        return nameService;
    }
    public String getAddressClinic() {
        return addressClinic;
    }


}
