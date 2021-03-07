package org.emartos.requestvalidator.model.files;


import org.emartos.requestvalidator.model.files.mappers.FileHeaderMapper;

import java.util.Arrays;
import java.util.Optional;

public enum FileHeader {

    // File type (File header in Decimal from signed 2's complement) // File header in Hexadecimal
    JPG(new byte[]{-1, -40, -1}), // FF D8 FF
    PNG(new byte[]{-119, 80, 78}), // 89 50 4E
    PDF(new byte[]{37, 80, 68}), // 25 50 44
    MICROSOFT_OFFICE_DOC(new byte[]{-48, -49, 17}), // D0 CF 11
    OPEN_MICROSOFT_OFFICE_DOC(new byte[]{80, 75, 3}); // 50 4B 03

    private final byte[] value;

    FileHeader(byte[] value) {
        this.value = value;
    }

    /*
     * This method validates that the file type is one of the allowed mime types based on the header
     * information
     *
     * @param file File byte array to be validated
     * @param allowedMimeTypes the possible mime types that the file can be
     * @return whether the file is valid or not
     */
    public static boolean isValid(byte[] file, String[] allowedMimeTypes) {

        return Arrays.stream(allowedMimeTypes)
                .anyMatch(allowedMimeType -> isFileHeaderAllowed(fileHeaderBytes(file), allowedMimeType));
    }

    private static boolean isFileHeaderAllowed(byte[] fileHeaderBytes, String allowedMimeType) {
        Optional<FileHeader> allowedFileHeader = FileHeaderMapper.mapToFileHeader(allowedMimeType);

        return allowedFileHeader.isPresent() && Arrays.equals(fileHeaderBytes, allowedFileHeader.get().value);
    }

    private static byte[] fileHeaderBytes(byte[] file) {
        return new byte[]{file[0], file[1], file[2]};
    }

}
