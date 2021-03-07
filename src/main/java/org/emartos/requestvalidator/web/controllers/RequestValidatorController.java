package org.emartos.requestvalidator.web.controllers;

import org.emartos.requestvalidator.configuration.PropertyResolver;
import org.emartos.requestvalidator.model.exceptions.InvalidFileException;
import org.emartos.requestvalidator.model.files.FileMetadata;
import org.emartos.requestvalidator.model.files.MimeType;
import org.emartos.requestvalidator.service.files.FileProcessor;
import org.emartos.requestvalidator.web.constants.RequestValidatorApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping(RequestValidatorApiConstants.REQUEST_VALIDATOR_API_PATH + RequestValidatorApiConstants.VERSION)
public class RequestValidatorController {

    @Autowired
    private PropertyResolver propertyResolver;

    private static final String[] allowedMediaTypes = new String[]{MimeType.JPG.value(),
            MimeType.PNG.value(), MimeType.PDF.value(), MimeType.WORD.value(),
            MimeType.OPEN_WORD.value(), MimeType.EXCEL.value(), MimeType.OPEN_EXCEL.value()};


    @Autowired
    private FileProcessor fileProcessor;

    @PostMapping(RequestValidatorApiConstants.FILE_METADATA_VALIDATOR_ENDPOINT)
    public ResponseEntity<String> validateFileMetadata(@RequestBody FileMetadata fileMetadata) {

        return new ResponseEntity<>(fileMetadata.toString(), HttpStatus.OK);
    }

    @PostMapping(RequestValidatorApiConstants.FILE_VALIDATOR_ENDPOINT)
    public ResponseEntity<String> validateFile(@RequestParam MultipartFile file) throws IOException, InvalidFileException {
        checkFile(file.getBytes());

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    private void checkFile(byte[] file) throws InvalidFileException {
        if (!fileProcessor.hasValidHeader(file, propertyResolver.getAllowedMediaTypes())) {
            throw new InvalidFileException("The content type of the file is not allowed");
        }
    }

}
