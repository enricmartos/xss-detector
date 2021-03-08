package org.emartos.requestvalidator.web.controllers;

import org.emartos.requestvalidator.configuration.PropertyResolver;
import org.emartos.requestvalidator.model.exceptions.InvalidFileException;
import org.emartos.requestvalidator.model.files.FileMetadata;
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
    private static final String NO_XSS_INJECTION = "No XSS injection during JSON deserialization";
    private static final String INVALID_FILE_EXCEPTION_MESSAGE = "The media type of the file is not allowed";
    private static final String NO_INVALID_FILE = "The media type of the file is allowed";

    @Autowired
    private PropertyResolver propertyResolver;

    @Autowired
    private FileProcessor fileProcessor;

    @PostMapping(RequestValidatorApiConstants.FILE_METADATA_VALIDATOR_ENDPOINT)
    public ResponseEntity<String> validateFileMetadata(@RequestBody FileMetadata fileMetadata) {

        return new ResponseEntity<>(NO_XSS_INJECTION, HttpStatus.OK);
    }

    @PostMapping(RequestValidatorApiConstants.FILE_VALIDATOR_ENDPOINT)
    public ResponseEntity<String> validateFile(@RequestParam MultipartFile file) throws IOException, InvalidFileException {
        checkFile(file.getBytes());

        return new ResponseEntity<>(NO_INVALID_FILE, HttpStatus.OK);
    }

    private void checkFile(byte[] file) throws InvalidFileException {
        if (!fileProcessor.hasValidHeader(file, propertyResolver.getAllowedMediaTypes())) {
            throw new InvalidFileException(INVALID_FILE_EXCEPTION_MESSAGE);
        }
    }

}
