package org.emartos.requestvalidator.model;

public class FileMetadata {

    private String name;
    private String description;

    public FileMetadata() {
    }

    public FileMetadata(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "FileMetadata{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
