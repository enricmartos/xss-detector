package org.emartos.requestvalidator.model.mother;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

final public class FileMother {
    private static final Logger LOGGER = Logger.getLogger(FileMother.class.getName());

    // FILE EXTENSIONS
    // IMAGES
    private final static String JPG = ".jpg";
    private static final String PNG = ".png";
    private static final String GIF = ".gif";
    // DOCS
    private static final String PDF = ".pdf";
    private static final String DOC = ".doc";
    private static final String DOCX = ".docx";
    private static final String XLS = ".xls";
    private static final String XLSX = ".xlsx";
    private static final String HTML = ".html";


    // FILES PATHS
    // COMMON
    private static final String TEST_FILES_PATH =
            "src/test/resources";
    private static final String TEST_IMG_CONTEXT_PATH = "/images/TestImage";
    private static final String TEST_DOC_CONTEXT_PATH = "/documents/TestDoc";

    // IMAGES
    private static final String TEST_IMG_PATH = TEST_FILES_PATH.concat(TEST_IMG_CONTEXT_PATH);
    private static final String TEST_IMG_JPG_PATH = TEST_IMG_PATH.concat(JPG);
    private static final String TEST_IMG_PNG_PATH = TEST_IMG_PATH.concat(PNG);
    private static final String TEST_IMG_GIF_PATH = TEST_IMG_PATH.concat(GIF);

    // DOCS
    private static final String TEST_DOC_PATH = TEST_FILES_PATH.concat(TEST_DOC_CONTEXT_PATH);
    private static final String TEST_DOC_PDF_PATH = TEST_DOC_PATH.concat(PDF);
    private static final String TEST_DOC_DOC_PATH = TEST_DOC_PATH.concat(DOC);
    private static final String TEST_DOC_DOCX_PATH = TEST_DOC_PATH.concat(DOCX);
    private static final String TEST_DOC_XLS_PATH = TEST_DOC_PATH.concat(XLS);
    private static final String TEST_DOC_XLSX_PATH = TEST_DOC_PATH.concat(XLSX);
    private static final String TEST_DOC_HTML_PATH = TEST_DOC_PATH.concat(HTML);

    // IMAGES
    public static byte[] jpgImage() {
        return findByFilePath(TEST_IMG_JPG_PATH);
    }

    public static byte[] pngImage() {
        return findByFilePath(TEST_IMG_PNG_PATH);
    }

    public static byte[] gifImage() {
        return findByFilePath(TEST_IMG_GIF_PATH);
    }

    // DOCUMENTS
    public static byte[] pdfDocument() {
        return findByFilePath(TEST_DOC_PDF_PATH);
    }

    public static byte[] docDocument() {
        return findByFilePath(TEST_DOC_DOC_PATH);
    }

    public static byte[] docxDocument() {
        return findByFilePath(TEST_DOC_DOCX_PATH);
    }

    public static byte[] xlsDocument() {
        return findByFilePath(TEST_DOC_XLS_PATH);
    }

    public static byte[] xlsxDocument() {
        return findByFilePath(TEST_DOC_XLSX_PATH);
    }

    public static byte[] htmlDocument() {
        return findByFilePath(TEST_DOC_HTML_PATH);
    }

    private static byte[] findByFilePath(String filePath) {
        File file = new File(filePath);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IOException", e);
        }
        return bytes;
    }


}
