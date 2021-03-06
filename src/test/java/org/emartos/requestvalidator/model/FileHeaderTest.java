package org.emartos.requestvalidator.model;

import org.emartos.requestvalidator.model.mother.FileMother;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileHeaderTest {
    private static final String[] allowedMediaTypes = new String[] {MimeType.JPG.value(),
            MimeType.PNG.value(), MimeType.PDF.value(), MimeType.WORD.value(),
            MimeType.OPEN_WORD.value(), MimeType.EXCEL.value(), MimeType.OPEN_EXCEL.value()};

    // HAPPY PATH TESTS
    @Test
    public void givenJPGImageAndJPGMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] jpgImage = FileMother.jpgImage();

        assertTrue(FileHeader.isValid(jpgImage, allowedMediaTypes));
    }

    @Test
    public void givenPNGImageAndPNGMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] pngImage = FileMother.pngImage();

        assertTrue(FileHeader.isValid(pngImage, allowedMediaTypes));
    }

    @Test
    public void givenPDFDocumentAndPDFMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] pdfDocument = FileMother.pdfDocument();

        assertTrue(FileHeader.isValid(pdfDocument, allowedMediaTypes));
    }

    @Test
    public void givenDOCDocumentAndDOCMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] docDocument = FileMother.docDocument();

        assertTrue(FileHeader.isValid(docDocument, allowedMediaTypes));
    }

    @Test
    public void givenDOCXDocumentAndDocMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] docxDocument = FileMother.docxDocument();

        assertTrue(FileHeader.isValid(docxDocument, allowedMediaTypes));
    }

    @Test
    public void givenXLSDocumentAndXLSMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] xlsDocument = FileMother.xlsDocument();

        assertTrue(FileHeader.isValid(xlsDocument, allowedMediaTypes));
    }

    @Test
    public void givenXLSXDocumentAndXLSXMimeTypeIsAllowedThenFileHeaderIsValidReturnsTrue() {
        byte[] xlsxDocument = FileMother.xlsxDocument();

        assertTrue(FileHeader.isValid(xlsxDocument, allowedMediaTypes));
    }

    // CORNER CASES TESTS
    @Test
    public void givenGIFImageAndGIFMimeTypeIsNotAllowedThenFileHeaderIsValidReturnsFalse() {
        byte[] gifImage = FileMother.gifImage();

        assertFalse(FileHeader.isValid(gifImage, allowedMediaTypes));
    }

    @Test
    public void givenHTMLDocumentAndHTMLMimeTypeIsNotAllowedThenFileHeaderIsValidReturnsFalse() {
        byte[] htmlDocument = FileMother.htmlDocument();

        assertFalse(FileHeader.isValid(htmlDocument, allowedMediaTypes));
    }

}
