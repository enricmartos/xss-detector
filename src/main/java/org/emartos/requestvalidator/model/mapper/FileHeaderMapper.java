package org.emartos.requestvalidator.model.mapper;


import org.emartos.requestvalidator.model.FileHeader;
import org.emartos.requestvalidator.model.MimeType;

import java.util.Optional;

public class FileHeaderMapper {

    private FileHeaderMapper() {
    }

    public static Optional<FileHeader> mapToFileHeader(final String mimeType) {
        if (MimeType.JPG.value()
                .equals(mimeType)) {
            return Optional.of(FileHeader.JPG);
        }
        if (MimeType.PNG.value()
                .equals(mimeType)) {
            return Optional.of(FileHeader.PNG);
        }
        if (MimeType.PDF.value()
                .equals(mimeType)) {
            return Optional.of(FileHeader.PDF);
        }
        if (MimeType.WORD.value()
                .equals(mimeType)
                || MimeType.EXCEL.value()
                .equals(mimeType)) {
            return Optional.of(FileHeader.MICROSOFT_OFFICE_DOC);
        }
        if (MimeType.OPEN_WORD.value()
                .equals(mimeType)
                || MimeType.OPEN_EXCEL.value()
                .equals(mimeType)) {
            return Optional.of(FileHeader.OPEN_MICROSOFT_OFFICE_DOC);
        }
        return Optional.empty();

    }


}
